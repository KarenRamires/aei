package com.aei.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ClassPlan {	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	//@NotBlank
	private Date data;
	//@NotBlank
	private String description;
	private String evaluation;
	@ManyToOne
	private Routine routine;


}