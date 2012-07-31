package book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "instruction")
public class Instruction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instruction_id")
	private int instructionId;
	@Column(name = "instruction_name")
	private String instructionName;
	@Column(name = "instruction_txt")
	private String instructionText;

	public int getInstructionId() {
		return instructionId;
	}
	public void setInstructionId(int instructionId) {
		this.instructionId = instructionId;
	}
	public String getInstructionName() {
		return instructionName;
	}
	public void setInstructionName(String instructionName) {
		this.instructionName = instructionName;
	}
	public String getInstructionTxt() {
		return instructionText;
	}
	public void setInstructionTxt(String instructionTxt) {
		this.instructionText = instructionTxt;
	}
	public String toString(){
		return "Instruction [instructionId="+instructionId+
				", instructionName="+instructionName+
				", instructionText="+instructionText+"]";
	}

}