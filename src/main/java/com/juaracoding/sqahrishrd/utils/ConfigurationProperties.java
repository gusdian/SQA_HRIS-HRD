package com.juaracoding.sqahrishrd.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Value("${email_wrong}")
	private String email_wrong;
	
	@Value("${password_wrong}")
	private String password_wrong;

	@Value("${txtWelcome}")
	private String txtWelcome;
	
	@Value("${txtWrongEmailPass}")
	private String txtWrongEmailPass;

	@Value("${filter}")
	private String filter;

	@Value("${categoryName}")
	private String categoryName;

	@Value("${txtCategoryName}")
	private String txtCategoryName;
	
	//----------------------Declaration Getter-----------------------------------
	
	public String getBrowser() {
		return browser;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail_wrong() {
		return email_wrong;
	}

	public String getPassword_wrong() {
		return password_wrong;
	}

	public String getTxtWelcome() {
		return txtWelcome;
	}

	public String getTxtWrongEmailPass() {
		return txtWrongEmailPass;
	}

//----------------------Category Page-----------------------------------
	
	public String getFilter() {
		return filter;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getTxtCategoryName() {
		return txtCategoryName;
	}

	
//----------------------Declaration Setter-----------------------------------
	
	public void setTxtWelcome(String txtWelcome) {
		this.txtWelcome = txtWelcome;
	}
	
	public void setTxtWrongEmailPass(String txtWrongEmailPass) {
		this.txtWrongEmailPass = txtWrongEmailPass;
	}
//----------------------Category Page-----------------------------------	

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



}
