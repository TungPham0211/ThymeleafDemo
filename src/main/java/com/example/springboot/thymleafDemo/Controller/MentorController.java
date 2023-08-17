package com.example.springboot.thymleafDemo.Controller;

import com.example.springboot.thymleafDemo.Entity.Mentor;
import com.example.springboot.thymleafDemo.Service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "api/v2/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @GetMapping
    public List<Mentor> getAllMentor(){
        return mentorService.getAllMentor();
    }



    @PostMapping
    public void addAnMentor(@RequestBody Mentor mentor){
        mentorService.addMentor(mentor);
    }



    @DeleteMapping(path ="{mentorID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteAnMentor(@PathVariable int mentorID){
        mentorService.deleteMentor(mentorID);
    }

    @PutMapping(path ="{mentorID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateMentor(@PathVariable ("mentorID") int mentor_id ,
                             @RequestParam (required = false) String name ,
                             @RequestParam (required = false) String email ,
                             @RequestParam (required = false) String phone_number){
        mentorService.updateMentor(mentor_id , name , email , phone_number);
    }
}
