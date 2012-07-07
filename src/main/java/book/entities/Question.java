package book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import book.entities.Section;

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
	@Column(name = "section_id", insertable = false, updatable = false )
	private int sectionId;
	@ManyToOne(optional = true)
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;


	protected Question() {
	}
	public Question( String question) {
		this.questionTxt = question;
	}
	public Question(Integer questionId, Integer sectionId, String questionTxt, String questionAnswer, String questionOptions ){
		this.questionId = questionId;
		this.sectionId = sectionId;
		this.questionTxt = questionTxt;
		this.questionAnswer = questionAnswer;
		this.questionOptions = questionOptions;
	}
	public int getId() {
		return questionId;
	}
	public void setId(int id) {
		this.questionId = id;
	}
	
	public Section getSection() {
		return this.section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public String getQuestion() {
		return questionTxt;
	}
	public void setQuestion(String question) {
		this.questionTxt = question;
	}
	public String getAnswer() {
		return questionAnswer;
	}
	public void setAnswer(String answer) {
		this.questionAnswer = answer;
	}
	public String getOptions() {
		return questionOptions;
	}
	public void setOptions(String options) {
		this.questionOptions = options;
	}

	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String toString(){
		return "Question [questionId="+questionId+
				", section="+section.getSectionName()+
				", questionTxt="+questionTxt+
				", questionOptions="+questionOptions+
				", questionAnswer="+questionAnswer+"]";
	}
}
