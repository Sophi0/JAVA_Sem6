package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")	
@Entity
@Getter				
@Setter			
@NoArgsConstructor	
@ToString		
public class Course {

	@Column(name = "IDc")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idc;
	
	@Column(name = "Title")
	@NotNull
	@Size(min = 3, max = 150)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latinletters and space")  
	private String title;
	
	@Column(name = "CreditPoints")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoints;	//nevajag notnull anotasciju, jo tas ir primitivais datu tips(int)
	
	@ManyToMany(mappedBy = "courses")	
	@ToString.Exclude
	private Collection<Professor> professors = new ArrayList<>();
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude			//vajag rakstit, jo mes negribam printet sho
	private Collection<Grade> grades;

	
	public Course(
			@NotNull @Size(min = 3, max = 150) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latinletters and space") String title,
			@Min(1) @Max(20) int creditPoints, ArrayList<Professor> professors) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professors = professors;
	}
	
	public void addProfessor(Professor inputProfessor) {
		if(!professors.contains(inputProfessor)) {
			professors.add(inputProfessor);
		}
	}
	
	public void removeProfessor(Professor inputProfessor) {
		if(professors.contains(inputProfessor)) {
			professors.remove(inputProfessor);
		}
	}
	
}
