package book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name = "resource")
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id")
	private int resourceId;
	@Column(name = "resource_type")
	private String resourceType;
	@Column(name = "resource_name")
	private String resourceName;
	@ManyToOne(optional = true)
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;

	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int instructionId) {
		this.resourceId = instructionId;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String instructionName) {
		this.resourceType = instructionName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String instructionTxt) {
		this.resourceName = instructionTxt;
	}
	public Section getQuestion(){
		return section;
	}
	public void setQuestion(Section section){
		this.section = section;
	}
	public String toString(){
		return "Resource [resourceId="+resourceId+
				", resourceType="+resourceType+
				", resourceName="+resourceName+"]";
	}

}