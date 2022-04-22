package com.juaracoding.sqahrishrd.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.sqahrishrd.drivers.DriverSingleton;

public class TemplatePAPage {

private WebDriver driver;
	
	public TemplatePAPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5)")
	WebElement menuPA;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div/div[1]/a")
	WebElement createTemplate;
	
	//Previous & Next
	
	@FindBy(xpath = "//*[@id=\"wizard\"]/div[2]/div/button[1]")
	WebElement btnPrevious;
	
	@FindBy(xpath = "//*[@id=\"wizard\"]/div[2]/div/button[2]")
	WebElement btnNext;
	
	//Data P.A Template
	
	@FindBy(xpath = "//*[@id=\"CatTypeQuantityAspect\"]/div/div/div[1]/label")
	WebElement checktTypeQuantity;
	
	@FindBy(xpath = "//*[@id=\"area_detail_QualityAspect\"]/table/tbody/tr[1]/td/div/label")
	WebElement checkTypeQualityKekeluargaan;
	
	@FindBy(xpath = "//*[@id=\"area_detail_QualityAspect\"]/table/tbody/tr[2]/td[1]/div/label")
	WebElement checkTypeQualitySigap;
	
	@FindBy(xpath = "//*[@id=\"CatTypeAspiration\"]/div/div/div[1]/label")
	WebElement checkTypeAspiration;
	
	@FindBy(name = "Template_Name")
	WebElement inputTemplateName;
	
	@FindBy(css = "#parsley-id-5 > li")
	WebElement validasiTemplateName;
	
	//Create Privilege P.A
	
	@FindBy(xpath = "//*[@id=\"divisionSelect\"]")
	WebElement inputDivision;
	
	@FindBy(xpath = "//option[contains(@value,\"\")]")
	List<WebElement> listDivision;
	
	@FindBy(xpath = "//*[@id=\"area_detail_unit\"]/table/tbody/tr[3]/td[1]/div/label")
	WebElement checkUnitITProg;
	
	//Complete Process
	
	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	WebElement btnProcess;
	
	
	// -----Procced-----
	public void goToMenuPA() {
		menuPA.click();
	}
	
	public void createTemplatePA() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		tunggu(1);
		createTemplate.click();
	}
	
	public void dataTemplatePA() {
		checktTypeQuantity.click();
		tunggu(1);
		checkTypeQualityKekeluargaan.click();
		tunggu(1);
		checkTypeQualitySigap.click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,632)");
		checkTypeAspiration.click();
		tunggu(2);
		btnNext.click();
	}
	
	public String getValidasiTemplateName() {
		return validasiTemplateName.getText();
	}
	
	public void addTemplateName(String templateName) {
		inputTemplateName.sendKeys(templateName);
		tunggu(1);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,632)");
		btnNext.click();
	}
	
	public void createPrivilegePADepartment() {
		inputDivision.click();
		listDivision.get(5).click();
		
	}
	
	public void addUnit() {
		checkUnitITProg.click();
		tunggu(2);
		btnNext.click();
	}
	
	public void completeProcess() {
		btnProcess.click();
	}

	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
