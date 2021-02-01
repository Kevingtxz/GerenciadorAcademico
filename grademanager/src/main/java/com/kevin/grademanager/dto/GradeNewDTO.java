package com.kevin.grademanager.dto;

public class GradeNewDTO{
	
	private String subject;
	private String grade;
	private String approved;
	private StudentDTO student;
	
	public GradeNewDTO() {
	}

	public GradeNewDTO(String subject, String grade, String approved, StudentDTO student) {
		super();
		this.subject= subject;
		this.grade = grade;
		this.approved = approved;
		this.student = student;
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

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
}
