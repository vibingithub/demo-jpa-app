package com.ecsfin.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecsfin.demo.jpa.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

}
