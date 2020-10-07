package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage  {
	
	ElementUtil elementUtil;
	private WebDriver driver;
	
	private By header = By.cssSelector("h1[class*=IndexPageRedesignHeader]");
	private By createContactPrimary = By.xpath("//span[text()='Create contact']");
	private By email = By.xpath("//input[@data-field='email']");
	private By firstName = By.xpath("//input[@data-field='firstname']");
	private By lastName = By.xpath("//input[@data-field='lastname']");
	private By jobTitle = By.xpath("//textarea[@id='UIFormControl-47']");
	private By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	private By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	
	public ContactsPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}
	
	public String getContactsPageHeader() {
		elementUtil.waitForElementPresent(header, 10);
		return elementUtil.doGetText(header);
	}
	
	public boolean createContact(String emailId, String firstN, String lastN, String jobT) {
		elementUtil.clickWhenReady(createContactPrimary, 10);
		elementUtil.waitForElementToBeVisible(email, 10);
		elementUtil.doSendKeys(email, emailId);
		elementUtil.doSendKeys(firstName, firstN);
		elementUtil.doSendKeys(lastName, lastN);
		elementUtil.waitForElementToBeVisible(jobTitle, 10);
		elementUtil.doSendKeys(jobTitle, jobT);
		
		elementUtil.clickWhenReady(createContactSecondary, 5);
		String fullName = firstN+" "+ lastN;
		elementUtil.waitForElementToBeVisible(By.xpath("//span[text()= '\"+fullName+\"']"), 10);
		boolean flag = elementUtil.doDoIsDisplayed(By.xpath("//span[text()= '"+fullName+"']"));
		
		elementUtil.clickWhenReady(contactsBackLink, 10);
		return flag;
		
	}

}
