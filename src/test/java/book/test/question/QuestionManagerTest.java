package book.test.question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

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

import book.entities.Question;
import book.hibernate.QuestionManager;


/**
 * Unit test for the Hibernate-based account manager implementation. Tests application behavior to verify the Account
 * Hibernate mapping is correct.
 */
public class QuestionManagerTest {

	private QuestionManager questionManager;
	private PlatformTransactionManager transactionManager;
	private TransactionStatus transactionStatus;

	@Before
	public void setUp() throws Exception {
		// setup the repository to test
		SessionFactory sessionFactory = createTestSessionFactory();
		questionManager = new QuestionManager(sessionFactory);
		// begin a transaction
		transactionManager = new HibernateTransactionManager(sessionFactory);
		transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
	}

	@Test
	public void testGetAllAccounts() {
		List<Question> question = questionManager.getAllQuestions();
		assertEquals("Wrong number of questions", 1, question.size());
	}

	@Test
	public void testGetAccount() {
		Question question = questionManager.getQuestion(1);
		// assert the returned account contains what you expect given the state
		// of the database
		assertNotNull("account should never be null", question);
		assertEquals("wrong id",1, question.getId());
		assertEquals("wrong question", "The dog // on the chair", question.getQuestion());
		assertEquals("wrong answer", "jumped", question.getAnswer());
		assertEquals("wrong options","jumped // bounced", question.getOptions());
	}

	@Test
	public void testUpdateQuestion() {
		Question oldQuestion = questionManager.getQuestion(1);
		oldQuestion.setQuestion("Ben Hale");
		oldQuestion.setAnswer("Man");
		oldQuestion.setOptions("Spencer");
		questionManager.update(oldQuestion);
		Question newQuestion = questionManager.getQuestion(1);
		assertEquals("Did not update the question change", "Ben Hale", newQuestion.getQuestion());
		assertEquals("Did not update the Answer change", "Man", newQuestion.getAnswer());
		assertEquals("Did not update the Options change", "Spencer", newQuestion.getOptions());
	}


	@After
	public void tearDown() throws Exception {
		// rollback the transaction to avoid corrupting other tests
		if (transactionManager != null) transactionManager.rollback(transactionStatus);
	}

	private SessionFactory createTestSessionFactory() throws Exception {
		// create a FactoryBean to help create a Hibernate SessionFactory
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(createTestDataSource());
		factoryBean.setAnnotatedClasses(new Class[]{Question.class});
		factoryBean.setHibernateProperties(createHibernateProperties());
		// initialize according to the Spring InitializingBean contract
		factoryBean.afterPropertiesSet();
		// get the created session factory
		return (SessionFactory) factoryBean.getObject();
	}

	private DataSource createTestDataSource() {
		return new EmbeddedDatabaseBuilder()
			.setName("dyad_book_local")
			.addScript("test/db/mysql_schema.sql")
			.addScript("test/db/mysql_test-data.sql")
			.build();
	}

	private Properties createHibernateProperties() {
		Properties properties = new Properties();
		// turn on formatted SQL logging (very useful to verify Hibernate is
		// issuing proper SQL)
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}
}
