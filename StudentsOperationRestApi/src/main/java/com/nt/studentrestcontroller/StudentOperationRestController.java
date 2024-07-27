package com.nt.studentrestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Student;
import com.nt.service.IStudentService;

@RestController
@RequestMapping("/student-api")
public class StudentOperationRestController {
	@Autowired
	private IStudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student st){
		
		try {
			return new ResponseEntity<String>(studentService.registerStudent(st),HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> findAllStudent(){
		
		try {
			return new ResponseEntity<Object>(studentService.findAllStudents(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Object> findStudentById(@PathVariable Integer id){
		
		try {
			return new ResponseEntity<Object>(studentService.findById(id),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student st){
			return new ResponseEntity<String>(studentService.updateStudent(st),HttpStatus.OK);
	}//method
	
	
	
	@PatchMapping("/updatephone/{id}/{phone}")
	public ResponseEntity<Object> updateStudentPhone(@PathVariable Integer id,@PathVariable Long phone){
			return new ResponseEntity<Object>(studentService.updateStudentPhoneNo(id, phone),HttpStatus.OK);
	}//method
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable Integer id){
			return new ResponseEntity<String>(studentService.deleteById(id),HttpStatus.OK);
	}//method
	
	
	
	

}
