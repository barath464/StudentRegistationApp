package com.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.bean.Student;
import com.student.bean.StudentSearchCriteria;
import com.student.dao.StudentDao;

public class StudentDaoImpl extends GenericDAO implements StudentDao {

	private Connection connection;
	
	
	@Override
	public boolean insert(Student student) throws SQLException,Exception{
		boolean result = false;
		try{
			connection  = getConnection();
			String sql = " insert into student_data values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,student.getStdId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.setInt(4, student.getMarks());
			ps.executeUpdate();
			System.out.println("dao is working");
		} catch (SQLException sqlEx){
			System.out.println(sqlEx);
			throw sqlEx;
		}catch (Exception e){
			System.out.println(e);	
			throw e;
		}
		closeConnection(connection);
		result = true;
		
		return result;
	}

	@Override
	public boolean update(Student student) throws Exception{
		boolean result =false;
		try{
		connection = getConnection();
		String sql = " update student_data set smarks = ? where stdId=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, student.getMarks());
		ps.setInt(2, student.getStdId());
		ps.executeUpdate();
		} catch (Exception ex){
			System.out.println(ex);
			throw ex;
		}
		closeConnection(connection);
		result = true;
		return result;
	}

	@Override
	public boolean remove(Student student) throws Exception {
		boolean result =false;
		try{			
			connection = getConnection();
			String sql = " delete from student_data where sname =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println("deleting:"+student);
			ps.setString(1, student.getName());
			ps.executeUpdate();
		} catch (Exception e){
			System.out.println(e);
			throw e;
		}
		closeConnection(connection);
		result = true;
		return result;
	
	}

	@Override
	public List<Student> search(StudentSearchCriteria searchCriteria) throws Exception {
		List<Student> studentList=null;
	try{
		connection = getConnection();
		String ageSql = null;
		if(searchCriteria.getAge()!=0){
			ageSql = " or sage =?";
		}
		String sql = "select * from student_data where sname =? "+ageSql;
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, searchCriteria.getName());
		if(ageSql!=null && !ageSql.isEmpty()){
			ps.setInt(2, searchCriteria.getAge());
		}
		ResultSet rs = ps.executeQuery();
		if(rs!=null){
			studentList = new ArrayList<Student>();
		while(rs.next()){
			Student student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			studentList.add(student);
		}
		}
	}catch (Exception e){
		System.out.println(e);
		throw e;
	}
	closeConnection(connection);
	return studentList;
	}

}
