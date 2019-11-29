package com.bankapp.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankapp.model.entities.AppUser;

public class SecUser implements UserDetails{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Autowired
	private AppUser user;
	private String name;
	
	public String getName() {
		return user.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public SecUser(AppUser user) {
	super();
	this.user = user;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return AuthorityUtils.createAuthorityList(user.getRoles());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "SecUser [user=" + user + "]";
	}

}
