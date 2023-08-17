package com.example.springboot.thymleafDemo.Service;

import com.example.springboot.thymleafDemo.Entity.Mentor;
import com.example.springboot.thymleafDemo.Repository.MentorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MentorService {

    @Autowired
    MentorRepository mentorRepository;

    public List<Mentor> getAllMentor(){
        return mentorRepository.findAll();
    }



    public void addMentor(Mentor mentor){
        Optional<Mentor> mentorOptional = mentorRepository.findMentorByEmail(mentor.getEmail());
        if(mentorOptional.isPresent()){
            throw new IllegalStateException("email is taken!");
        }
        mentorRepository.save(mentor);
        System.out.println(mentor);
    }



    public void deleteMentor(int mentor_id){
        boolean exists = mentorRepository.existsById(mentor_id);
        if(!exists){
            throw new IllegalStateException("Mentor with ID :" + mentor_id + "doesn't exists");
        }else{
            mentorRepository.deleteById(mentor_id);
        }
    }

    @Transactional
    public void updateMentor(int mentor_id , String name , String email , String phone_number){
        Mentor mentor = mentorRepository.findById(mentor_id)
                .orElseThrow(() -> new IllegalStateException("Mentor with ID :" + mentor_id + "doesn't exists"));
        if(name != null && name.length() > 0 && !Objects.equals(name , mentor.getMentor_name())){
            mentor.setMentor_name(name);
        }

        Optional<Mentor> mentorOptional = mentorRepository.findMentorByEmail(mentor.getEmail());
        if(mentorOptional.isPresent()){
            throw new IllegalStateException("email is taken!");
        }else if(email != null && email.length() > 0 && !Objects.equals(email , mentor.getEmail())){
            mentor.setEmail(email);
        }

        if(phone_number != null && phone_number.length() > 0 && !Objects.equals(phone_number , mentor.getPhoneNumber())){
            mentor.setPhoneNumber(phone_number);
        }
    }
}
