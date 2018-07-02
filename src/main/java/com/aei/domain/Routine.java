package com.aei.domain;

import java.util.Timer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Routine {

	@Id
	@GeneratedValue
	private Long id;

	//@NotBlank
	private String name;
	private String hour;
	@ManyToOne
	private Activity activity;
	private String description;
}