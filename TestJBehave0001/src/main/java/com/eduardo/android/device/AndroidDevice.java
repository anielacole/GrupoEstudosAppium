package com.eduardo.android.device;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDevice {
	
	//private WebDriverWait wait;
	
	private static final String deviceName = "Google Galaxy Nexus - 4.2.2 - API 17 - 720x1280";
	private final String appPath = "C:/appium/apk/br.gov.sinesp.cidadao.apk";
	private final String vmLocation = "C:/Program Files/Genymobile/Genymotion/player";
	private int testResult = 0;
	private AndroidDriver<WebElement> driver;
	private WebElement botaoVeiculos;
	private String locatorBotoesHome = "android.widget.ImageView"; 
	

	/**
	 * Inform Appium about what system it's handling
	 * @return
	 */
	private DesiredCapabilities getConfiguredCapabilities() {		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", appPath);
		
		return capabilities;
	}
	
	public void runTest() throws ExecuteException, IOException, InterruptedException {	

		// Mobile devices have desired capabilities just like browsers do
		DesiredCapabilities capabilities = getConfiguredCapabilities();

        
        DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        // Launch VM
        
        CommandLine launchEmul = new CommandLine(vmLocation);
        launchEmul.addArgument("--vm-name");
        launchEmul.addArgument("\""+deviceName+"\"");
        executor.setExitValue(1);
        executor.execute(launchEmul, resultHandler);
        Thread.sleep(40);
		
        // get Webdriver Instance
        
       driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageView")));
    
        // didn't see me!
        
        Thread.sleep(10000);        
        	        	
    	List<WebElement> botoes = driver.findElements(By.className("android.widget.ImageView"));
	
	}
	
	private int getNumeroBotoes(String locator) {
		
        int numeroBotoes = driver.findElements(By.className(locator)).size();        
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
	
	public void clickVeiculoButton() {
//		TODO precisamos clicar nos botões:
//		http://stackoverflow.com/questions/22223814/appium-android-windows-driver-findelementby-name-is-not-working-consecut
//		Exemplo de xpath: WebElement password = driver.findElement(By.xpath("//window[1]/scrollview[1]/secure[1]"));

		
		
		//botaoVeiculos = driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout']//*[@class='android.widget.LinearLayout']//*[@class='android.widget.FrameLayout']//*[@class='android.widget.RelativeLayout']//*[@class='android.widget.ImageView']"));	
		//botaoVeiculos = driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout']//*[@class='android.widget.LinearLayout']//*[@class='android.widget.FrameLayout']//*[@class='android.widget.RelativeLayout']//*[@class='android.widget.ImageView']"));
	
		botaoVeiculos = driver.findElements(By.className("android.widget.ImageView")).get(0);
		botaoVeiculos.click();
		System.out.println("element1");
		
		WebElement botaoVeiculos2 = driver.findElements(By.className("android.widget.ImageView")).get(1);
		botaoVeiculos2.click();
		System.out.println("element2");
		
		WebElement botaoVeiculos3 = driver.findElements(By.className("android.widget.ImageView")).get(2);
		botaoVeiculos3.click();
		System.out.println("element3");
		
		Integer botaoVeiculos4 = driver.findElements(By.className("android.widget.FrameLayout")).size();
		System.out.println("botaoVeiculos4: " + botaoVeiculos4);
		
		Integer botaoVeiculos5 = driver.findElements(By.className("android.widget.LinearLayout")).size();
		System.out.println("botaoVeiculos5: " + botaoVeiculos5);
		
		Integer botaoVeiculos6 = driver.findElements(By.className("android.widget.FrameLayout")).size();
		System.out.println("botaoVeiculos6: " + botaoVeiculos6);
		
		Integer botaoVeiculos7 = driver.findElements(By.className("android.widget.RelativeLayout")).size();
		System.out.println("botaoVeiculos7: " + botaoVeiculos7);
		
		Integer botaoVeiculos8 = driver.findElements(By.className("android.widget.ImageView")).size();
		System.out.println("botaoVeiculos8: " + botaoVeiculos8);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
