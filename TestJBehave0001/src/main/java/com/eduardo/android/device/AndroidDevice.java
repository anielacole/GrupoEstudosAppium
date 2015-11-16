package com.eduardo.android.device;

import java.io.IOException;
import java.net.URL;

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
        
        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageView")));
    
        // didn't see me!
        
        Thread.sleep(10000);
                
        int sized = driver.findElements(By.className("android.widget.ImageView")).size();        
        System.out.println("INFO: lista de elementos encontrada "+sized);        
        
        // Atribuir resultado        
        	testResult = sized;		
	
	}

	public int getResultMessage() {		
		return testResult;
	}
	
}
