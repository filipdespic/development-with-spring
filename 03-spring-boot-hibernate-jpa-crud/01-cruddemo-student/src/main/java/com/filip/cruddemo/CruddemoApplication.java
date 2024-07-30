package com.filip.cruddemo;

import com.filip.cruddemo.dao.StudentDAO;
import com.filip.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createMultipleStudents(studentDAO);
			readAllStudents(studentDAO);
			System.out.println("Reading by last name:");
			readAllStudentsByLastName(studentDAO);

			updateStudent(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Paul", "Aoe", "test@gmail.com");
		Student student2 = new Student("John", "Boe", "john@gmail.com");
		Student student3 = new Student("Mark", "Doe", "mark@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("All students saved.");
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Paul", "Doe", "test@gmail.com");

		studentDAO.save(student);

		System.out.println("Saved student with generated id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Paul", "Doe", "test@gmail.com");

		studentDAO.save(student);

		System.out.println("Student saved with id: " + student.getId());

		studentDAO.findById(student.getId());
		System.out.println("Found the student: " + student);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readAllStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Aoe");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);

		System.out.println("Updating student.");
		student.setFirstName("Scooby");

		studentDAO.update(student);

		System.out.println("Updated student: " + student);

	}

}
