package com.atmecs.assesment.qaautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.assesment.qaautomation.dataproviders.ExcelReader;

public class PageAction {

	public WebDriver driver;
	ExcelReader reader = getsheet(ConstantPaths.TESTDATA_FILE);
	 
	 
	public ExcelReader getsheet(String sheetname) {
	ExcelReader read = new ExcelReader();
	try {
	read.setPath(sheetname);
	} catch (Exception e) {
	e.printStackTrace();
	}
	return read;
	}



	 public String getdata_fromExcel(String string, String columnname, String string2) {

	 String datavalue = reader.getCellDataByColumnName(string, columnname, string2);
	 return datavalue;
	 }

	public PageAction(WebDriver driver) {
		this.driver = driver;
	}

	LogReports log = new LogReports();
	WebElement webElement;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public WebElement selectLocators(String locatorType) {

		String[] locator = locatorType.split(":",2);

		switch (locator[0]) {
		case "id":
			webElement = driver.findElement(By.id(locator[1]));
			break;
		case "name":
			webElement = driver.findElement(By.name(locator[1]));
			break;
		case "className":
			webElement = driver.findElement(By.className(locator[1]));
			break;
		case "linkText":
			webElement = driver.findElement(By.linkText(locator[1]));
			break;
		case "partialLinkText":
			webElement = driver.findElement(By.partialLinkText(locator[1]));
			break;
		case "tagName":
			webElement = driver.findElement(By.tagName(locator[1]));
			break;
		case "css":
			//System.out.println(locator[1]);
			webElement = driver.findElement(By.cssSelector(locator[1]));
			break;
		case "xpath":
			webElement = driver.findElement(By.xpath(locator[1]));
			break;

		}
		return webElement;
	}

	public void click(String element) {
		try {
			webElement = selectLocators(element);
			webElement.click();
		} catch (Exception e) {
			log.info("Element not clicked");
			e.printStackTrace();
		}
	}

	public void selectVisibleText(String element, String visibleText) {
		webElement = selectLocators(element);
		Select select = new Select(webElement);
		select.selectByVisibleText(visibleText);
	}

	public void selectValue(String element, String value) {
		webElement = selectLocators(element);
		Select select = new Select(webElement);
		select.selectByValue(value);
	}

	public void selectIndex(String element, int index) {
		webElement = selectLocators(element);
		Select select = new Select(webElement);
		select.selectByIndex(index);
	}

	public void sendKeys(String element, String value) {
		webElement = selectLocators(element);
		webElement.sendKeys(value);
	}

	public void clickEnter(String element) {
		webElement = selectLocators(element);
		webElement.sendKeys(Keys.ENTER);

	}

	public void clickTab(String element) {
		webElement = selectLocators(element);
		webElement.sendKeys(Keys.TAB);

	}

	public String getText(String element) {
		webElement = selectLocators(element);
		return webElement.getText();

	}

	public void scroll(String element) {
		webElement = selectLocators(element);
		js.executeScript("window.scrollBy(0,500)");
	}

	public void mouseOn(String element) {
		webElement = selectLocators(element);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();

	}
	public void tab(String element) {
		webElement = selectLocators(element);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}
		
	public void clear(String element) {
		webElement = selectLocators(element);
		webElement.clear();
	}

}