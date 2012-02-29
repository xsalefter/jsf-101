package org.xsalefter.jsf2101.faces;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.xsalefter.jsf2101.model.Account;

@ManagedBean
public class AccountListFaces {

	@ManagedProperty(value="#{accountListHolder}")
	private AccountListHolder accountListHolder;
	
	private Account accountInstance;
	
	@PostConstruct
	public void postConstruct() {
		if (this.accountInstance == null)
			this.accountInstance = new Account();
	}
	
	public void setAccountListHolder(AccountListHolder accountListHolder) {
		this.accountListHolder = accountListHolder;
	}

	public Account getAccountInstance() {
		return accountInstance;
	}

	public void setAccountInstance(Account accountInstance) {
		this.accountInstance = accountInstance;
	}

	// -- Event
	
	public void onButtonSaveClicked() {
		if (this.accountInstance.getId() != null) {
			System.out.println("... Edit account instance: " + this.accountInstance.getId());
			this.accountListHolder.editAccount(this.accountInstance);
		} else {
			System.out.println("... New account instance..");
			
			this.accountListHolder.addAccount(this.accountInstance);
		}
		this.accountInstance = null;
	}

	public void onButtonEditClicked(int accountIndex) {
		this.accountInstance = this.accountListHolder.get(accountIndex);
	}
	
	public void onButtonDeleteClicked(Account account) {
		int index = this.accountListHolder.indexOfAccount(account);
		if (index >= 0)
			this.accountListHolder.removeAccount(index);
		else
			System.out.println("Unknown index..");
	}
}
