package com.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.student.bean.Student;
import com.student.bean.StudentSearchCriteria;
import com.student.dao.StudentDao;
import com.student.dao.impl.StudentDaoImpl;
import com.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	StudentDao studentDao;
	
	public StudentServiceImpl() {
		studentDao  = new StudentDaoImpl();
		//studentDao  = new StudentHibernateDAOImpl();
	}
	
	@Override
	public Student save(Student student) throws Exception{
		boolean result = false;
		Student resStudent  = null;
		try{		
			if(student.getStdId()>0){
				result = studentDao.insert(student);
			}else if(student.getStdId()>0){
				result = studentDao.update(student);
			}
			
			if(result){
				resStudent = student;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return resStudent;
	}

	@Override
	public boolean delete(Student student) throws Exception {
		boolean result =false;
		String name = student.getName();
		int age = student.getAge();
		StudentSearchCriteria ssc = new StudentSearchCriteria();
		ssc.setName(name);
		ssc.setAge(age);
		List<Student> list = studentDao.search(ssc);
		if(list!=null && list.size()>0)
		{
	    result = studentDao.remove(student);
	    System.out.println("Service delete:"+student);
		}
		return result;
	}
	@Override
	public ArrayList<Student> search(StudentSearchCriteria criteria) throws Exception {
		ArrayList<Student> al =(ArrayList<Student>) studentDao.search(criteria);
		return al;
	}  

}
