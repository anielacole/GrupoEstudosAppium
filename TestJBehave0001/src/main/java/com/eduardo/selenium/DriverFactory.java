package com.eduardo.selenium;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;

import com.eduardo.android.device.AndroidDevice;

public class DriverFactory {

	private static String GRID_URL = "http://127.0.0.1:4723/wd/hub";
	private static String APP_NAME = "Triangulo.apk";	
	private static AndroidDriver<WebElement> deviceActions = null;

	public static AndroidDriver<WebElement> getAndroid() {

		if(deviceActions ==null) {
			try {
				
				deviceActions = new AndroidDriver<WebElement>(new URL(GRID_URL),
						AndroidDevice.getConfiguredCapabilities(APP_NAME));
				
			} catch (MalformedURLException e) {			
				e.printStackTrace();
			}
		}
		

		return deviceActions;

	}

}
