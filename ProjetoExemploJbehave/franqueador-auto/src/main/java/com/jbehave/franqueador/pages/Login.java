package com.jbehave.franqueador.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Login extends FluentWebDriverPage{
	
	public static By textUsername = By.id("login-form:j_idt15");
	public static By textPassword = By.id("login-form:j_idt19");
	public static By buttonLogin = By.id("login-form:j_idt21");	
	public static By menu = By.id("j_idt24");
	public static String urlLocalhost = "http://localhost:7001";
	
	public Login(WebDriverProvider webDriverProvider) {
		super(webDriverProvider);
	}
	
	public void accessAplication(String context){
		if (context.equals("localhost")){
			System.out.println("urlLocalhost " + urlLocalhost);
			get(urlLocalhost.toString());
		}
	}

	public void setDataLogin(String username, String password) {
		manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		input(textUsername).sendKeys(username);
		input(textPassword).sendKeys(password);
	}

	public void access(String buttonName) {
		findElement(buttonLogin).click();
	}

	public void verifyPageHome() {
		manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertTrue(findElement(menu).isDisplayed());
	}

}
