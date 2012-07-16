package book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import book.entities.Instruction;
import book.entities.Question;
import book.entities.Section;
import book.hibernate.SectionManager;

public class SectionManagerTest {
	private SectionManager sectionManager;
	private PlatformTransactionManager transactionManager;
	private TransactionStatus transactionStatus;

//	@Before
//	public void setUp() throws Exception {
//		// setup the repository to test
//		SessionFactory sessionFactory = createTestSessionFactory();
//		sectionManager = new SectionManager();
//		sectionManager.setSession(sessionFactory);
//		transactionManager = new HibernateTransactionManager(sessionFactory);
//		transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
//	}
//
//	@Test
//	public void testGetAllSections() {
//		List<Section> sections = sectionManager.getAllSections();
//		// Size should match number of inserts in mysql_test-data
//		assertEquals("Wrong number of questions", 7, sections.size());
//	}
//	
//	@Test
//	public void testGetSection() {
//		Section section = sectionManager.getSection(1);
//		assertNotNull("account should never be null", section);
//		assertEquals("wrong id",1, section.getSectionId());
//		assertEquals("wrong Section Name", "Reading Writing Center", section.getSectionName());
//		assertEquals("wrong has child value",1, section.getHasChild());
//	}
	
	private SessionFactory createTestSessionFactory() throws Exception {
		// create a FactoryBean to help create a Hibernate SessionFactory
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource(createTestDataSource());
		factoryBean.setAnnotatedClasses(new Class[]{Section.class, Question.class, Instruction.class});
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
