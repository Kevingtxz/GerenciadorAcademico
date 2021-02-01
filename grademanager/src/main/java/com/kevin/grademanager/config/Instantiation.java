package com.kevin.grademanager.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kevin.grademanager.repository.GradeRepository;
import com.kevin.grademanager.repository.StudentRepository;
import com.kevin.grademanager.domain.Grade;
import com.kevin.grademanager.dto.StudentDTO;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		gradeRepository.deleteAll();
		studentRepository.deleteAll();
		
		StudentDTO rodrigo = new StudentDTO("1", "Rodrigo Rodrigues");
		StudentDTO carlos = new StudentDTO("2", "Carlos Almeida");
		StudentDTO marcos = new StudentDTO("3", "Marcos Espindola");
		StudentDTO joana = new StudentDTO("4", "Joana Dark");
		StudentDTO marianna = new StudentDTO("5", "Marianna Silva");
		
		studentRepository.saveAll(Arrays.asList(rodrigo, carlos, marcos, joana, marianna));

		Grade rodrigo_grade = new Grade(null, sdf.parse("31/01/2021"), "Física", "7.3", "Sim", rodrigo);
		Grade carlos_grade = new Grade(null, sdf.parse("31/01/2021"), "Português", "2.3", "Sim", carlos);
		Grade marcos_grade = new Grade(null, sdf.parse("30/01/2021"), "Português", "2.3", "Sim", marcos);
		Grade joana_grade = new Grade(null, sdf.parse("30/01/2021"), "Geografia", "8.3", "Sim", joana);
		Grade marianna_grade = new Grade(null, sdf.parse("01/02/2021"), "Matemática", "9.3", "Sim", marianna);
		
		gradeRepository.saveAll(Arrays.asList(rodrigo_grade, carlos_grade, marcos_grade, joana_grade, marianna_grade));
		
	}
}