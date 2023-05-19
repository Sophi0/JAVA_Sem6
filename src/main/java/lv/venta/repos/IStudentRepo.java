package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Grade;
import lv.venta.models.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{

	
}
