package com.eduardo.apps.sinesp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eduardo.framework.selenium.AbstractPage;

public class PlateSearch extends AbstractPage{

	private String locatorPlate = "android.widget.EditText";
	private String locatorPlateLetters = "	.//*[@class=android.widget.EditText[0]]";
	
	
	public boolean isPlateLettersPresent() {

		boolean result = false;
		if (getDriver().findElement(By.className(locatorPlate)).isDisplayed()) {
			result = true;
		}
		return result;

	}

	public void inputLetters(String letters) {
		
		List<WebElement> elements = getDriver().findElements(By.className(locatorPlateLetters));
		elements.get(0).sendKeys(letters);
	}

	public void inputNumbers(String numbers) {
		
		List<WebElement> elements = getDriver().findElements(By.className(locatorPlate));
		elements.get(1).sendKeys(numbers);
	}

}
