package com.main;

import java.util.ArrayList;
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
import com.model.Student;
import com.model.Teacher;

public class OneToMany {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml")
				.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		String hqlRead = "from Employee where empNo>10";
		Transaction transaction;
		Teacher teacher = new Teacher();
		teacher.settId(100);
		teacher.settName("First Teacher");

		Student student1 = new Student();
		student1.setstudId(1);
		student1.setsname("one");
		student1.setTeacher(teacher);

		List<Student> students = new ArrayList();
		students.add(student1);

		teacher.setStudents(students);

		transaction = session.beginTransaction();

		//session.save(teacher);

		transaction.commit();
		System.out.println("End of One to Many");

	}

}
