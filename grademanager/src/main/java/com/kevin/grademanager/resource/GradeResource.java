package com.kevin.grademanager.resource;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kevin.grademanager.domain.Grade;
import com.kevin.grademanager.dto.GradeDTO;
import com.kevin.grademanager.service.GradeService;

@RestController
@RequestMapping(value="/grades")
class GradeResource {
	
	@Autowired
	private GradeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GradeDTO>> findAll() {
		List<Grade> list = service.findAll();
		List<GradeDTO> listDto = list.stream().map(x -> new GradeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<GradeDTO> findById(@PathVariable String id) {
		Grade obj = service.findById(id);
		return ResponseEntity.ok().body(new GradeDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody GradeDTO objNewDto) throws ParseException {
		Grade obj = service.fromNewDTO(objNewDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> Update(@RequestBody GradeDTO objDto, @PathVariable String id) {
		Grade obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
