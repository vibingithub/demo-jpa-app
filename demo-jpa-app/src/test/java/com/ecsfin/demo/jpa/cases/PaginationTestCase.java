package com.ecsfin.demo.jpa.cases;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ecsfin.demo.jpa.entity.Student;
import com.ecsfin.demo.jpa.repository.StudentRepo;

@SpringBootTest
public class PaginationTestCase {

	@Autowired
	StudentRepo studentRepo;
	
	public void getPagination() {
		
		Pageable firstPagewith3record = PageRequest.of(0, 3);
		Pageable secondPagewith3record = PageRequest.of(1, 3);
		
		Page<Student> list = studentRepo.findAll(firstPagewith3record);
		List<Student> students = list.getContent();
		
		System.out.println(students);

				
		long totalElements = list.getTotalElements();
		
		System.out.println("Total Record: "+totalElements);
		
		
		int totalPages = list.getTotalPages();
		
		System.out.println("Total pages: "+totalPages);
		
	}
	
	@Test
	public void getSortedPagination() {
		Pageable sortByFirstName = PageRequest.of(0, 3,
									Sort.by("firstName"));
		
		
		Pageable sortByLastNameDesc = PageRequest.of(0, 3,
				Sort.by("lastName").descending());
		
		Pageable sortByFirstNameAndLastName = PageRequest.of(0, 3,
				Sort.by("firstName")
					.and(Sort.by("lastName"))
				);
		
		Page<Student> pageList = studentRepo.findAll(sortByFirstNameAndLastName);
		
		System.out.println(pageList.getContent());
	}
}
