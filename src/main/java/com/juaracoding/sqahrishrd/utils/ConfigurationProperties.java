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

	@Value("${categoryName1}")
	private String categoryName1;

	@Value("${txtCategoryName}")
	private String txtCategoryName;
	
	@Value("${txtTemplateName}")
	private String txtTemplateName;
	
	@Value("${templateName}")
	private String templateName;
	
	//------------- Report Page ----------------------
	
	@Value("${pa}")
	private String pa;
	
	@Value("${hal}")
	private String hal;
	
	@Value("${group}")
	private String group;
	
	@Value("${divi}")
	private String divi;
	
	@Value("${filter1}")
	private String filter1;
	
	@Value("${txtDashboard}")
	private String txtDashboard;
	
	@Value("${txtReport}")
	private String txtReport;
	
	@Value("${btnExport}")
	private String txtExport;
	
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
	
	public String getCategoryName1() {
		return categoryName1;
	}

	public String getTxtCategoryName() {
		return txtCategoryName;
	}
	
	public String getTxtTemplateName() {
		return txtTemplateName;
	}
	
	public String getTemplateName() {
		return templateName;
	}
	
//------------- Report Page ----------------------
	
	public String getPa() {
		return pa;
	}
	
	public String getHal() {
		return hal;
	}
	
	public String getGroup() {
		return group;
	}
	
	public String getDivi() {
		return divi;
	}
	
	public String getFilter1() {
		return filter1;
	}
	
	public String getTxtDashboard() {
		return txtDashboard;
	}
	
	public String getTxtReport() {
		return txtReport;
	}
	
	public String getTxtExport() {
		return txtExport;
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
	
	public void setCategoryName1(String categoryName1) {
		this.categoryName = categoryName1;
	}

}
