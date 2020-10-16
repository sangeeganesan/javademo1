package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student implements Serializable{
	
	@Id
	
	private int studId;
	private String sname;
	
	
	@ManyToOne
	
	private Teacher teacher;


	
	

}
