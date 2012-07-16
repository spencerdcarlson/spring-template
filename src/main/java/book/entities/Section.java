package book.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "section_id", unique = true, nullable = false)
	private int sectionId;
	@Column(name = "section_name")
	private String sectionName;
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="instruction_id")
	private Instruction instruction;
	@Column(name = "has_child")
	private int hasChild; 
	@OneToMany(mappedBy="section")
	private List<Question> questions;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="parent_id")
	private List<Section> children;
	@OneToMany(mappedBy="section")
	private List<Resource> resources;

	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Instruction getInstruction() {
		return instruction;
	}
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	public int getHasChild() {
		return hasChild;
	}
	public void setHasChild(int hasChild) {
		this.hasChild = hasChild;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Section> getChildren() {
		return this.children;
	}

	public List<Resource> getResources(){
		return resources;
	}
	public void setResources(List<Resource> res){
		resources = res;
	}
	public String toString(){
		String childList = "";
		for (Section s: children ) {
			childList += s.getSectionName() + ",\n";
		}
		String instructionInfo = "NULL";
		if (instruction != null){
			instructionInfo = this.instruction.toString();	
		}
		return "Section [sectionId="+sectionId+
				", sectionName="+sectionName+
				", instruction="+instructionInfo+
				", children="+childList + "]";
	}
}
