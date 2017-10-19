package com.travis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		}
		catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			} 
		finally {
			   session.close();
			}		
	}

	@Override
	public void edit(Student student) {		
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
		}
		catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			} 
		finally {
			   session.close();
			}		
		
	}

	@Override
	public void delete(int studentId) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();
			session.delete(getStudent(studentId));	
			tx.commit();
		}
		catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			} 
		finally {
			   session.close();
			}				

	}

	@Override
	public Student getStudent(int studentId) {
		Session session = sessionFactory.openSession();
		
		try
		{
			session.get(Student.class, studentId);			
		}
		catch (Exception e) {
			 
			   e.printStackTrace(); 
			} 
		finally {
			   session.close();
			}			
		return (Student)sessionFactory.openSession().get(Student.class, studentId);	
		
	}
	
	public List<Student> getAllStudent() {
		
		List<Student> personList=new ArrayList<Student>();
		Session session = sessionFactory.openSession();
		
		try
		{
			personList=session.createQuery("from Student").list();	
		}
		catch (Exception e) {
			 
			   e.printStackTrace(); 
			} 
		finally {
			   session.close();
			}			
		return personList;			
	}

}
