package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contain specific locators and methods for Add a credit card page and
 * links to
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class AddACreditCardPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(AddACreditCardPage.class);

	private By cardNickNameTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_nickname");
	private By nameOnTheCardTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_owner");
	private By securityCodeText = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_cvn");
	private By applyButton = By.id("applyBtn");
	private By cancelButton = By.xpath("//button[text()='Cancel]");
	private By creditCardInfoText = By.xpath("//*contains[text(), 'Credit card information']");
	private By expirationDateMonthUS = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_month");
	private By arrowExpYearUS = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_year");
	private By cardNoUS = By.xpath("//input[@id='c-cardnumber']");
	

	public AddACreditCardPage(WebDriver driver) {
		super(driver);
	}
	
	public void setDetailsCreditCardUS(String cardId, String cardOwner, String number, String month, String year) {
		logger.info("Entering card id...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNickNameTextBox, cardId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameOnTheCardTextBox, cardOwner);
		WebElement iframeSwitch = driver.findElement(By.id("dieCommFrame"));
		driver.switchTo().frame(iframeSwitch);
		WebDriverUtils.scroll350Down(driver, cardNoUS);
		WebDriverUtils.enterTextBox(driver, cardNoUS, number);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		driver.switchTo().defaultContent();
		WebDriverUtils.scroll350Down(driver, expirationDateMonthUS);
		WebDriverUtils.selectVisibleText(driver, expirationDateMonthUS, month);
		WebDriverUtils.selectVisibleText(driver, arrowExpYearUS, year);
		}
	
	public void enterSecurityCode(String cvs) {
		logger.info("Entering security code...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, securityCodeText, cvs);
	
	}
	public void applyCardCreation() {
		logger.info("Creating new credit card");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scroll350Down(driver, applyButton);
		WebDriverUtils.clickOnElementWithWait(driver, applyButton);
	}

	public void cancelCardCreation() {
		logger.info("Canceling the card creation");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, cancelButton);
	}
	
     public PaymentInformationPage returnPaymentInformationPage() {
    	 //WebDriverUtils.scroll350Down(driver, applyButton);
		WebDriverUtils.clickOnElementWithWait(driver, applyButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(creditCardInfoText));
		return new PaymentInformationPage(driver);
	}
}
