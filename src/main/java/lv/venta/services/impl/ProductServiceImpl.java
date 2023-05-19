package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Course;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;
import lv.venta.services.IFilteringService;

@Service
public class ProductServiceImpl implements IFilteringService{

	@Autowired
	private IStudentRepo studentRepo;
	@Autowired
	private IGradeRepo gradeRepo;
	@Autowired
	private IProfessorRepo professorRepo;
	@Autowired
	private ICourseRepo courseRepo;

	@Override
	public ArrayList<Student> retrieveAllStudents() {
		return (ArrayList<Student>) studentRepo.findAll();
	}

	@Override
	public ArrayList<Professor> retrieveAllProfessors() {
		return (ArrayList<Professor>) professorRepo.findAll();
	}

	@Override
	public ArrayList<Course> retrieveAllCourses() {
		return (ArrayList<Course>) courseRepo.findAll();
	}

	@Override
	public ArrayList<Grade> retrieveAllGrades() {
		return (ArrayList<Grade>) gradeRepo.findAll();
	}

	@Override
	public ArrayList<Grade> retrieveGradesByStudentId(long id) throws Exception{
		if(id > 0) {
			ArrayList<Grade> filteredResults = gradeRepo.findByStudentIds(id);	//atrodam caur id, jo tas ir ertak un racionalak. ta ka student un grade ir saivienots, tad parasti ejam grade -> student id
			return filteredResults;
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public ArrayList<Course> retrieveCoursesByStudentId(long id) throws Exception{
		if(id > 0) {
			ArrayList<Course> filteredResults = courseRepo.findByGradesStudentIds(id);	//ejam caur klasem: course -> grades -> student -> student id
			return filteredResults;
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public ArrayList<Course> retrieveCoursesByProfessorId(long id) throws Exception{
		if(id > 0) {
			ArrayList<Course> filteredResults = courseRepo.findByProfessorsIdp(id);	//atrodam caur id, jo tas ir ertak un racionalak. ta ka professor un grade ir saivienots, tad parasti ejam grade -> professor id	
			return filteredResults;
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

	@Override
	public float calculateAVGGradeInCourseId(long id) throws Exception{
		if(id > 0) {
			ArrayList<Grade> filteredResults = gradeRepo.findByCourseIdc(id);	
			float sum = 0;
			for(Grade temp: filteredResults) {
				sum += temp.getGvalue();
			}
			return sum / filteredResults.size();
			
		}
		else {
			throw new Exception("ID need to be positive");
		}
	}

}
