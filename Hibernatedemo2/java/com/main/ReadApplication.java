package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.Employee;

public class ReadApplication {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory =meta.getSessionFactoryBuilder().build(); 
		Session session = factory.openSession(); 
		Transaction transaction=session.beginTransaction();
		Employee obj=session.get(Employee.class,11);
		if(obj!=null) {
			System.out.println(obj.getEmpNo());
			System.out.println(obj.getEmpName());
			System.out.println(obj.getSalary());
			
            System.out.println("Employee update");
            obj.setEmpName("Hibernate");
            session.delete(obj);
            transaction.commit();
		}
		else {
			System.out.println("No such employee");
			
		}
		System.out.println("Delete successfully saved");
		
		session.close(); 
		factory.close();

	}

}
