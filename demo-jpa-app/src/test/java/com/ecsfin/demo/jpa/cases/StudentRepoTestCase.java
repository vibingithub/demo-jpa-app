package com.ecsfin.demo.jpa.cases;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecsfin.demo.jpa.entity.Guardian;
import com.ecsfin.demo.jpa.entity.Student;
import com.ecsfin.demo.jpa.repository.StudentRepo;

@SpringBootTest
public class StudentRepoTestCase {

	@Autowired
	StudentRepo studentRepo;
	
	public void insertData() {
		
		Guardian guardian = Guardian.builder()
								.email("ragu@gmail.com")
								.name("Ragu")
								.phone("8356434726")
								.build();
		
		Student student = Student.builder()
			.firstName("Syam")
			.lastName("Singh")
			.age(15)
			.standard("XII")
			.emailId("syam@dummy.com")
			.guardian(guardian)
			.build();
		
		studentRepo.save(student);
	}
	
	
	public void getAllData() {
		List<Student> list = studentRepo.findAll();
		System.out.println(list);
	}
	
	public void getSpecificData() {
		Optional<Student> studOps = studentRepo.findById(1007L);
		Student student = studOps.get();
		System.out.println(student);
		
		List<Student> byFirstName = studentRepo.findByFirstName("Alex");
		System.out.println("FirstName: "+byFirstName);
				
		List<Student> byLastNameContaining = studentRepo.findByLastNameContaining("Ra");
		System.out.println("LastName: "+byLastNameContaining);
		
		List<Student> byGuardianName = studentRepo.findByGuardianName("Ragu");
		System.out.println("Guardian Name: "+byGuardianName);
		
		List<Student> byAgeGreaterThan = studentRepo.findByAgeGreaterThan(12);
		System.out.println("Age Greater than 12: "+byAgeGreaterThan);
		
	}
	
	public void getJPQLResults() {
		Student studentByEmailId = studentRepo.getStudentByEmailIdNative("alex@dummy.com");
		System.out.println(studentByEmailId);
		
		int result = studentRepo.updateStudentFirstNameByEmailId("alex@dummy.com", "Alex Lal");
	}
	
}
