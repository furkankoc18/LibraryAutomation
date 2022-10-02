package com.library.automation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String username;
	@Column
	private String password;

}
