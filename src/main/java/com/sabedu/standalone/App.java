/**
 * 
 */
package com.sabedu.standalone;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sabedu.standalone.beans.Student;
import com.sabedu.standalone.beans.SystemProp;

/**
 * @author Sunil
 *
 * App.java Jan 13, 2021 8:31:12 PM
 */

public class App {

	public static void main(String[] args) {
		applicationContext();
	}
	
	public static void applicationContext() {
		System.out.println("Application Context Example");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Student student=(Student)ctx.getBean("Student");  
		//System.out.println(student.getMsg());
		
		SystemProp systemProp=(SystemProp)ctx.getBean("systemProp");  
		System.out.println(systemProp.getMsg());
		
	}
	
	public void beanFactoryDemo() {
		System.out.println("Bean Factory Example");
		Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  
	    Student student=(Student)factory.getBean("Student");  
	    System.out.println(student.getMsg());  
	}
}
