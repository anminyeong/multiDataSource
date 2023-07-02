package com.hwc.isl.loader.dbif.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {
	
	@Id
	private String userId;
	private String password;
}
