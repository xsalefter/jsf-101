package org.xsalefter.jsf2101.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.xsalefter.jsf2101.model.Account;

@ManagedBean
@SessionScoped
public class AccountListHolder implements Serializable {

	private static final long serialVersionUID = 685008372794251008L;
	
	private List<Account> accounts;
	
	public AccountListHolder() {
	}
	
	@PostConstruct
	public void onInit() {
		this.accounts = new ArrayList<Account>();
		this.accounts.add(new Account(1L, "test", "test@somewhere.com"));
		this.accounts.add(new Account(2L, "foo", "foo@bar.com"));
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public int indexOfAccount(Account account) {
		return this.accounts.indexOf(account);
	}
	
	public void addAccount(Account account) {
		final int intId = this.accounts.size() + 1;
		final Long id = new Long(intId);
		account.setId(id);
		this.accounts.add(account);
	}
	
	public Account get(int index) {
		return this.accounts.get(index);
	}
	
	public void editAccount(Account account) {
		int index = this.accounts.indexOf(account);
		this.accounts.remove(index);
		this.accounts.add(index, account);
	}
	
	public void removeAccount(int index) {
		this.accounts.remove(index);
	}
}
