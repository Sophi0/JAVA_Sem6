package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")	//table in database
@Entity
@Getter				//automatiski uztaisa get funckijas
@Setter				//automatiski uztaisa set funckijas
@NoArgsConstructor	//bezargumenta konstruktorus uztaisa
@ToString			//toString funkciju uztaisa
public class Professor {

	@Column(name = "IDp")	//pievienojam kolonnu tabulam ar nosaukumu IDp
	@Id						//obligati jabut id
	@GeneratedValue(strategy = GenerationType.AUTO)	//lai random genere id
	@Setter(value = AccessLevel.NONE)	//neuztaisa speciali set funkciju
	private long idp;	//id professor
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 30)
	@Pattern(regexp = "[A-ZĒŪĪĀĻŅČŠŽ]{1}[a-zēīāūļžņš]+([ ][A-ZĒŪĪĀĻŅŠČŽ]{1}[a-zēīāūļžņš]+)?", message = "Only latin letters")
	private String surname;
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;

	@ManyToMany
	@JoinTable(name = "prof_course_table", 
	joinColumns = @JoinColumn(name = "IDc"), 
	inverseJoinColumns = @JoinColumn(name = "IDp"))				
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();
	
	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	public void addCourse(Course inputCourse) {
		if(!courses.contains(inputCourse)) {
			courses.add(inputCourse);
		}
	}
	
	public void removeCourse(Course inputCourse) {
		if(courses.contains(inputCourse)) {
			courses.remove(inputCourse);
		}
	}
	
	
}
