package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.exception.StudentNotFound;
import com.nt.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private IStudentRepository studentrepo;

	
	@Override
	public String registerStudent(Student st) {
		return "Student save with the id "+studentrepo.save(st).getSid();
	}//method
	
	
	@Override
	public List<Student> findAllStudents() {	
		return studentrepo.findAll();
	}//method
	
	
	@Override
	public Student findById(int id) {
		return studentrepo.findById(id)
				 .orElseThrow(()->new StudentNotFound("Student not with this id"+id));
	}//method

	
	
    @Override
	public String updateStudent(Student st) {
    	
	studentrepo.findById(st.getSid())
			.orElseThrow(()->new StudentNotFound("Student Not with id= "+st.getSid()));
		
		
		  //save 
			studentrepo.save(st);
			return "student details updated";	
    }//method
    
    	
	@Override
	public String updateStudentPhoneNo(int id, long newPhoneNumber) {
		
	Student st=studentrepo.findById(id)
			.orElseThrow(()->new StudentNotFound("Student Not with id= "+id));

		   //if found update set new Phone Number
			 st.setPhoneno(newPhoneNumber);
			
			//save updated Student
			studentrepo.save(st);
		
		return "student Details Updated";
	}//method


	
	@Override
	public String deleteById(int id){
		studentrepo.findById(id)
		.orElseThrow(()->new StudentNotFound("Student Not Found with id= "+id));
			
	
			studentrepo.deleteById(id);
			 
		
		return "student deleted";
		
	}//method

}
