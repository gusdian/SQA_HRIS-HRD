package com.juaracoding.sqahrishrd.step_definition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.sqahrishrd.config.AutomationFrameworkConfig;
import com.juaracoding.sqahrishrd.drivers.DriverSingleton;
import com.juaracoding.sqahrishrd.pages.LoginPage;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReport.html");
	
	
	@Autowired
	ConfigurationProperties configProp;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configProp.getBrowser());
		loginPage = new LoginPage();
		
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
    	tunggu(2);
    	loginPage.submitLoginValid(configProp.getEmail(), configProp.getPassword());
    }

  //----------------------( Target Page )----------------------//
   

	@Then("Menampilkan data yang dicari")
	public void tampil_search_PA360() {
    	tunggu(2);
    	extentTest.log(LogStatus.FAIL, "Menampilkan data yang dicari");
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
