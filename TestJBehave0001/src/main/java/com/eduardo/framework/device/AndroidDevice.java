package com.eduardo.framework.device;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.eduardo.framework.vm.GenymotionRunner;

import io.appium.java_client.android.AndroidDriver;


public class AndroidDevice {

	private static String deviceName;
	private String appPath;	
	private AndroidDriver<WebElement> driver;
	private GenymotionRunner genny;

	public AndroidDevice(String appPath, String deviceName) throws ExecuteException, IOException, InterruptedException {
		genny = new GenymotionRunner(deviceName, RunContext.GenymotionVMLocation);
		genny.init();
		this.appPath = appPath;
		AndroidDevice.deviceName = deviceName;		
		runApp();
	}	
	
	public void setDeviceName(String name) {
		AndroidDevice.deviceName = name;
	}	

	/**
	 * 
	 * @return retorna a instancia do webdriver para uso pelas paginas
	 */
	public AndroidDriver<WebElement> getWebDriver() {
		return driver;
	}

	/**
	 * Inform Appium about what system it's handling
	 * 
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

	private void runApp() throws ExecuteException, IOException, InterruptedException {

		// Mobile devices have desired capabilities just like browsers do
		DesiredCapabilities capabilities = getConfiguredCapabilities();
		//	DefaultExecutor executor = new DefaultExecutor();
		//DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		// Launch VM
		genny.init();
		
		/*CommandLine launchEmul = new CommandLine(vmLocation);
		launchEmul.addArgument("--vm-name");
		launchEmul.addArgument("\"" + deviceName + "\"");
		executor.setExitValue(1);
		executor.execute(launchEmul, resultHandler);
	*/
		
		
		//TODO mover para selenium
		Thread.sleep(40);

		// get Webdriver Instance

		driver = new AndroidDriver<>(new URL(RunContext.SeleniumGridLocal), capabilities);

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageView")));

		// didn't see me!

		//TODO mover para selenium
		Thread.sleep(10000);

	}

}
