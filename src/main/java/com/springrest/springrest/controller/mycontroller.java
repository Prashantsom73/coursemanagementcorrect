package com.springrest.springrest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Dao.CouurseDao;
import com.springrest.springrest.Entities.Courses;
import com.springrest.springrest.Services.courseService;

//@CrossOrigin
@CrossOrigin
@RestController
public class mycontroller {
	
	@Autowired
	private courseService courseservice;
	
	@Autowired
	private CouurseDao couurseDao;
	
	//Get the courses
	@GetMapping("/courses")	
	public List<Courses> getCourses(){
		return this.courseservice.getCourses();
	}
	
	@GetMapping("courses/{courseId}")
	public Courses getCorse(@PathVariable long courseId) {
		 return this.courseservice.getCourse(courseId);
	}
	
	@PostMapping("/courses")
	 public ResponseEntity<String> addCourses(@RequestBody Courses courses){
		 long courseId = courses.getId();
		  if (couurseDao.existsById(courseId)) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot add new course with ID " + courseId);
	        }
	        this.courseservice.addCorse(courses);
		return ResponseEntity.ok("Course added successfully");
	 }

	@PutMapping("/courses")
	public Courses updateCourses(@RequestBody Courses courses) {
	
			return this.courseservice.updatecorse(courses);
	}

	@DeleteMapping("/courses/{courseid}")
	public ResponseEntity<HttpStatus> deleteCorse(@PathVariable long courseid){
		try {
				this.courseservice.deletecorse(courseid);
//			 if(removed) {
				 return new ResponseEntity<>(HttpStatus.OK);				 
//			 }else {
//				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	


}
