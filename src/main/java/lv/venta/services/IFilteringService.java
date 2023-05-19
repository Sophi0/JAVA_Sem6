package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Course;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;

public interface IFilteringService {

	//public abstract varu nerakstit, jo tas ir abstrakta interface(abstrakts - nav implementacijas)
	
	ArrayList<Student> retrieveAllStudents();
	
	ArrayList<Professor> retrieveAllProfessors();
	
	ArrayList<Course> retrieveAllCourses();
	
	ArrayList<Grade> retrieveAllGrades();
	
	ArrayList<Grade> retrieveGradesByStudentId(long id);
	
	ArrayList<Course> retrieveCoursesByStudentId(long id);
	
	ArrayList<Course> retrieveCoursesByProfessorId(long id);
	
	float calculateAVGGradeInCourseId(long id);
}
