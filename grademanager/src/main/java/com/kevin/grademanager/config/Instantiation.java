package com.kevin.grademanager.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kevin.grademanager.domain.Grade;
import com.kevin.grademanager.repository.GradeRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private GradeRepository gradeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		gradeRepository.deleteAll();

		Grade rodrigo_grade = new Grade(null, sdf.parse("31/01/2021"), "Física", "7.3", "Sim", "Rodrigo Rodrigues");
		Grade carlos_grade = new Grade(null, sdf.parse("31/01/2021"), "Português", "2.3", "Sim", "Carlos Almeida");
		Grade marcos_grade = new Grade(null, sdf.parse("30/01/2021"), "Português", "2.3", "Sim", "Marcos Espindola");
		Grade joana_grade = new Grade(null, sdf.parse("30/01/2021"), "Geografia", "8.3", "Sim", "Joana Dark");
		Grade marianna_grade = new Grade(null, sdf.parse("01/02/2021"), "Matemática", "9.3", "Sim", "Marianna Silva");
		
		gradeRepository.saveAll(Arrays.asList(rodrigo_grade, carlos_grade, marcos_grade, joana_grade, marianna_grade));
		
	}
}