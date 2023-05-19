package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class JavaSeminar62023Application {


	//TODO change linkage between Professor and Course to ManytoMany
	//TODO create adding function for both Collections
	//TODO change testModel function to add 2 courses for Zagars and 2 professors for Ekonomika
	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar62023Application.class, args);
	}

	@Bean	//palaizos automatiski, startejot programmu
	public CommandLineRunner testModel(IProfessorRepo prRepo, IStudentRepo stRepo, ICourseRepo csRepo, IGradeRepo grRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Juris", "Zagars", Degree.phd);
				Professor p2 = new Professor("Dmitrijs", "Smirnovs", Degree.phd);
				Professor p3 = new Professor("Karina", "Skirmante", Degree.mg);
				prRepo.save(p1);
				prRepo.save(p2);
				prRepo.save(p3);
				
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Kalnina");
				stRepo.save(st1);
				stRepo.save(st2);
				
				//TODO one course for two professors
				//TODO one professor for two courses
				Course c1 = new Course("Haosa teorija", 4, new ArrayList<>(Arrays.asList(p1)));
				Course c2 = new Course("Ekonomikas pamati", 2, new ArrayList<>(Arrays.asList(p2)));
				Course c3 = new Course("Dabaszinatnu pamati", 2, new ArrayList<>(Arrays.asList(p1)));
				Course c4 = new Course("Java", 4, new ArrayList<>(Arrays.asList(p2, p3)));
				csRepo.save(c1);
				csRepo.save(c2);
				csRepo.save(c3);
				csRepo.save(c4);
				
				c1.addProfessor(p1);
				c2.addProfessor(p2);
				c3.addProfessor(p1);
				c4.addProfessor(p2);
				c4.addProfessor(p3);
				//obligati velreiz jasaglaba!
				csRepo.save(c1);
				csRepo.save(c2);
				csRepo.save(c3);
				csRepo.save(c4);
				
				//Grade gr1 = new Grade(8, c1, st1);	//Janis got 8 in Haoss
				grRepo.save(new Grade(8, c1, st1));		//Janis got 8 in Haoss
				grRepo.save(new Grade(6, c2, st1));		//Janis got 6 in Ek.pam.
				grRepo.save(new Grade(9, c1, st2));		//Baiba got 9 in Haoss
				grRepo.save(new Grade(5, c2, st2));		//Baiba got 5 in Ek.pam.
			}
		};
	}
}
