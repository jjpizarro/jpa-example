package edu.unimagdalena.jpaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.unimagdalena.jpaexample.model.Course;
import edu.unimagdalena.jpaexample.model.Gender;
import edu.unimagdalena.jpaexample.model.Student;
import edu.unimagdalena.jpaexample.model.Teacher;
import edu.unimagdalena.jpaexample.repositories.CourseRepository;
import edu.unimagdalena.jpaexample.repositories.StudentRepository;
import edu.unimagdalena.jpaexample.repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Month;



@Slf4j
@SpringBootApplication
public class JpaexampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JpaexampleApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(TeacherRepository teacherRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
		return args -> { 
			Teacher teacher = new Teacher();
			teacher.setLastName("Luz");
			teacher.setFirstName("Torres");
			teacherRepository.save(teacher);

			teacher = new Teacher();
			teacher.setLastName("Pera");
			teacher.setFirstName("Maria");
			teacherRepository.save(teacher);

			Course course = new Course();
			course.setTitle("C# 101");
			course.setTeacher(teacher);
			courseRepository.save(course);
			
			Student arianaPizarro = Student.builder()
								.firstName("Ariana")
								.lastName("Pizarro")
								.birthDate(LocalDate.of(2000, Month.APRIL, 23))
								.gender(Gender.FEMALE)
								.wantsNewsletter(true)
								.build();
			studentRepository.save(arianaPizarro);

			Student lunaPertuz = Student.builder()
			.firstName("Luna")
			.lastName("Pertuz")
			.birthDate(LocalDate.of(2004, Month.JANUARY, 12))
			.gender(Gender.FEMALE)
			.wantsNewsletter(true)
			.build();
			studentRepository.save(lunaPertuz);
			
			Course sqlCourse = new Course();
			sqlCourse.setTitle("SQL 101");
			sqlCourse.setTeacher(teacher);
			sqlCourse.addStudent(arianaPizarro);
			sqlCourse.addStudent(lunaPertuz);

			courseRepository.save(sqlCourse);
			Teacher teacherFromDb = teacherRepository.findById(1L).get();
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(teacherFromDb.getFirstName());
			log.info("");

		
		};
	}
}
