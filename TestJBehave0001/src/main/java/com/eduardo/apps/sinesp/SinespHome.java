package com.eduardo.apps.sinesp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.eduardo.framework.device.AndroidDevice;
import com.eduardo.framework.selenium.AbstractPage;

public class SinespHome extends AbstractPage{
	
	private AndroidDevice android;
	private String locatorBotoesHome = "android.widget.ImageView"; 
	private int testResult = 0;
	private WebElement botaoVeiculos;
	
	private int getNumeroBotoes(String locator) {
		
		@SuppressWarnings("unused")
		List<WebElement> botoes = getDriver().findElements(By.className("android.widget.ImageView"));
		
        int numeroBotoes = getDriver().findElements(By.className(locator)).size();        
        System.out.println("INFO: lista de elementos encontrada "+numeroBotoes);
   
        return numeroBotoes;
        
	}
	
	public int getNumeroBotoesHome () {
		System.out.println("Lista botoes" + getNumeroBotoes(locatorBotoesHome));
		return getNumeroBotoes(locatorBotoesHome);
		
	}

	public int getResultMessage() {		
		return testResult;
	}
	
	public void clickHelpButton() {
//		
		Dimension screenDim = getDriver().manage().window().getSize();
		
		System.out.println("tamanho horizontal:"+screenDim.getWidth());
		System.out.println("tamanho vertical:"+screenDim.getHeight());
		
		int x = (int)(0.5 * screenDim.getWidth());
		int y = (int)(0.25 * screenDim.getHeight());
		
		android.getWebDriver().tap(1,x,y,10);
		
		System.out.println("cliquei em:"+x+" "+y+".");
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void clickVeiculoButton() {
//		
		Dimension screenDim = getDriver().manage().window().getSize();
		
		System.out.println("tamanho horizontal:"+screenDim.getWidth());
		System.out.println("tamanho vertical:"+screenDim.getHeight());
		
		int x = (int)(0.76 * screenDim.getWidth());
		int y = (int)(0.60 * screenDim.getHeight());
		
		android.getWebDriver().tap(1,x,y,10);
		
		System.out.println("cliquei em:"+x+" "+y+".");
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
