package com.eduardo.framework.selenium;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebElement;

import com.eduardo.framework.device.AndroidDevice;

import io.appium.java_client.android.AndroidDriver;

public class AbstractPage {

	private AndroidDevice android;
	private final String app = "C:/appium/apk/br.gov.sinesp.cidadao.apk";
	private final String Device = "Google Galaxy Nexus - 4.2.2 - API 17 - 720x1280";	

	public AbstractPage() {
		
		initDriver();
	}

	private void initDriver() {

		try {

			android = new AndroidDevice(app, Device);

		} catch (ExecuteException e) {
			System.out.println("ERRO: houve um problema ao rodar a VM" + e.getMessage());

		} catch (IOException e) {
			System.out.println("ERRO: houve um problema ao carregar app" + e.getMessage());

		} catch (InterruptedException e) {
			System.out.println("ERRO: houve um problema com aexecução" + e.getMessage());
		}
	}

	public AndroidDriver<WebElement> getDriver() {

		if (android == null) {
			initDriver();
		}

		return android.getWebDriver();
	}

}
