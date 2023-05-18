package com.springrest.springrest.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.CouurseDao;
import com.springrest.springrest.Entities.Courses;

@Service
public class courseServiceImpl implements courseService{

//	List<Courses> list;
//	
//	public courseServiceImpl() {
//		super();
//		// TODO Auto-generated constructor stub
//		list = new ArrayList<>();
//		list.add(new Courses(134,"Jaava","Nice courses3"));
//		list.add(new Courses(14,"Jaava2","Nice courses2"));
//		list.add(new Courses(144,"Jaava3","Nice courses1"));
//	}

//	public courseServiceImpl(List<Courses> list) {
//		super();
//		this.list = list;
//	}
	
	@Autowired
	private CouurseDao couurseDao; 

	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return couurseDao.findAll();
	}

	public Courses getCourse(long id) {
		// TODO Auto-generated method stub
//		courses=null;
//		for(Courses courses2 : list) {
//			if(courses2.getId()==id) {
//				courses= courses2;
//				return courses;
//			}
//		}
		return couurseDao.getReferenceById(id);
//		System.out.println(courses);
//		return courses;
	}

	public Courses addCorse(Courses courses) {
		// TODO Auto-generated method stub
//		list.add(courses);
		
		couurseDao.save(courses);
		return courses;
	}

	public Courses updatecorse(Courses courses) {
		// TODO Auto-generated method stub
		Courses course=null;
//		for(Courses courses2 : list) {
//			if(courses2.getId()== courses.getId()){
//				 courses2.setTitle(courses.getTitle());
//				 courses2.setDesc(courses.getDesc());
//			}
//		}
		
		couurseDao.save(courses);
		
		return courses;
//		return null;
	}

	@Override
	public void deletecorse(long id) {
		// TODO Auto-generated method stub
//		 boolean removed = list.removeIf(course -> course.getId() == id);
//		 return removed;
		Courses entityCourses = couurseDao.getReferenceById(id);
		couurseDao.delete(entityCourses);
//		return false;
		 
		
	}
	
}