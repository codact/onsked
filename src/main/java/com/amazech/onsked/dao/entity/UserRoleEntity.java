package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name="user_role")
public class UserRoleEntity {
	@Id
	private Integer userId;
	private String roleCode;

}
