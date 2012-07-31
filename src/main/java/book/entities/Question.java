package book.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import book.entities.Section;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id", unique = true, nullable = false)
	private int questionId;
	@Column(name = "question_txt")
	private String questionTxt;
	@Column(name = "question_answer")
	private String questionAnswer;
	@Column(name = "question_options")
	private String questionOptions;
	@ManyToOne(optional = true)
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;
	@Column(name = "reference")
	private String reference;
	


	protected Question() {
	}
	public Question( String question) {
		this.questionTxt = question;
	}
	public Question(Integer questionId, Section section, String questionTxt, String questionAnswer, String questionOptions ){
		this.questionId = questionId;
		this.section = section;
		this.questionTxt = questionTxt;
		this.questionAnswer = questionAnswer;
		this.questionOptions = questionOptions;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int id) {
		this.questionId = id;
	}
	
	public Section getSection() {
		return this.section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public String getQuestionTxt() {
		return questionTxt;
	}
	public void setQuestionTxt(String question) {
		this.questionTxt = question;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String answer) {
		this.questionAnswer = answer;
	}
	public String getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(String options) {
		this.questionOptions = options;
	}
	public String getReference(){
		return reference;
	}
	public void setReference(String ref){
		reference = ref;
	}

//	public int getSectionId() {
//		return sectionId;
//	}
//	public void setSectionId(int sectionId) {
//		this.sectionId = sectionId;
//	}
	public String toString(){
		return "Question [questionId="+questionId+
				", section="+section.getSectionName()+
				", questionTxt="+questionTxt+
				", questionOptions="+questionOptions+
				", questionAnswer="+questionAnswer+"]";
	}
}
