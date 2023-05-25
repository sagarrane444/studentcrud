package com.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private	Long id;
private String name;
private String course;
private String mobileNumber;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String name, String course, String mobileNumber) {
	super();
     
	this.name = name;
	this.course = course;
	this.mobileNumber = mobileNumber;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", course=" + course + ", mobileNumber=" + mobileNumber + "]";
}


}
