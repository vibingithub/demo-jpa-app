package com.ecsfin.demo.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dont Add @Entity in this Embeddable class
 */

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guardian {
	@Column(name = "guardian_name")
	private String name;
	
	@Column(name = "guardian_email")
	private String email;
	
	@Column(name = "guardian_phone")
	private String phone;

}
