package com.ariat.Tests.Product.AddToWishList.WomenCategory;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.Environments;
import com.ariat.Pages.CreateAccountPage;
import com.ariat.Pages.HomePage;
import com.ariat.Pages.MyAccountPage;
import com.ariat.Pages.MyAccountWishListPage;
import com.ariat.Pages.MyWishListPage;
import com.ariat.Pages.SignInPage;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearSubcategories.CasualShoeProductPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearSubcategories.WomenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.BreechProductPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenClothingPage;
import com.ariat.Tests.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Product page - > Women Category -> Add to Wishlist test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductAddToWishListWomenCategoryTest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
    private CasualShoeProductPage womenCasualShoe;
    private WomenFootwearCasualShoesPage womenFootwareCasualShoePage;
	private MyWishListPage myWishListPage;
	private WomenCategoryPage womenCategoryPage;
	private WomenClothingPage womenClothingPage;
	private BreechProductPage breechProductPage;
	private MyAccountWishListPage myAccountWishListPage;
	private CreateAccountPage createAccountPage;
	
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String BIRTH_MONTH = "March";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateEmail(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String ORDER_NO = GenerateRandomDataUtils.generateRandomNumber(8);
	public static final String BILLING_ZIP_CODE = GenerateRandomDataUtils.generateRandomNumber(6);
	
	public static final String F_NAME = "Aila";
	public static final String L_NAME = "Bogasieru";
	public static final String EMAIL_WISHLIST = "aila.bogasieru@ariat.com";
	
	
	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test(priority=0)
	public void productPageWomenCategoryAddToWishListLoggedTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist being logged test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.UKlocation();
		signInPage = homePage.returnSignInPage();
		signInPage.returningCustomer("aila.bogasieru@ariat.com");
		signInPage.returningPassword("Parola12345!");
		myAccountPage = signInPage.returnMyAccountPage();
		womenFootwareCasualShoePage = myAccountPage.returnWomenFootwearCasualShoesPage();
		womenCasualShoe = womenFootwareCasualShoePage.returnCasualShoeProductPage();
		womenCasualShoe.selectAttributeSize("6");
		myWishListPage = womenCasualShoe.returnMyWishListPage();
		logger.info("Finishing product page -> Women Category Add to WishList being logged test.");
	} 
	
 @Test(priority=1)
	public void productPageWomenCategoryAddToWishListNotLoggedTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist not being logged test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.UKlocation();
		womenCategoryPage = homePage.returnWomenCategoryPage();
		womenClothingPage = womenCategoryPage.returnWomenClothingCategoryLeftNavPage();
		breechProductPage = womenClothingPage.returnBreechProductPage();
		breechProductPage.selectAttributeSize("36");
		breechProductPage.selectAttributeLength("Regular");
		myAccountWishListPage = breechProductPage.returnMyAccountWishListPage();
		myAccountWishListPage.returningCustomer(EMAIL);
		myAccountWishListPage.returningCustomer(PASSWORD);
		myWishListPage = myAccountWishListPage.returnMyWishListPage();
		logger.info("Finishing product page -> Women Category Add to WishList not being logged test.");
	}
	
	@Test(priority=2)
	public void productPageWomenCategoryAddToWishListCreateAccountTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist create account test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.UKlocation();
		womenCategoryPage = homePage.returnWomenCategoryPage();
		womenClothingPage = womenCategoryPage.returnWomenClothingCategoryLeftNavPage();
		breechProductPage = womenClothingPage.returnBreechProductPage();
		breechProductPage.selectAttributeSize("34");
		breechProductPage.selectAttributeLength("Long");
		myAccountWishListPage = breechProductPage.returnMyAccountWishListPage();
		createAccountPage = myAccountWishListPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME);
		createAccountPage.lastNameInfo(LAST_NAME);
		createAccountPage.selectBirthMonth(BIRTH_MONTH);
		createAccountPage.selectBirthDay(BIRTH_DAY);
		createAccountPage.GenderFemale();
		createAccountPage.enterEmail(EMAIL);
		createAccountPage.confirmEmail(EMAIL);
		createAccountPage.enterPassword(PASSWORD);
		createAccountPage.confirmPassword(PASSWORD);
		myAccountWishListPage = createAccountPage.returnMyAccountWishListPage();
		logger.info("Finishing product page -> Women Category Add to WishList create account test.");
	}
	
	@Test(priority=3)
	public void productPageWomenCategoryFindSomeoneWishListTest() {
		logger.info("Starting product page -> Women Category find someone's WishList test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.UKlocation();
		womenCategoryPage = homePage.returnWomenCategoryPage();
		womenClothingPage = womenCategoryPage.returnWomenClothingCategoryLeftNavPage();
		breechProductPage = womenClothingPage.returnBreechProductPage();
		breechProductPage.selectAttributeSize("34");
		breechProductPage.selectAttributeLength("Long");
		myAccountWishListPage = breechProductPage.returnMyAccountWishListPage();
		myAccountWishListPage.findWishListFName(F_NAME);
		myAccountWishListPage.findWishListLName(L_NAME);
		myAccountWishListPage.findWishListEmail(EMAIL_WISHLIST);
		myAccountWishListPage.findWishListClick();
		logger.info("Finishing product page -> Women Category find someone's WishList test.");
	}
		
	@AfterTest
	public void tearDown() {
		homePage.quit();
		signInPage.quit();
		myAccountPage.quit();
		womenCasualShoe.quit();
		myWishListPage.quit();
		womenFootwareCasualShoePage.quit();
		createAccountPage.quit();
		
	}
}
