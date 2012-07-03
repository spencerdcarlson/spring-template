package book.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "section_id")
	@JsonIgnore
	private int sectionId;
	@Column(name = "parent_id")
	private String parentId;
	@Column(name = "section_name")
	private String sectionName;
	@Column(name = "instruction_id")
	private String instructionId;
	@Transient
	private List<Section> children;
	
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getInstructionId() {
		return instructionId;
	}
	public void setInstructionId(String instructionId) {
		this.instructionId = instructionId;
	}
	
	public void addChild(Section section){
		this.children.add(section);
	}
	
	public String toString(){
		return "Section [sectionId="+sectionId+
				", parentId="+parentId+
				", sectionName="+sectionName+
				", instructionId="+instructionId+
				", children="+children+"]";
		}


}
	