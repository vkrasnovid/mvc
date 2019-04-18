package com.vkrasnovid.mvc.controller;

import com.vkrasnovid.mvc.model.Employee;
import com.vkrasnovid.mvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "employees")
    public String allEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.getAllEmployees());
        return "employee";
    }

    @PostMapping("employee/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        if (employee.getAge() != null && employee.getName() != null) {
            if (employee.getId() == null) {
                this.employeeService.addEmployee(employee);
            } else {
                this.employeeService.updateEmployee(employee);
            }
        }

        return "redirect:/employees";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping("/edit/{id}")
    public String editEmployee (@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.getAllEmployees());
        return "employee";
    }

    @GetMapping("search")
    public ModelAndView searching(){
        return new ModelAndView("search", "employee", new Employee());
    }

    @PostMapping("/findEmployee")
    public ModelAndView searching(@ModelAttribute("employee") Employee employee){
        return new ModelAndView("search", "foundedEmployees",
                this.employeeService.findEmployeeByName(employee.getName()));
    }
}
