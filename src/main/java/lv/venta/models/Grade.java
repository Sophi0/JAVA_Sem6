package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "grade_table")	
@Entity
@Getter				
@Setter			
@NoArgsConstructor	
@ToString		
public class Grade {
	
	@Column(name = "IDg")	
	@Id						
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Setter(value = AccessLevel.NONE)	
	private long idg;
	
	//value nosaukums parasti nedrikst rakstit, jo h2 bibliotekaa ir shads key word!
	@Column(name = "GradeValue")
	@Min(value = 0)
	@Max(value = 10)
	private int gvalue;			//ari nevajag notnull, jo ir primitivais datu tips
	
	@ManyToOne
	@JoinColumn(name = "IDc")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "IDp")	//samainam no IDs uz IDp, jp student klasse extends person un mainas id nosaukums
	private Student student;

	public Grade(@Min(0) @Max(10) int gvalue, Course course, Student student) {
		this.gvalue = gvalue;
		this.course = course;
		this.student = student;
	}
	
	
}
