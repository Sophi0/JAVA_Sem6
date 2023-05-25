package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "student_table")	
@Entity
@Getter				
@Setter			
@NoArgsConstructor	
@ToString		
public class Student extends Person{

	@OneToMany(mappedBy = "student")	//vienam studentam vairakas atzimes
	@ToString.Exclude					//vajag rakstit, jo mes negribam printet sho
	private Collection<Grade> grades;	//kolekcija, jo studentam varbut daudz vertejumus
	
	public Student(
			@NotNull @Size(min = 3, max = 20) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String name,
			@NotNull @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters") String surname) {
		super(name, surname);
	}

	
	
	
}
