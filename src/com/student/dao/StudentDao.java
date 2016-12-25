package com.student.dao;

import java.util.List;
import com.student.bean.Student;
import com.student.bean.StudentSearchCriteria;

public interface StudentDao {
	
	public boolean insert(Student student) throws Exception;
		
	public boolean update (Student student) throws Exception;
	
	public boolean remove(Student student) throws Exception;
	
	public List<Student> search(StudentSearchCriteria searchCriteria) throws Exception;
}
