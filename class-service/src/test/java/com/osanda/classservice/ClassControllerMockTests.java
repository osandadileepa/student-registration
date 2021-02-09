package com.osanda.classservice;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.osanda.classservice.controller.ClassController;
import com.osanda.classservice.entity.SchoolClass;
import com.osanda.classservice.service.ClassService;

//@ExtendWith(EasyMockExtension.class)
class ClassControllerMockTests {

//	public EasyMockRule rule = new EasyMockRule(this);
//
//	@Mock
//	private ClassService classService;
//
//	@TestSubject
//	private ClassController classController;
//
//	SchoolClass schoolClass;
//	List<SchoolClass> allSchoolClass;
//
//	@BeforeEach
//	public void initMethod() {
//		schoolClass = new SchoolClass("hhsg12d11212", "Class-A", "GRADE-1", "This is grade one class romm");
//		allSchoolClass = Arrays.asList(schoolClass);
//
//		EasyMockSupport.injectMocks(this);
//
//		EasyMock.expect(classService.getAllClasses()).andReturn(allSchoolClass);
//	}
}
