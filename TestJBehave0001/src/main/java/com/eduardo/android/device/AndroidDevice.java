package com.eduardo.android.device;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDevice {
	
	private final static String deviceName = "Google Galaxy Nexus - 4.2.2 - API 17 - 720x1280";
	private final static String applicationLocation = "C:/appium/";
	private final static String vmLocation = "C:/Program Files/Genymobile/Genymotion/player";

	public static DesiredCapabilities getConfiguredCapabilities(String appName) {		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", applicationLocation+appName+".apk");
		
		return capabilities;
	}
	
	public static void setupVM() throws ExecuteException, IOException, InterruptedException {		
		
		

        DesiredCapabilities capabilities = new DesiredCapabilities();

        DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        CommandLine launchEmul = new CommandLine("C:/Program Files/Genymobile/Genymotion/player");
        launchEmul.addArgument("--vm-name");
        launchEmul.addArgument("\""+deviceName+"\"");
        executor.setExitValue(1);
        executor.execute(launchEmul, resultHandler);
        Thread.sleep(40);

        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("platformVersion", "4.2.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app","C:/appium/TrianguloApp.apk");
        
        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        
        System.out.println("SetUp is successful and Appium Driver is launched successfully");
		
		
		
		/*DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        
		CommandLine launchEmul = new CommandLine(vmLocation);
		
        launchEmul.addArgument("--vm-name");
        launchEmul.addArgument("\""+deviceName+"\"");
        
        executor.setExitValue(1);
        executor.execute(launchEmul, resultHandler);
        
//        TODO: Wait for the Vm to set up
        Thread.sleep(10000);*/
	}
}
