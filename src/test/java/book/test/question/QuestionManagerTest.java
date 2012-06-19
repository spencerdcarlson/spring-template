package book.test.question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		System.out.println("***Question List Test ****");
		List<Question> question = questionManager.getAllQuestions();
		System.out.println("***Question List Test ****");		
		//assertEquals("Wrong number of questions", 1, accounts.size());
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
	public void testUpdateAccount() {
		Question oldQuestion = questionManager.getQuestion(1);
		oldQuestion.setOptions("Ben Hale");
		questionManager.update(oldQuestion);
		Question newQuestion = questionManager.getQuestion(1);
		assertEquals("Did not persist the question change", "Ben Hale", newQuestion.getQuestion());
	}

/*
	@Test
	public void testUpdateAccountBeneficiaries() {
		Map<String, Percentage> allocationPercentages = new HashMap<String, Percentage>();
		allocationPercentages.put("Annabelle", Percentage.valueOf("25%"));
		allocationPercentages.put("Corgan", Percentage.valueOf("75%"));
		questionManager.updateBeneficiaryAllocationPercentages(1, allocationPercentages);
		Account account = questionManager.getAccount(1);
		assertEquals("Invalid adjusted percentage", Percentage.valueOf("25%"), 
				account.getBeneficiary("Annabelle").getAllocationPercentage());
		assertEquals("Invalid adjusted percentage", Percentage.valueOf("75%"), 
				account.getBeneficiary("Corgan").getAllocationPercentage());
	}

	@Test
	public void testAddBeneficiary() {
		questionManager.addBeneficiary(1, "Ben");
		Account account = questionManager.getAccount(1);
		assertEquals("Should only have three beneficiaries", 3, account.getBeneficiaries().size());
	}

	@Test
	public void testRemoveBeneficiary() {
		Map<String, Percentage> allocationPercentages = new HashMap<String, Percentage>();
		allocationPercentages.put("Corgan", Percentage.oneHundred());
		questionManager.removeBeneficiary(1, "Annabelle", allocationPercentages);
		Account account = questionManager.getAccount(1);
		assertEquals("Should only have one beneficiary", 1, account.getBeneficiaries().size());
		assertEquals("Corgan should now have 100% allocation", Percentage.oneHundred(), account
				.getBeneficiary("Corgan").getAllocationPercentage());
	}
*/
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
			.addScript("eis/byuh/db/mysql_schema.sql")
			.addScript("eis/byuh/db/mysql_test-data.sql")
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
