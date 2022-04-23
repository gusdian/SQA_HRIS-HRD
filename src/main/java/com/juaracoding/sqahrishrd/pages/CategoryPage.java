package com.juaracoding.sqahrishrd.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.sqahrishrd.drivers.DriverSingleton;

public class CategoryPage {

	private WebDriver driver;
	
	public CategoryPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a")
	WebElement Listmenu;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div/div[1]/button[1]")
	WebElement Create;
	
	@FindBy(id = "deleteCheckedDataCpa")
	WebElement Delete;
	
	@FindBy(css = "#tableRefPaCategory_length > label > select")
	WebElement Entries;
	
	@FindBy(css = "#tableRefPaCategory_length > label > select > option")
	List<WebElement>ListEntries;
	
	@FindBy(xpath = "//*[@id='tableRefPaCategory']/tbody/tr/td/input")
	List<WebElement>CheckBox;
	
	@FindBy(xpath = "//*[@id='tableRefPaCategory_filter']/label/input")
	WebElement Filter;
	
	@FindBy(id = "Type_ID")
	WebElement Type;
	
	@FindBy(xpath = "//*[@id='Type_ID']/option")
	List<WebElement>ListType;
	
	@FindBy(id = "Category_Name")
	WebElement Category_Name;
	
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(xpath = "//*[@id=\"tableRefPaCategory\"]/tbody/tr[1]/td[3]")
	WebElement txtCategoryName;
	
	public void MenuPA() {
		tunggu();
		Listmenu.click();
	}
	
	public void AddCategory(String categoryName, String filter,String categoryName1) {
		scroll();
		tunggu();
		Entries.click();
		ListEntries.get(1).click();
		tunggu();
		Create.click();
		Type.click();
		ListType.get(2).click();
		Category_Name.sendKeys(categoryName);
		tunggu();
		btnSave.click();
		tunggu();
		Filter.sendKeys(filter);
		tunggu();
		CheckBox.get(0).click();
		tunggu();
		Delete.click();
		tunggu();
		Alert alert_box = driver.switchTo().alert();
		alert_box.accept(); 
		tunggu();
		Create.click();
		Type.click();
		ListType.get(2).click();
		tunggu();
		Category_Name.sendKeys(categoryName1);
		tunggu();
		btnSave.click();
		tunggu();
	}
	
	public String getTxtCategoryName() {
		return txtCategoryName.getText();	
		}
		
		public void tunggu() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void scroll() {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,500)");
		}
}
