package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.services.IFilteringService;

@Controller
public class FilterController {

	@Autowired
	private IFilteringService filtService;
	
	@GetMapping(value = "/info/showAllStudents") //localhost:8080/info/showAllStudents
	public String getAllStudentsFunc(Model model){
		model.addAttribute("students", filtService.retrieveAllStudents());
		return "all-students-page";	//will show all-students-page.html
	}
	
	//TODO add this for Professor
	@GetMapping(value = "/info/showAllProfessors")	//localhost:8080/info/showAllProfessors
	public String getAllProfessorsFunc(Model model) {
		model.addAttribute("professors", filtService.retrieveAllProfessors());
		return "all-professors-page";	//will show all-professors-page.html
	}
	
	//TODO add this for Grades
	@GetMapping(value = "/info/showAllGrades")	//localhost:8080/info/showAllGrades
	public String getAllGradesFunc(Model model) {
		model.addAttribute("grades", filtService.retrieveAllGrades());
		return "all-grades-page";	//will show all-grades-page.html
	}
	//TODO add this for Courses
	@GetMapping(value = "/info/showAllCourses")	//localhost:8080/info/showAllCourses
	public String getAllCoursesFunc(Model model) {
		model.addAttribute("courses", filtService.retrieveAllCourses());
		return "all-courses-page";	//will show all-courses-page.html
	}
}
