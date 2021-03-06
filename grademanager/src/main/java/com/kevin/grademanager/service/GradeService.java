package com.kevin.grademanager.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.grademanager.domain.Grade;
import com.kevin.grademanager.dto.GradeDTO;
import com.kevin.grademanager.repository.GradeRepository;
import com.kevin.grademanager.service.exception.ObjectNotFoundException;    

@Service
public class GradeService {
   

	@Autowired
	private GradeRepository repo; 
	
	public List<Grade> findAll(){
		return repo.findAll();
	}
	
	public Grade findById(String id) {
		Optional<Grade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Grade insert(Grade obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Grade update(Grade obj) {
		Grade newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Grade newObj, Grade obj) {
		newObj.setDate(obj.getDate());
		newObj.setSubject(obj.getSubject());
		newObj.setGrade(obj.getGrade());
		newObj.setApproved(obj.getApproved());
		newObj.setStudent(obj.getStudent());
	}

	public Grade fromDTO(GradeDTO objDto) {
		return new Grade(objDto.getId(), findById(objDto.getId()).getDate(), objDto.getSubject(), objDto.getGrade(), objDto.getApproved(), objDto.getStudent());
	}
	
	
	// Esse formato de data está como exemplo
	public Grade fromNewDTO(GradeDTO objNewDto) throws ParseException {
		return new Grade(null, objNewDto.getDate(), objNewDto.getSubject(), objNewDto.getGrade(), objNewDto.getApproved(), objNewDto.getStudent());
	}
}
