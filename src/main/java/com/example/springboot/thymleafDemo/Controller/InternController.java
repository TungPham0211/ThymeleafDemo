package com.example.springboot.thymleafDemo.Controller;

import com.example.springboot.thymleafDemo.Entity.Intern;
import com.example.springboot.thymleafDemo.Service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/intern")
public class InternController {

    @Autowired
    InternService internService;

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Intern> theEmployees = internService.getAllIntern();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "Employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Intern theEmployee = new Intern();
        theModel.addAttribute("employee" , theEmployee);

        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Intern intern){
        internService.addIntern(intern);
        return "redirect:/employees/list";

    }

    @GetMapping
    public List<Intern> getAllIntern(){
        return internService.getAllIntern();
    }


    @PostMapping
    public void addAnIntern(@RequestBody Intern intern){
        internService.addIntern(intern);
    }

    @PostMapping("{mentor_id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void addInternManaged(@RequestBody Intern intern , @PathVariable int mentor_id){
        internService.addInternManaged(intern , mentor_id);
    }



    @DeleteMapping(path = "{intern_id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteIntern(@PathVariable int intern_id){
        internService.deleteIntern(intern_id);
    }

    @PutMapping(path = "{intern_id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateInternName(@PathVariable ("intern_id")int intern_id,
                                 @RequestParam (required = false)String name ,
                                 @RequestParam (required = false)String email ,
                                 @RequestParam (required = false) String phone_number){
        internService.updateIntern(intern_id , name , email , phone_number);
    }
}
