package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

	ArrayList<Grade> findByStudentIdp(long id);	//mainam no IDs uz IDp(person id)

	ArrayList<Grade> findByCourseIdc(long id);

}
