package com.aei.domain;

import javax.persistence.*;

import lombok.Data;

import java.util.Set;

/**
 * Created by rodrigo on 3/18/17.
 */
@Entity
@Data
public class Role {

	@Id
	@GeneratedValue
	private Long id;
	private String role;
	@ManyToMany
	private Set<User> accounts;
}
