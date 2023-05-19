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
	//TODO add this for Grades
	//TODO add this for Courses
}
