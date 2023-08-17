package com.example.springboot.thymleafDemo;

import com.example.springboot.thymleafDemo.Entity.Intern;
import com.example.springboot.thymleafDemo.Entity.Mentor;
import com.example.springboot.thymleafDemo.Repository.InternRepository;
import com.example.springboot.thymleafDemo.Repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ThymleafDemoApplication implements CommandLineRunner {


	@Autowired
	InternRepository internRepository;
	@Autowired
	MentorRepository mentorRepository;
	public static void main(String[] args) {
		SpringApplication.run(ThymleafDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Mentor LuongHuy = new Mentor(
				1,
				"Luong Huy",
				22,
				"LuongHuy@gmail.com", "0123"
		);
		Mentor KieuDung = new Mentor(
				2,
				"Kieu Dung",
				25, "KieuDung@gmail.com", "0132"
		);

		mentorRepository.saveAll(List.of(LuongHuy, KieuDung));
		Intern intern = new Intern(
				1,
				"PhamSonTung",
				22,
				"PTIT",
				"hokagedetu@gmail.com",
				"0985176796"
		);
		Intern intern1 = new Intern(
				2,
				"Fita",
				22,
				"PTIT",
				"CeoDeTam@gmail.com",
				"08484582147"
		);


		Mentor MinhHung = new Mentor(3,
				"Minh Hung",
				22, "HungVT7@gmail.com", "0231"
		);
		Intern intern2 = new Intern(
				3,
				"Far Away",
				22,
				"PTIT",
				"uchihaitachi@gmail.com",
				"0579645810"
		);

		Intern intern3 = new Intern(
				4,
				"FarJAway",
				23,
				"PTIT",
				"Helloworld@gmail.com",
				"07944581236"
		);




		LuongHuy.addIntern(intern);
		KieuDung.addIntern(intern1);
		MinhHung.addIntern(intern2);
		MinhHung.addIntern(intern3);
		mentorRepository.save(MinhHung);
		internRepository.saveAll(List.of(intern, intern1));
		internRepository.saveAll(List.of(intern2, intern3));

	}
}
