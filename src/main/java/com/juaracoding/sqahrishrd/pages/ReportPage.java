package com.juaracoding.sqahrishrd.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.sqahrishrd.drivers.DriverSingleton;

public class ReportPage {
private WebDriver driver;
	
	public ReportPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a")
	WebElement menuPA;
	
	@FindBy(xpath = "//*[@id=\"tableDataPaTemplate_filter\"]/label/input")
	WebElement inputSearch; //PA
	
	@FindBy(xpath = "//*[@id=\"tableDataPaTemplate\"]/tbody/tr[2]/td[4]/a[1]")
	WebElement btnReport;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/div/div[1]/h4")
	WebElement txtDashboard;
	
	//https://dev.ptdika.com/hrd_new/performance_appraisal_new/set_template/report_template_pa/15
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/div/div[1]/h4")
	WebElement txtReport;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/div/div[1]/div/a[1]")
	WebElement btnExpand;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/div/div[1]/div/a[2]")
	WebElement btnReload;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/div/div[1]/div/a[3]")
	WebElement btnCollapse;
	
	@FindBy(xpath = "//*[@id=\"tableReportPaTemplate_paginate\"]/ul/li[3]/a")
	WebElement btnTwo;
	
	@FindBy(id="tableReportPaTemplate_previous")
	WebElement btnPrev;
	
	@FindBy(css = "#tableReportPaTemplate_length > label > select")
	WebElement btnShow;
	
	@FindBy(xpath = "//*[@id='table_length']/label/select/option")
	List<WebElement> listShow;

	@FindBy(xpath = "//*[@id=\"tableReportPaTemplate\"]/tbody/tr[1]/td[1]")
	WebElement btnIndex1;
	
	@FindBy(xpath = "//*[@id=\"tableReportPaTemplate\"]/tbody/tr[1]/td[2]/button")
	WebElement btnRater;
	
	@FindBy(id="btnFormRater")
	WebElement btnFilter;
	
	@FindBy(id="typeField")
	WebElement btnGroup;

	@FindBy(id="typeField2")
	WebElement btnDiv;

	@FindBy(id="btnRater")
	WebElement btnAdd;
	
	@FindBy(id="listRater")
	WebElement btnListName;
	
	@FindBy(id="btnProses")
	WebElement btnProses;

	@FindBy(xpath="//*[@id=\"modal_rater_view\"]/div/div/div[1]/button")
	WebElement btnCloseRater;
	
	@FindBy(xpath="//*[@id=\"modal_detail_assign\"]/div/div/div[1]/button")
	WebElement btnCloseName;
	
	@FindBy(xpath="//*[@id=\"tableReportPaTemplate\"]/tbody/tr[1]/td[4]/button")
	WebElement btnName;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/div/div[2]/div/div[1]/button")
	WebElement btnExport;

//--------------------- Step -----------------------//
	
	public void PANew(String pa) {
		menuPA.click();
		tunggu(4);
		scroll(2);
		inputSearch.sendKeys(pa);
		btnReport.click();
	}
	
	public String getTxtDashboard() {
		return txtDashboard.getText();
	}
	
	public String getTxtReport() {
		return txtReport.getText();
	}
	
	public String getTxtExport() {
		return btnExport.getText();
	}
	
	public void HalReport(String hal, String group, String divi, String filter) {
		tunggu(3);
		btnExpand.click();
		tunggu(2);
		btnExpand.click();
		tunggu(1);
		btnReload.click();
		tunggu(2);
		btnCollapse.click();
		tunggu(1);
		btnCollapse.click();
		scroll(1);
		btnTwo.click();
		tunggu(1);
		btnPrev.click();
		tunggu(1);
		btnShow.sendKeys(hal);
		btnIndex1.click();
		tunggu(1);
		btnIndex1.click();
		tunggu(1);
		btnRater.click();
		tunggu(1);
		btnFilter.click();
		tunggu(1);
		btnGroup.click();
		btnGroup.sendKeys(group);
		btnGroup.sendKeys(Keys.ENTER);
		tunggu(1);
		btnDiv.click();
		btnDiv.sendKeys(divi);
		btnDiv.sendKeys(Keys.ENTER);
		tunggu(1);
		btnListName.click();
		btnListName.sendKeys(filter);
		btnListName.sendKeys(Keys.ENTER);
		tunggu(1);
		btnAdd.click();
		tunggu(2);
		btnProses.click();
		tunggu(1);
		Alert alert_box = driver.switchTo().alert();
		alert_box.accept(); 
		tunggu(1);
		btnCloseRater.click();
		tunggu(1);
		btnName.click();
		tunggu(1);
		btnCloseName.click();
	}
	
	public void exportExcel() {
		btnExport.click();
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll(int kali) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}
	
	
	public void scroll_atas(int kali) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(1500,0)");
	}

}
