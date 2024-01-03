package com.ecsfin.demo.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

	@Id
	@SequenceGenerator(name = "material_sequence",
					sequenceName = "material_sequence",
					allocationSize = 1,
					initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "material_sequence")
	private Long materialId;
	private String url;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id",
				referencedColumnName = "courseId",
				nullable = false)
	private Course course;
}
