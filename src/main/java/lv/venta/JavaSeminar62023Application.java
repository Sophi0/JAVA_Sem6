package lv.venta;

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

	@Bean
	public CommandLineRunner testModel(IProfessorRepo prRepo, IStudentRepo stRepo, ICourseRepo csRepo, IGradeRepo grRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Juris", "Zagars", Degree.phd);
				Professor p2 = new Professor("Dmitrijs", "Smirnovs", Degree.phd);
				prRepo.save(p1);
				prRepo.save(p2);
				
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Kalnina");
				stRepo.save(st1);
				stRepo.save(st2);
				
				Course c1 = new Course("Haosa teorija", 4, p1);	//ja liekam kaut kadu objektu ieksa, vins jabut saglabats sheit! (save(..))
				Course c2 = new Course("Ekonomikas pamati", 2, p2);
				csRepo.save(c1);
				csRepo.save(c2);
				
				//Grade gr1 = new Grade(8, c1, st1);	//Janis got 8 in Haoss
				grRepo.save(new Grade(8, c1, st1));		//Janis got 8 in Haoss
				grRepo.save(new Grade(6, c2, st1));		//Janis got 6 in Ek.pam.
				grRepo.save(new Grade(9, c1, st2));		//Baiba got 9 in Haoss
				grRepo.save(new Grade(5, c2, st2));		//Baiba got 5 in Ek.pam.
			}
		};
	}
}
