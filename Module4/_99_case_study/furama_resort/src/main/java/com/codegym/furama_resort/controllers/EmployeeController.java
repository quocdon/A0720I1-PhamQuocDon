package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.*;
import com.codegym.furama_resort.models.dto.AppUserDto;
import com.codegym.furama_resort.services.*;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EmbeddedId;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private AppRoleService appRoleService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ModelAttribute("appRoles")
    public List<AppRole> getAppRoles() {
        return appRoleService.findAll();
    }

    @ModelAttribute("departments")
    public List<Department> getDepartments(){
        return departmentService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> getPositions(){
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> getEducationDegrees(){
        return educationDegreeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, @RequestParam String confirmPassword, Model model, RedirectAttributes attributes) {
        if (appUserService.existById(employee.getAppUser().getUsername())) {
            bindingResult.addError(new FieldError("employee", "appUser.username", "Tên đăng nhập đã tồn tại"));
        }
        if (!employee.getAppUser().getPassword().equals(confirmPassword)) {
            bindingResult.addError(new FieldError("employee", "appUser.password", "Xác nhận mật khẩu không chính xác"));
        }
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        }
        employee.getAppUser().setPassword(bCryptPasswordEncoder.encode(employee.getAppUser().getPassword()));
        employeeService.save(employee);
//        set user role default is ROLE_NHANVIEN
        UserRole userRole = new UserRole();
        userRole.setId(new UserRoleKey(employee.getAppUser().getUsername(), 3));
        userRole.setAppUser(employee.getAppUser());
        userRole.setAppRole(appRoleService.findById(3));
        userRoleService.save(userRole);

//        convert from UserRole to AppRole and add to appUserDto
        Set<AppRole> currentRoles = new HashSet<>();
        currentRoles.add(appRoleService.findById(3));

//        Send user info to setRole page
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setAppUser(employee.getAppUser());
        appUserDto.setRoles(currentRoles);
        model.addAttribute("appUserDto", appUserDto);
        return "/employee/setRole";
    }

    @PostMapping("/setRole")
    @Transactional
    public String setRole(@ModelAttribute AppUserDto appUserDto) {
        userRoleService.deleteAllByUsername(appUserDto.getAppUser().getUsername());
        for (AppRole role : appUserDto.getRoles()) {
            UserRole userRole = new UserRole();
            userRole.setAppUser(appUserDto.getAppUser());
            userRole.setAppRole(role);
            userRole.setId(new UserRoleKey(appUserDto.getAppUser().getUsername(), role.getId()));
            userRoleService.save(userRole);
        }
        return "redirect:/employee/view/" + appUserDto.getAppUser().getEmployee().getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        try {
            employeeService.delete(id);
        } catch (SQLIntegrityConstraintViolationException e){
            return "redirect:/employee/delete-error";
        }

        return "redirect:/employee/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        }
        employeeService.save(employee);
        Set<AppRole> currentRoles = new HashSet<>();
        if (employee.getAppUser().getUserRoles() != null){
            for(UserRole userRole : employee.getAppUser().getUserRoles()){
                currentRoles.add(userRole.getAppRole());
            }
        }
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setAppUser(employee.getAppUser());
        appUserDto.setRoles(currentRoles);
        model.addAttribute("appUserDto", appUserDto);
        return "/employee/setRole";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/employee/";
        } else {
            model.addAttribute("employee", employee);
            return "employee/view";
        }
    }

    @GetMapping(value = {"", "/"})
    public ModelAndView search(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "0") int page) {
        search = search.trim();
        ModelAndView modelAndView = new ModelAndView("employee/list");
        Pageable pageable = PageRequest.of(page, 5);
        if (search.equals("")) {
            modelAndView.addObject("employees", employeeService.findAll(pageable));
            return modelAndView;
        } else {
            modelAndView.addObject("search", search);
            modelAndView.addObject("employees", employeeService.findByName(search, pageable));
            return modelAndView;
        }
    }

    @GetMapping("/delete-error")
    public String sqlDeleteHandler(){
        return "sql-error-page";
    }

    @ExceptionHandler(Exception.class)
    public String viewErrorPage(HttpServletRequest request, Exception exception) {
        return "error-page";
    }



}
