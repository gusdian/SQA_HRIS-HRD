package com.juaracoding.sqahrishrd.step_definition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.sqahrishrd.config.AutomationFrameworkConfig;
import com.juaracoding.sqahrishrd.drivers.DriverSingleton;
import com.juaracoding.sqahrishrd.pages.CategoryPage;
import com.juaracoding.sqahrishrd.pages.LoginPage;
import com.juaracoding.sqahrishrd.pages.ReportPage;
import com.juaracoding.sqahrishrd.pages.TemplatePAPage;
import com.juaracoding.sqahrishrd.utils.ConfigurationProperties;
import com.juaracoding.sqahrishrd.utils.Constants;
import com.juaracoding.sqahrishrd.utils.TestCases;
import com.juaracoding.sqahrishrd.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private CategoryPage Categorypage;
	private TemplatePAPage templatePAPage;
	private ReportPage reportPage;
	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReport.html");
	
	
	@Autowired
	ConfigurationProperties configProp;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configProp.getBrowser());
		loginPage = new LoginPage();
		Categorypage = new CategoryPage();
		templatePAPage = new TemplatePAPage();
		reportPage = new ReportPage();
		
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
		
	}
	
	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	@AfterAll
	public static void closeBrowser() {
//		driver.quit();
	}
	
	//----------------------( Login Page )----------------------//
	@Given("User mengakses url")
	public void user_akses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to "+Constants.URL);
	}
	
    @When("User valid klik login button")
    public void user_valid_klik_login() {
    	loginPage.submitLoginValid(configProp.getEmail(), configProp.getPassword());
    	extentTest.log(LogStatus.PASS, "User valid klik login button");
    }
    
    @Then("User berhasil login")
    public void user_berhasil_login() {
    	tunggu(3);
    	assertEquals(configProp.getTxtWelcome(), loginPage.getTxtWelcome());
    	extentTest.log(LogStatus.PASS, "User berhasil login");
    }
	
    @When("User invalid klik login button")
    public void user_invalid_klik_login() {
    	tunggu(1);
    	loginPage.Logout();
    	tunggu(1);
    	loginPage.submitLoginInvalid(configProp.getEmail_wrong(), configProp.getPassword_wrong());
    	extentTest.log(LogStatus.PASS, "User invalid klik login button");
    }
    
    @Then("User gagal login")
    public void user_gagal_login() {
    	tunggu(1);
    	assertEquals(configProp.getTxtWrongEmailPass(), loginPage.getTxtWrongEmailPass());
    	extentTest.log(LogStatus.PASS, "User gagal login");
    }
    
    @Then("User login lagi")
    public void user_login_lagi() {
    	tunggu(2);
    	loginPage.submitLoginValid(configProp.getEmail(), configProp.getPassword());
    	extentTest.log(LogStatus.PASS, "User login lagi");
    }

  //----------------------( Template Page )----------------------//
    
    @When("HRD klik Menu Performance Appraisal New")
	public void hrd_klik_menu_PA_new() {
		tunggu(2);
		templatePAPage.goToMenuPA();
		extentTest.log(LogStatus.PASS, "HRD klik Menu Performance Appraisal New");
	}
	
    @Then("HRD klik Create Template")
    public void hrd_klik_template_pa() {
    	tunggu(2);
    	templatePAPage.createTemplatePA();
    	extentTest.log(LogStatus.PASS, "HRD klik Create Template");
    }
	
    
    @When("HRD tidak menginput Template Name")
    public void hrd_tidak_input_template_name() {
    	templatePAPage.switch_window();
    	tunggu(2);
    	templatePAPage.dataTemplatePA();
    	extentTest.log(LogStatus.PASS, "HRD tidak menginput Template Name");
    }
    
    @Then("Template Name Wajib Diisi")
    public void validasi_template_name() {
    	tunggu(1);
    	assertEquals(configProp.getTxtTemplateName(), templatePAPage.getValidasiTemplateName());
    	extentTest.log(LogStatus.PASS, "Template Name Wajib Diisi");
    }
    
    @And("HRD menginput Template Name")
    public void hrd_input_template_name() {
    	tunggu(2);
    	templatePAPage.addTemplateName(configProp.getTemplateName());
    	extentTest.log(LogStatus.PASS, "HRD menginput Template Name");
    }
    
    @When("HRD memilih Department")
    public void hrd_pilih_department() {
    	tunggu(2);
    	templatePAPage.createPrivilegePADepartment();
    	extentTest.log(LogStatus.PASS, "HRD memilih Department");
    }
    
   	@And("HRD memilih Unit")
   	public void hrd_pilih_unit() {
   		tunggu(1);
   		templatePAPage.addUnit();
   		extentTest.log(LogStatus.PASS, "HRD memilih Unit");
   	}
   	
   	@Then("HRD Complete Process")
   	public void hrd_klik_complete_process() {
   		templatePAPage.completeProcess();
   		extentTest.log(LogStatus.PASS, "HRD Complete Process");
   	}
    
    
    
  //----------------------( Category Page )----------------------//
   @When("HRD Klik Menu PA")
   public void hrd_klik_menu_pa() {
	   tunggu(1);
	   Categorypage.MenuPA();
	   extentTest.log(LogStatus.PASS, "HRD Klik Menu PA");
   }
   
	   @Then("HRD Membuat Template Category")
	   public void hrd_membuat_template_category() {
		tunggu(1);
		Categorypage.AddCategory(configProp.getCategoryName(), configProp.getFilter(), configProp.getCategoryName1());
		extentTest.log(LogStatus.PASS, "HRD Membuat Template Category");
	   }
	   
		@And("HRD Berhasil Membuat Template Category")
		public void hrd_berhasil_membuat_template_category() {
			tunggu(1);
	    	assertEquals(configProp.getTxtCategoryName(), Categorypage.getTxtCategoryName());
	    	extentTest.log(LogStatus.PASS, "HRD Berhasil Membuat Template Category");
		}
		
//----------------------( Report Page )----------------------//
		   
	    @When("User klik PA Report")
	    public void user_klik_pa_report() {
	    	tunggu(1);
	    	reportPage.PANew(configProp.getPa());
	    	assertEquals(configProp.getTxtDashboard(), reportPage.getTxtDashboard());
	    	extentTest.log(LogStatus.PASS, "User masuk halaman dashboard");
	    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    	driver.switchTo().window(tabs.get(1));
	    }
	    
	    @Then("User on Report Page")
	    public void user_on_report_page() {
	    	tunggu(1);
	    	assertEquals(configProp.getTxtReport(), reportPage.getTxtReport());
	    	extentTest.log(LogStatus.PASS, "User masuk halaman report");
	    	reportPage.HalReport(configProp.getHal(), configProp.getGroup(), configProp.getDivi(), configProp.getFilter1());
	    }
	    
	    @Then("User berhasil export")
	    public void user_berhasil_export() {
	    	tunggu(1);
	    	reportPage.exportExcel();
	    	assertEquals(configProp.getTxtExport(), reportPage.getTxtExport());
	    	extentTest.log(LogStatus.PASS, "User berhasil export");
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
