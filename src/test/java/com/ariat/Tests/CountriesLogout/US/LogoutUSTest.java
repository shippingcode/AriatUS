package com.ariat.Tests.CountriesLogout.US;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.Environments;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.MyAccountPage;
import com.ariat.Pages.SignInPage;
import com.ariat.Tests.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class LogoutUSTest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private GlobalCountries country;



	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";

	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void logoutFromMyAccountMiddleUSTest() {
		logger.info("Starting the logout US test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.chooseGlobalLocation(country.USA, country.USA.getCurrencyISO());
		homePage.UKlocation();
		signInPage = homePage.returnSignInPage();
		signInPage.returningCustomer(EMAIL);
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.logoutMiddle();
		logger.info("I was succesfully logged out from the application!");
	}
	

	@Test
	public void logoutFromMyAccountTopUSTest() {
		logger.info("Starting the logout US test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.chooseGlobalLocation(country.USA, country.USA.getCurrencyISO());
		signInPage = homePage.returnSignInPage();
		signInPage.returningCustomer(EMAIL);
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logger.info("I was succesfully logged out from the application!");
	}


	@AfterMethod
	public void tearDown() {
		homePage.quit();
		signInPage.quit();
		myAccountPage.quit();
	}
}
