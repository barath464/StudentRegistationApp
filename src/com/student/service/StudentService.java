package com.student.service;

import java.util.ArrayList;
import java.util.List;

import com.student.bean.Student;
import com.student.bean.StudentSearchCriteria;

public interface StudentService {
	
	public Student save(Student student) throws Exception;

	public boolean delete(Student student) throws Exception;
	
	public ArrayList<Student> search(StudentSearchCriteria criteria) throws Exception;
}
