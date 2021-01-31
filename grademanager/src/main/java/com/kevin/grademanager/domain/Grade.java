package com.kevin.grademanager.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="grade")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private String student_name;
	private String subject_name;
	private String grade;
	private String approved;
	
	@DBRef(lazy=true)
	private Student student;
	@DBRef(lazy=true)
	private Subject subject;
	
	public Grade() {
	}
	
	

	public Grade(String id, Date date, String grade, String approved, Student student, Subject subject) {
		super();
		this.id = id;
		this.date = date;
		this.grade = grade;
		this.approved = approved;
		this.student = student;
		this.student_name = student.getStudent_name();
		this.subject = subject;
		this.subject_name = subject.getSubject_name();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
