package com.juaracoding.sqahrishrd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.sqahrishrd.drivers.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement inputEmail;
	
	@FindBy(name = "password")
	WebElement inputPassword;
	
	@FindBy(xpath = "//*[@id=\"page-container\"]/div/div[2]/div[2]/form/div[3]/button")
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id=\"gritter-item-1\"]/div[2]/div[1]/span")
	WebElement txtWelcomeBack;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li/a/div[3]")
	WebElement txtWelcome;
	
	@FindBy(xpath = "//*[@id=\"page-container\"]/div/div[2]/div[1]/div[3]/strong")
	WebElement txtWrongEmailPass;
	
	@FindBy(xpath = "//*[@id=\"gritter-item-1\"]/div[2]/a")
	WebElement btnClose;

	@FindBy(xpath = "//*[@id=\"header\"]/ul/li[4]/a")
	WebElement btnAdmin;
	
	@FindBy(xpath = "//*[@id=\"header\"]/ul/li[4]/div/a")
	WebElement btnLogout;

//------------------- Step -----------------//
	
	public void submitLoginValid(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		tunggu(1);
		btnLogin.click();
	}
	
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
	
	public String getTxtWrongEmailPass() {
		return txtWrongEmailPass.getText();
	}
	
	public String getTxtWelcomeBack() {
		return txtWelcomeBack.getText();
	}
	
	public void Logout() {
//		btnClose.click();
		tunggu(1);
		btnAdmin.click();
		tunggu(1);
		btnLogout.click();
	}
	
	public void submitLoginInvalid(String email_wrong, String password_wrong) {
		inputEmail.sendKeys(email_wrong);
		inputPassword.sendKeys(password_wrong);
		btnLogin.click();
		tunggu(1);
	}
	
	public void loginAgain(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		tunggu(1);
		btnLogin.click();
		btnClose.click();
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
