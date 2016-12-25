package com.student.bean;

import java.io.Serializable;

public class Student implements Serializable,Comparable<Student>{

	private static final long serialVersionUID = 1L;

	private int stdId;
	
	private String name;
	
	private int age;
	
	private int marks;
	
	@Override
	public int compareTo(Student student1) {
	
		
		
		// TODO Auto-generated method stub
		return 0;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student  [stdId=" + stdId + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}




	public Student(){
		
	}

	

	/**
	 * @param stdId
	 * @param name
	 * @param age
	 * @param marks
	 */
	public Student(int stdId, String name, int age, int marks) {
		this.stdId = stdId;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}




	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}




	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}




	/**
	 * @return the stdId
	 */
	public int getStdId() {
		return stdId;
	}

	/**
	 * @param stdId the stdId to set
	 */
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
	
	
}
