package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By header = By.xpath("//h1");
	private By accountName = By.cssSelector("span.account-name ");
	private By settingsIcon = By.id("navSetting");
	private By contactsParentMenu = By.id("nav-primary-contacts-branch");
	private By contactsSubMenu = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	
	public String getHomePageTitle() {
//		return driver.getTitle();
		return elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 10);
	}
	
	
	public String getHeaderValue() {
		if(elementUtil.doDoIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
		
	}
	
	public String getAccountName() {
		if(elementUtil.doDoIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	
	public boolean isSettingIconExist() {
		return elementUtil.doDoIsDisplayed(settingsIcon);
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.waitForElementPresent(contactsParentMenu, 10);
		elementUtil.doClick(contactsParentMenu);
		elementUtil.waitForElementPresent(contactsSubMenu, 5);
		elementUtil.doClick(contactsSubMenu);
		
	}
	
	
	

}
