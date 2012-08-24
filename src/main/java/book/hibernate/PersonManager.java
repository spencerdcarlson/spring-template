//package book.hibernate;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class PersonManager {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	private EntityManager getEntityManager(){
//		return entityManager;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public String getName(String netID) {
//		String fName = getEntityManager().createQuery("SELECT FIRSTNAME FROM ODS_PERSON WHERE NETID LIKE :NETID").setParameter("NETID", netID).toString();
//		String lName = getEntityManager().createQuery("SELECT LASTNAME FROM ODS_PERSON WHERE NETID LIKE :NETID").setParameter("NETID", netID).toString();
//		return fName + " " + lName;
//	}
//}
