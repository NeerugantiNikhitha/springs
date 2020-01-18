package com.lti.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		Student student=new Student(23,"phani",99.99);
		StudentService service=new StudentServiceImpl();
		boolean result=service.addStudent(student);
		if(result)
		{
			System.out.println("student"+student.getRollNumber()+"is added.");
			Student student2=service.findStudentByRollNumber(student.getRollNumber());
			System.out.println(student2);
			
		}
		else
		{
			System.out.println("student is not added");
		}
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager=factory.createEntityManager();
		
		
		Query query=entityManager.createQuery("select s From Student s where s.rollNumber=10");
		List<Student> list=query.getResultList();
		for(Student s: list){
			System.out.println(s);
		}

	}

}
