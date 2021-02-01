package com.kevin.grademanager.dto;

import java.io.Serializable;

// Está anotado como coleção apenas para demonstração, a classe Student deve estar em outro microserviço

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Somente para exemplo

@Document(collection="student")
public class StudentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String student_name;
	
	public StudentDTO(){
	}

	public StudentDTO(String id, String student_name) {
		super();
		this.id = id;
		this.student_name = student_name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
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
		StudentDTO other = (StudentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
