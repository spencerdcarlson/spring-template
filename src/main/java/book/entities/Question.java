package book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

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
	public String toString() {
		return "| id: " + questionId + " | Question: " + questionTxt + 
		" | Options: " + questionOptions + " | Answer: " + questionAnswer;
	}
}
