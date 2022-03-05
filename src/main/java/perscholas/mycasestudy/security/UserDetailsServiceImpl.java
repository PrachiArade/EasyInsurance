package perscholas.mycasestudy.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import perscholas.mycasestudy.database.dao.UserDAO;
import perscholas.mycasestudy.database.entity.User;
import perscholas.mycasestudy.database.entity.UserRole;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDAO userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //If the incoming username was not found in database so we are done and quit
        // this user will be null
        User user = userDao.findByEmail(username);


        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        //we do not need to do anything with these flags for the project
        // check the account status
        boolean accountIsEnabled = true;
        //accountIsEnabled = user.isActive();

        // spring security configs
        boolean accountNonExpired = true;

        //if ( user.getExpirationDate().before(new Date()))
        boolean credentialsNonExpired = true;

        boolean accountNonLocked = true;

        List<UserRole> userRoles = userDao.getUserRoles(user.getId());
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), accountIsEnabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);
    }


    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getUserRole().toString()));
        }

        // always add the user role
        //authorities.add(new SimpleGrantedAuthority(UserRoleEnum.USER.toString()));

        return authorities;
    }

}
