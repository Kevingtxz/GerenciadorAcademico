package com.kevin.grademanager.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.kevin.grademanager.domain.Grade;

public class GradeDTO{
	
	private String id;
	private String subject;
	private String grade;
	private String approved;
	private String student;
	private Date date;
	
	public GradeDTO() {
	}

	public GradeDTO(String id, String subject, String grade, String approved, String student) {
		super();		
		this.id = id;
		this.subject= subject;
		this.grade = grade;
		this.approved = approved;
		this.student = student;
	}

	public GradeDTO(String subject, String grade, String approved, String student) throws ParseException {
		super();		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		this.id = null;
		this.date = sdf.parse("01/02/2021");
		this.subject= subject;
		this.grade = grade;
		this.approved = approved;
		this.student = student;
	}

	public GradeDTO(Grade grade) {
		super();
		this.id = grade.getId();
		this.subject = grade.getSubject();
		this.grade = grade.getGrade();
		this.approved = grade.getApproved();
		this.student = grade.getStudent();
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject= subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
