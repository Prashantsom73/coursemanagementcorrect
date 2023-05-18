package com.springrest.springrest.Services;

import java.util.List;

import com.springrest.springrest.Entities.Courses;

public interface courseService {
	
	public List<Courses> getCourses();

	public Courses getCourse(long courseId);


	public Courses addCorse(Courses courses);

	public Courses updatecorse(Courses courses);

	public void deletecorse(long id);

	
	
}
