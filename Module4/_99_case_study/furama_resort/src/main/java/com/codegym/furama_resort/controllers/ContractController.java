package com.codegym.furama_resort.controllers;

import com.codegym.furama_resort.models.*;
import com.codegym.furama_resort.models.dto.ContractDetailDto;
import com.codegym.furama_resort.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ResortServiceService resortServiceService;

    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AttachServiceService attachServiceService;

    @Autowired
    ContractDetailService contractDetailService;

    @ModelAttribute("employees")
    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }

    @ModelAttribute("attachServices")
    public List<AttachService> getAttachServiceList() {
        return attachServiceService.findAll();
    }

    @GetMapping(value = {"/", ""})
    public String contractList(@RequestParam(defaultValue = "") String search,
                               @RequestParam(defaultValue = "0") int page,
                               Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        search = search.trim();
        if (search.equals("")){
            model.addAttribute("contracts", contractService.findAll(pageable));
        } else {
            model.addAttribute("contracts", contractService.findAllByIdOrCustomerName(search, pageable));
            model.addAttribute("search", search);
        }
        return "/contract/list";
    }

    @GetMapping("/create")
    public ModelAndView viewCreateForm(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("employee", employeeService.findByUsername(principal.getName()));
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Principal principal, Model model) {
        contract.setEmployee(employeeService.findByUsername(principal.getName()));
        if (!contract.getEndDate().isAfter(contract.getStartDate())){
            bindingResult.addError(new FieldError("employee", "appUser.username", "Tên đăng nhập đã tồn tại"));
            bindingResult.addError(new FieldError("contract", "endDate", "Ngày kết thúc phải sau ngày bắt đầu"));
        }
        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        }
        contract = contractService.save(contract);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(contract);
        Map<AttachService, Integer> attachServicesMap = new LinkedHashMap<>();
        for (AttachService attachService : attachServiceService.findAll()) {
            ContractDetailKey id = new ContractDetailKey(contract.getId(), attachService.getId());
            if (contractDetailService.findById(id) != null){
                attachServicesMap.put(attachService, contractDetailService.findById(id).getQuantity());
            } else {
                attachServicesMap.put(attachService, 0);
            }
        }
        contractDetailDto.setAttachServices(attachServicesMap);
        model.addAttribute("contractDetailDto", contractDetailDto);
        return "/contract/contractDetail";
    }

    @PostMapping("/saveContractDetail")
    public String saveDetailContract(@Valid @ModelAttribute(name = "contractDetailDto") ContractDetailDto contractDetailDto){
        Set<AttachService> keySet = contractDetailDto.getAttachServices().keySet();
        for(AttachService key : keySet){
            ContractDetail contractDetail = new ContractDetail();
            contractDetail.setAttachService(key);
            contractDetail.setContract(contractDetailDto.getContract());
            contractDetail.setQuantity(contractDetailDto.getAttachServices().get(key));
            contractDetail.setId(new ContractDetailKey(contractDetailDto.getContract().getId(), key.getId()));
            if(contractDetailDto.getAttachServices().get(key) > 0){
                contractDetailService.save(contractDetail);
            }
            if (contractDetailDto.getAttachServices().get(key) == 0){
                contractDetailService.delete(contractDetail);
            }
        }
        return "redirect:/contract/view/" + contractDetailDto.getContract().getId() ;
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable int id){
        contractService.delete(id);
        return "redirect:/contract";
    }

    @GetMapping("/edit/{id}")
    public String editContract(@PathVariable int id, Model model){
        model.addAttribute("contract", contractService.findById(id));
        return "/contract/create";
    }

    @GetMapping("/view/{id}")
    public String viewContract(@PathVariable int id, Model model){
        double attachServicesAmount = 0;
        Contract contract = contractService.findById(id);
        for (ContractDetail contractDetail : contract.getContractDetails()){
            attachServicesAmount += contractDetail.getQuantity()*contractDetail.getAttachService().getCost();
        }
        double serviceAmount = ChronoUnit.DAYS.between(contract.getStartDate(), contract.getEndDate()) *contract.getResortService().getCost();
        double totalAmount = serviceAmount + attachServicesAmount;
        model.addAttribute("serviceAmount", serviceAmount);
        model.addAttribute("attachServicesAmount", attachServicesAmount);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("contract", contract);
        return "/contract/view";
    }

}
