package com.travis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travis.dao.StudentDao;
import com.travis.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		sessionFactory.getCurrentSession().update(student);

	}

	@Override
	public void delete(int studentId) {
		sessionFactory.getCurrentSession().delete(getStudent(studentId));

	}

	@Override
	public Student getStudent(int studentId) {
		return (Student)sessionFactory.getCurrentSession().get(Student.class, studentId);
	}
	
	public List<Student> getAllStudent() {
		Session session = this.sessionFactory.openSession();
		List<Student> personList = session.createQuery("from Student").list();
		session.close();
		return personList;
		/*List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"Travis","Le",1));
		students.add(new Student(2,"Darryl","Le",1));
		return students;*/
	}

}
