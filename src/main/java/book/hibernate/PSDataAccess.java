package book.hibernate;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
 
public class PSDataAccess {
 
    private JdbcTemplate jdbcTemplate;
 
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    public String getStudentName(String netID) {
        String fName =  (String) this.jdbcTemplate.queryForObject("select FIRSTNAME from ODS_PERSON where NETID ='" + netID + "'" , String.class);
        String lName =  (String) this.jdbcTemplate.queryForObject("select LASTNAME from ODS_PERSON where NETID ='" + netID + "'" , String.class);
        return fName + " " + lName;
    }
}
