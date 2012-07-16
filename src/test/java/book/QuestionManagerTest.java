package book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import com.mysql.jdbc.Driver;

import book.entities.Instruction;
import book.entities.Question;
import book.entities.Section;
import book.hibernate.QuestionManager;
import book.hibernate.SectionManager;


/**
 * Unit test for the Hibernate-based account manager implementation. Tests application behavior to verify the Account
 * Hibernate mapping is correct.
 */
public class QuestionManagerTest {

	private QuestionManager questionManager;
	private PlatformTransactionManager transactionManager;
	private TransactionStatus transactionStatus;
	private SectionManager sectionManager;
	
//	@Before
//	public void setUp() throws Exception {
//		// setup the repository to test
//		SessionFactory sessionFactory = createTestSessionFactory();
//		questionManager = new QuestionManager();
//		questionManager.setSession(sessionFactory);
//		sectionManager = new SectionManager();
//		sectionManager.setSession(sessionFactory);
//		
//		// begin a transaction
//		transactionManager = new HibernateTransactionManager(sessionFactory);
//		transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
//		
//	}
//
//	@Test
//	public void testGetAllQuesitions() {
//		List<Question> question = questionManager.getAllQuestions();
//		// Size should match number of inserts in mysql_test-data
//		assertEquals("Wrong number of questions", 4, question.size());
//		for (Question q: question){
//			System.out.println(q.toString());
//		}
//	}
//
//	@Test
//	public void testGetQuestion() {
//		Question question = questionManager.getQuestion(1);
//		// assert the returned account contains what you expect given the state
//		// of the database
//		System.out.println("Got Question: " + question.toString());
//		assertNotNull("account should never be null", question);
//		assertEquals("wrong id",1, question.getId());
//		assertEquals("wrong question", "Please check to see if shes ready.", question.getQuestion());
//		assertEquals("wrong answer", "B", question.getAnswer());
//		assertEquals("wrong options","A//B", question.getOptions());
//	}
//
//	@Test
//	public void testaddQuestion() {
//		int before = questionManager.getSize();
//		System.out.println("Size before Insertion: " + before);
//		before++;
//		Section sec = sectionManager.getSection(3);
//		Question newQuestion = new Question(100,sec,"INSERT A NEW QUESTION TEXT", "ANSWER", "OPTIONS");
//		questionManager.addQuestion(newQuestion);
//		int after = questionManager.getSize();
//		System.out.println("Size after Insertion: " + after);
//		assertEquals("Entity not added: ", before, after);
//
//
//	}
//	@Test
//	public void testRemoveQuestion() {
//		int before = questionManager.getSize();
//		System.out.println("Size before Deletion: " + before);
//		before--;
//		questionManager.removeQuestion(questionManager.getQuestion(2));
//		int after = questionManager.getSize();
//		System.out.println("Size after Deletion: " + after);
//		assertEquals("Entity not added: ", before, after);
//	}
//
//	@Test
//	public void testUpdateQuestion() {
//		// index of the entity to change
//		Integer id = 1;
//
//		// New inputs
//		String questionInput = "New question";
//		String answerInput = "New answer";
//		String optionsInput = "New options";
//
//		// Get a question
//		Question originalQuestion = questionManager.getQuestion(id);
//		System.out.println("Origional Question: " + originalQuestion.toString());
//
//
//		// change its contents to the new inputs
//		originalQuestion.setQuestion(questionInput);
//		originalQuestion.setAnswer(answerInput);
//		originalQuestion.setOptions(optionsInput);
//
//		// commit the changes
//
//		questionManager.update(originalQuestion);
//
//		// Get the same question
//		Question newQuestion = questionManager.getQuestion(id);
//		System.out.println("Updated Question: " + newQuestion.toString());
//
//		// Check its contents against the new inputs
//		assertEquals("Did not update the question change", questionInput, newQuestion.getQuestion());
//		assertEquals("Did not update the Answer change", answerInput, newQuestion.getAnswer());
//		assertEquals("Did not update the Options change", optionsInput, newQuestion.getOptions());
//	}

	
	private SessionFactory createTestSessionFactory() throws Exception {
		// create a FactoryBean to help create a Hibernate SessionFactory
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(createTestDataSource());
		factoryBean.setAnnotatedClasses(new Class[]{Question.class,Section.class, Instruction.class});
		factoryBean.setHibernateProperties(createHibernateProperties());
		// initialize according to the Spring InitializingBean contract
		factoryBean.afterPropertiesSet();
		// get the created session factory
		return (SessionFactory) factoryBean.getObject();
	}

	private DataSource createTestDataSource() {
		// Remote testing DB
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://eis-test-db1.byuh.edu/test_reading_writing_center");
		bds.setUsername("spring");
		bds.setPassword("spring");
		return bds;

		// Local HSQLDB 
		/** testaddQuestin will fail unless you comment out @GeneratedValue in Question Class (line 19) **/
//		return new EmbeddedDatabaseBuilder()
//			.setName("dyad_book_local")
//			.addScript("test/db/mysql_schema.sql")
//			.addScript("test/db/mysql_data.sql")
//			.build();
	}

	private Properties createHibernateProperties() {
		Properties properties = new Properties();
		// turn on formatted SQL logging (very useful to verify Hibernate is
		// issuing proper SQL)
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
