package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface IStudentService {
	
	public String registerStudent(Student st);
	public List<Student> findAllStudents();
	public Student findById(int id);
	public String updateStudent(Student st);
	public String updateStudentPhoneNo(int id,long phoneNumber);
	public String deleteById(int id);
	
	
	

}
