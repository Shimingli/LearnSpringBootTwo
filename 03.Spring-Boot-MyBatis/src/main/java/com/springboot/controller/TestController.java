package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.Student;
import com.springboot.service.StudentService;

@RestController
public class TestController {

	@Autowired
	private StudentService studentService;

	// 正确的请求的方式 ：http://localhost:8080/web/querystudent?sno=001
	@RequestMapping( value = "/querystudent", method = RequestMethod.GET)
	public Student queryStudentBySno(String sno) {
		System.out.println("queryStudentBySno=="+sno);
		return this.studentService.queryStudentBySno(sno);
	}
}
