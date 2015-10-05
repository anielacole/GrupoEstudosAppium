package com.jbehave.franqueador.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class ActionsButtons extends FluentWebDriverPage {

	public ActionsButtons(WebDriverProvider webDriverProvider) {
		super(webDriverProvider);
	}
	
	public void access(String buttonName) {
		findElement(By.xpath(""+buttonName+"")).click();
	}

}
