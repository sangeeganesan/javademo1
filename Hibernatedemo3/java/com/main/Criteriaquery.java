package com.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.model.Employee;

public class Criteriaquery {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		try {
			CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Employee.class);
			cq.from(Employee.class);
			session.createQuery(cq).getResultList();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> root = (Root) query.from(Employee.class);
			Query query1 = session.createQuery(query);
			List<Employee> list = query1.getResultList();
			for (Employee employee : list) {
				System.out.println(employee.getEmpName());
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		System.out.println("End of program");

	}
}
