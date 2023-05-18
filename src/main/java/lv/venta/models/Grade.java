package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	
	@Column(name = "Value")
	@NotNull
	@Min(0)
	@Max(10)
	private int value;
	
	@Column(name = "Student")
	@NotNull
	private Student student;
	
	@Column(name = "Course")
	@NotNull
	private Course course;

	public Grade(@NotNull @Min(0) @Max(10) int value, @NotNull Student student, @NotNull Course course) {
		this.value = value;
		this.student = student;
		this.course = course;
	}
	
	
}
