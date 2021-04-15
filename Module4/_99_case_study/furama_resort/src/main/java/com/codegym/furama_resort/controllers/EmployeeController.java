package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.*;
import com.codegym.furama_resort.models.dto.AppUserDto;
import com.codegym.furama_resort.services.*;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

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
    public List<AppRole> getPathUri() {
        return appRoleService.findAll();
    }

//    @GetMapping(value = {"/",""})
//    public ModelAndView list(@RequestParam(defaultValue = "0") int page) {
////        ModelAndView modelAndView = new ModelAndView("employee/list");
////        Pageable pageable = PageRequest.of(page, 5);
////        modelAndView.addObject("employees", employeeService.findAll(pageable));
////        modelAndView.addObject("currentUri", "employee");
////        return modelAndView;
//    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("departments", departmentService.findAll());
        modelAndView.addObject("positions", positionService.findAll());
        modelAndView.addObject("educationDegrees", educationDegreeService.findAll());
        modelAndView.addObject("roles", appRoleService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, @RequestParam String confirmPassword, Model model, RedirectAttributes attributes) {
        if (appUserService.existById(employee.getAppUser().getUsername())) {
            bindingResult.addError(new FieldError("employee", "user.username", "Tên đăng nhập đã tồn tại"));
        }
        if (!employee.getAppUser().getPassword().equals(confirmPassword)) {
            bindingResult.addError(new FieldError("employee", "user.password", "Xác nhận mật khẩu không chính xác"));
        }
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("departments", departmentService.findAll());
            model.addAttribute("positions", positionService.findAll());
            model.addAttribute("educationDegrees", educationDegreeService.findAll());
            return "employee/create";
        }
        employee.getAppUser().setPassword(bCryptPasswordEncoder.encode(employee.getAppUser().getPassword()));
        employeeService.save(employee);
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setAppUser(employee.getAppUser());
        model.addAttribute("appUserDto", appUserDto);
        return "/employee/setRole";
    }
    @PostMapping("/setRole")
    public String setRole(@ModelAttribute AppUserDto appUserDto){
        for (AppRole role : appUserDto.getRoles()){
            UserRole userRole = new UserRole();
            userRole.setAppUser(appUserDto.getAppUser());
            userRole.setAppRole(role);
            userRole.setId(new UserRoleKey(appUserDto.getAppUser().getUsername(), role.getId()));
            userRoleService.save(userRole);
        }
        return "redirect:/employee/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/employee/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("departments", departmentService.findAll());
            model.addAttribute("positions", positionService.findAll());
            model.addAttribute("educationDegrees", educationDegreeService.findAll());
            return "employee/edit";
        }
        employeeService.save(employee);
        return "redirect:/employee/";
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
//    @ExceptionHandler(Exception.class)
//    public String viewErrorPage(){
//        return "error-page";
//    }
}
