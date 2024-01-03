package com.ecsfin.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecsfin.demo.jpa.entity.Student;

import jakarta.transaction.Transactional;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Long>{

	List<Student> findByFirstName(String firstName);
	
	List<Student> findByLastNameContaining(String lastName);
	
	List<Student> findByGuardianName(String name);
	
	List<Student> findByAgeGreaterThan(int age);
	
	List<Student> findByLastNameNotNull();
	
	//JPQL
	
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailId(String emailId);
	
	//JPQL Named Params
	
	@Query("select s from Student s where s.emailId = :emailId")
	Student getStudentByEmailIdNamedParam(@Param("emailId") String emailId);
	
	//Native Query
	
	@Query(
			value = "SELECT * FROM STUDENT WHERE EMAIL_ADDRESS = ?1",
			nativeQuery = true
			)
	Student getStudentByEmailIdNative(String emailId);
	
	@Query(
			value = "SELECT * FROM STUDENT WHERE EMAIL_ADDRESS = :emailId",
			nativeQuery = true
			)
	Student getStudentByEmailIdNativeParam(@Param("emailId") String emailId);
	
	
	//Update Query
	
	@Modifying
	@Transactional
	@Query(
			value = "UPDATE STUDENT SET FIRST_NAME = :firstName WHERE EMAIL_ADDRESS = :emailId",
			nativeQuery = true
			)
	int updateStudentFirstNameByEmailId(@Param("emailId") String emailId, @Param("firstName") String firstName);
	
}
