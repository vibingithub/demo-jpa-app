package com.ecsfin.demo.jpa.cases;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecsfin.demo.jpa.entity.Course;
import com.ecsfin.demo.jpa.entity.CourseMaterial;
import com.ecsfin.demo.jpa.entity.Student;
import com.ecsfin.demo.jpa.entity.Teacher;
import com.ecsfin.demo.jpa.repository.CourseMaterialRepo;
import com.ecsfin.demo.jpa.repository.CourseRepo;

@SpringBootTest
public class CourseRepoTestCase {

	@Autowired
	CourseMaterialRepo courseMaterialRepo;
	
	@Autowired
	CourseRepo courseRepo;
	
	public void addCourseMaterial() {
		Course course = Course.builder()
							.name("Java")
							.rating(8)
							.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
										.course(course)
										.url("http://java.com")
										.description("Java Course")
										.build();
		
		courseMaterialRepo.save(courseMaterial);
	}
	
	public void getCourseMaterial() {
		
		List<CourseMaterial> lists = courseMaterialRepo.findAll();
		System.out.println(lists);
	}
	
	
	public void getCourse() {
		
		List<Course> lists = courseRepo.findAll();
		System.out.println(lists);
	}
	
	@Test
	public void saveAllDtls() {
		
		Teacher teacher = Teacher.builder()
							.firstName("Rahul")
							.lastName("Raj")
							.build();
		
		List<Student> students = Arrays.asList(
				Student.builder()
				.firstName("Deepti")
				.emailId("deepti@dummy.com")
				.age(10)
				.lastName("Sharma")
				.standard("X")
				.build(),
				Student.builder()
				.firstName("Manick")
				.emailId("manick@dummy.com")
				.age(13)
				.lastName("Sharma")
				.standard("XII")
				.build()
				);
		
		
		Course course = Course.builder()
				.name("SpringBoot")
				.rating(9)
				.teacher(teacher)
				.students(students)
				.build();
		
		courseRepo.save(course);
		
	}
}
