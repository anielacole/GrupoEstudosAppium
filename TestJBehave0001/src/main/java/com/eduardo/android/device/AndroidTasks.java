package com.eduardo.android.device;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;

import com.eduardo.selenium.DriverFactory;

public class AndroidTasks {

	private static final String DEFAULT_ERROR_MSG = "ERROR: something went wrong! ";

	public void setup() {

	}

	public static void fireDevice() {
		try {
			AndroidDevice.setupVM();

		} catch (ExecuteException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			notifyFailure(e.getMessage());
		}
	}

	private static void notifyFailure(String message) {
		System.out.println(DEFAULT_ERROR_MSG + message);
	}

	public void touch(String locator) {
		DriverFactory.getAndroid().findElement(By.id(locator)).click();
	}

}
