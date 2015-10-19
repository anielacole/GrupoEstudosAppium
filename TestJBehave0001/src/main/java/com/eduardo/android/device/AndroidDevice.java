package com.eduardo.android.device;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDevice {
	
	private final static String deviceName = "";
	private final static String applicationLocation = "C:/appium/";
	private final static String vmLocation = "C:/Program Files/Genymobile/Genymotion/player";

	public static DesiredCapabilities getConfiguredCapabilities(String appName) {		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", applicationLocation+appName);
		
		return capabilities;
	}
	
	public static void setupVM() throws ExecuteException, IOException, InterruptedException {		
		DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        
		CommandLine launchEmul = new CommandLine(vmLocation);
		
        launchEmul.addArgument("--vm-name");
        launchEmul.addArgument("\""+deviceName+"\"");
        
        executor.setExitValue(1);
        executor.execute(launchEmul, resultHandler);
        
//        TODO: Wait for the Vm to set up
        Thread.sleep(10000);
	}
}
