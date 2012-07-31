package book.auth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;

public class StudentlifeUserDetailsService implements UserDetailsService {

	
	private static Log log = LogFactory.getLog(UserDetails.class);
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		User authedUser = null;
//		edu.byuh.studentlife.model.User dbuser = null;
//		try {
//			dbuser = userdao.getUserByCesNetId(username);
//			if (dbuser != null) {
//				List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//				List<Role> roles = dbuser.getRoles();
//				Iterator<Role> i = roles.listIterator();
//				auths.add(new GrantedAuthorityImpl("ROLE_BASIC"));
				
				
				
				
//				while (i.hasNext()) {
//					auths.add(new GrantedAuthorityImpl(i.next().getName()));
//				}
//				authedUser = new User(dbuser.getCesnetid(), "", true, true, true, true, auths);
//			}
//		} catch (EmptyResultDataAccessException e) {
			authedUser = new User(username, "", true, true, true, true, new ArrayList<GrantedAuthority>());
//		}
		
		return authedUser;
	}

}
