package com.test.tesntngexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormWebElements {
	
	By firstName=By.name("firstname");
	By lastName=By.name("lastname");
	By gender=By.name("sex");
	By experience=By.name("sex");
	By dateOfBirth=By.id("datepicker");
	By profession =By.name("profession");
	By toolsKnown=By.name("tool");
	By continent=By.id("continents");
	By knownSeleniumCommands=By.id("selenium_commands");
	
	public WebElement getFistNameElement(WebDriver driver){
		return driver.findElement(firstName);
	}
	
	public WebElement getLastNameElement(WebDriver driver){
		return driver.findElement(lastName);
	}
	
	public WebElement getGender(WebDriver driver){
		return driver.findElement(gender);
	}
	
	public WebElement getExperience(WebDriver driver){
		return driver.findElement(experience);
	}
	
	public WebElement getDateOfBirth(WebDriver driver){
		return driver.findElement(dateOfBirth);
	}
	
	public WebElement getProfession(WebDriver driver){
		return driver.findElement(profession);
	}
	
	public WebElement getKnownTools(WebDriver driver){
		return driver.findElement(toolsKnown);
	}
	
	public WebElement getContinent(WebDriver driver){
		return driver.findElement(continent);
	}
	
	public WebElement getKnownSeleniumCommands(WebDriver driver){
		return driver.findElement(knownSeleniumCommands);
	}	
}
