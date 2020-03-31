package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

public class PaymentMethodsCheckoutPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(PaymentMethodsCheckoutPage.class);

	
	
	private By monthExpirationUS = By.xpath("//span[text()='June']");
	private By yearExpirationUS = By.xpath("//span[text()='2021']");
	private By securityCode = By.cssSelector(".checkout__card-cvn .el-input__inner");
	private By pinTxtBox = By.xpath("//input[@placeholder='Pin']");
	private By applyGifCard = By.xpath("//button//span[text()='Apply']");
	private By expandGiftCard = By.xpath("//i[text()='Gift card']");
	private By expandPromoCode = By.xpath("//i[text()='Promo code']");
	private By nameText = By.cssSelector(".checkout__card-name .el-input__inner");
	private By cardNoUS = By.xpath("//input[@id='c-cardnumber']");
	private By klarnaBtn = By.cssSelector(".payment-method__KLARNA > .el-radio__label");
	private By sofortBtn = By.cssSelector(".payment-method__SOFORT > .el-radio__label");
	private By giropayBtn = By.cssSelector(".payment-method__GIROPAY > .el-radio__label");
	private By payPalBtn = By.xpath("//span[text()='Paypal']");
	private By creditCardBtn = By
			.xpath("//label[@class='el-radio is-checked payment-method-radio payment-method__SA_SILENTPOST']");
	private By reviewOrderBtn = By.id("paymentbtncs");
	private By reviewOrderBtnUS = By.cssSelector(".checkout_place-order-btn");
	private By idealBtn = By.xpath("//span[contains(text(), 'iDeal')]");
	private By useAddressAsItIsBtn = By.cssSelector(".ms-margin-bottom-10 > .el-button > span");
	private By placeOrderBtnUS = By.id("confirmpayment");
	private By buyNowBtn = By.id("confirmpayment");
	private By arrowCountry = By.xpath("//span[@class='el-input__suffix']");
	private By selectState = By.xpath("//span[text()='Arizona']");
	private By expirationDateMonthUS = By.cssSelector(".el-form-item:nth-child(4) .el-select__caret");
	private By arrowExpYearUS = By.cssSelector(".el-form-item:nth-child(5) .el-select:nth-child(2) .el-select__caret");
		
	
	protected PaymentMethodsCheckoutPage(WebDriver driver) {
		super(driver);
	}
		
	public void setPaymentDetailsSecureCheckoutUS(String cardNameValue, String cardNumberValue, String securityCardValue) {
		WebDriverUtils.scroll350Down(driver, nameText);
		WebDriverUtils.enterTextBox(driver, nameText, cardNameValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebElement iframeSwitch = driver.findElement(By.id("dieCommFrame"));
		driver.switchTo().frame(iframeSwitch);
		WebDriverUtils.scroll350Down(driver, cardNoUS);
		WebDriverUtils.enterTextBox(driver, cardNoUS, cardNumberValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		driver.switchTo().defaultContent();
		WebDriverUtils.scroll350Down(driver, expirationDateMonthUS);
		WebDriverUtils.clickOnElementWithWait(driver, expirationDateMonthUS);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, monthExpirationUS);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, arrowExpYearUS);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, yearExpirationUS);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, securityCode, securityCardValue);
	}
	
	public void setSecurityCodePaymentMethodLogged(String securityCardValue) {
		WebDriverUtils.scroll1500Down(driver, securityCode);
		WebDriverUtils.enterTextBox(driver, securityCode, securityCardValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void pressPaymentMethods(String optionMethod) {
		switch (optionMethod) {
		case "Klarna":
			logger.info("Choosing Klarna..");
			WebDriverUtils.scroll500Down(driver, klarnaBtn);
			WebDriverUtils.clickOnElementWithWait(driver, klarnaBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "Sofort":
			logger.info("Choosing Sofort..");
			WebDriverUtils.scroll350Down(driver, sofortBtn);
			WebDriverUtils.clickOnElementWithWait(driver, sofortBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "Giropay":
			logger.info("Choosing Giropay..");
			WebDriverUtils.scroll350Down(driver, giropayBtn);
			WebDriverUtils.clickOnElementWithWait(driver, giropayBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "CreditCard":
			logger.info("Choosing  Credit Card..");
			WebDriverUtils.scroll350Down(driver, creditCardBtn);
			WebDriverUtils.clickOnElementWithWait(driver, creditCardBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "Ideal":
			logger.info("Choosing  Ideal..");
			WebDriverUtils.scroll350Down(driver, idealBtn);
			WebDriverUtils.clickOnElementWithWait(driver, idealBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "PayPal":
			logger.info("Choosing PayPal..");
			WebDriverUtils.scroll350Down(driver, payPalBtn);
			WebDriverUtils.clickOnElementWithWait(driver, payPalBtn);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;
		default:
			throw new RuntimeException("Language" + optionMethod + "not supported");
		}
	}
	
	public void enterSecurityCode(String securityCardValue) {
		logger.info("Entering security card..");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, securityCode, securityCardValue);
	}

	public void reviewOrderUS() {
		WebDriverUtils.scroll350Down(driver, reviewOrderBtn);
		WebDriverUtils.clickOnElementWithWait(driver, reviewOrderBtnUS);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void expandPromoCode() {
		logger.info("Expanding promo code..");
		WebDriverUtils.clickOnElementWithWait(driver, expandPromoCode);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void expandGiftCard() {
		logger.info("Expanding gift card..");
		WebDriverUtils.clickOnElementWithWait(driver, expandGiftCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void apply() {
		logger.info("Apply..");
		WebDriverUtils.clickOnElementWithWait(driver, applyGifCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterPin(String pinValue) {
		logger.info("Entering pin..");
		WebDriverUtils.enterTextBox(driver, pinTxtBox, pinValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void useAddressAsItIs() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, useAddressAsItIsBtn);
	}
	
	public void scroll1500DownSecurittCode() {
		WebDriverUtils.scroll1500Down(driver, securityCode);
	}


	public void placeOrderUS() {
		logger.info("Placing my order..");
		WebDriverUtils.scroll350Down(driver, placeOrderBtnUS);
		WebDriverUtils.clickOnElementWithWait(driver, placeOrderBtnUS);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
		public void clickBuyNow() {
		logger.info("Buying now..");
		WebDriverUtils.clickOnElementWithWait(driver, buyNowBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
		
	public void selectState() {
		logger.info("Selecting state..");
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, selectState);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
}
