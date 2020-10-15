package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.model.Employee;

public class ListApplication {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory =meta.getSessionFactoryBuilder().build(); 
		Session session = factory.openSession(); 
	    String hqlRead="from Employee where empNo>10";
	    Query query=session.createQuery(hqlRead);
	    List<Employee> employees=query.list();
	    if(employees.size()>0) {
	    	
	    for(Employee employee:employees)
	    {
	    	System.out.println(employee.getEmpNo());
	    	System.out.println(employee.getEmpName());
	    }
	    }
	    else {
	    	System.out.println("No record");
	    }
		System.out.println("successfully saved");
		
		session.close(); 
		factory.close();

	}

}
