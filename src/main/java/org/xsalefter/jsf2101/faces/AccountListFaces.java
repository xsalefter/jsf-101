package org.xsalefter.jsf2101.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.xsalefter.jsf2101.model.Account;

@ManagedBean
@SessionScoped
public class AccountListFaces {

	private List<Account> accounts;
	
	public AccountListFaces() {
	}
	
	@PostConstruct
	public void onInit() {
		this.accounts = new ArrayList<Account>();
		this.accounts.add(new Account(1L, "test", "test@somewhere.com"));
		this.accounts.add(new Account(1L, "foo", "foo@bar.com"));
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
