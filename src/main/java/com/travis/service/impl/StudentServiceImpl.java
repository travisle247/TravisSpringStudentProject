package com.travis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.travis.model.Student;
import com.travis.service.StudentService;
import com.travis.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Transactional
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentDao.add(student);

	}

	@Transactional
	public void edit(Student student) {
		// TODO Auto-generated method stub
		studentDao.edit(student);

	}

	@Transactional
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		studentDao.delete(studentId);

	}

	@Transactional
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentId);
	}

	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

}
