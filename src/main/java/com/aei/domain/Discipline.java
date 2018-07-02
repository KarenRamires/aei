package com.aei.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Discipline {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	//@NotBlank
	private String name;
	private String description;
}