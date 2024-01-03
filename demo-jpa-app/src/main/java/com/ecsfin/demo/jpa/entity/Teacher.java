package com.ecsfin.demo.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
	
	@Id
	@SequenceGenerator(name = "teacher_sequence",
						sequenceName = "teacher_sequence",
						allocationSize = 1,
						initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "teacher_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;

}
