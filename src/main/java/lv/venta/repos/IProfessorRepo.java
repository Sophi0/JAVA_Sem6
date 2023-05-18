package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Long> {	
	//pirmais ir kas mes gribam izvadit(kura klasee info atrodas), otrais ir referencu datu tips(no liela burta)
	
	
	

}
