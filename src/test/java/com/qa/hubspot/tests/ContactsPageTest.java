package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class ContactsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}
	
	@Test
	public void VerifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
		
	}
	
	@Test
	public void verifyContactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeader();
		Assert.assertTrue(header.contains(Constants.CONTACTS_PAGE_HEADER));
		
	}
	
	@Test
	public void createContactTest() {
		Assert.assertTrue(contactsPage.createContact("sikiminbasi@yahoo.com", "amciq", "got", "qehbe"));
		
	}
	
	
	
	
	

}
