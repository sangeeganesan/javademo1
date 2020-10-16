package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher implements Serializable{
	@Id
	private int tId;
	
	@Column(name="teachername")
	private String tName;
	
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="teacher_tId")
	private List<Student> students;


	

}
