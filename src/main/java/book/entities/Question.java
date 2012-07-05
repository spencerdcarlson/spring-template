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
import book.entities.Section;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	@JsonIgnore
	private int questionId;
	@Column(name = "question_txt")
	private String questionTxt;
	@Column(name = "question_answer")
	private String questionAnswer;
	@Column(name = "question_options")
	private String questionOptions;
	@Column(name = "section_id")
	private int sectionId;
//	@ManyToOne
//	@JoinColumn(name="sectionId")
//	private Section section;

	protected Question() {
	}
	public Question(Question newQuestion){
		this.questionTxt = newQuestion.questionTxt;
		this.questionAnswer = newQuestion.questionAnswer;
		this.questionOptions = newQuestion.questionOptions;		
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
	public Question(Integer sectionId, String questionTxt, String questionAnswer, String questionOptions ){
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
				", sectionId="+sectionId+
				", questionTxt="+questionTxt+
				", questionOptions="+questionOptions+
				", questionAnswer="+questionAnswer+"]";
	}
//	public Section getSection() {
//		return section;
//	}
//	public void setSection(Section section) {
//		this.section = section;
//	}
}
