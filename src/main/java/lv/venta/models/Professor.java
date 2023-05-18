package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	//TODO add data JPA annotations
	//TODO add validation annotations
	//TODO ADD, COMMIT AND PUSH
	//TODO do this also with Student, Course, Grade
	private String name;
	
	private String surname;
	
	private Degree degree;

	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	
}
