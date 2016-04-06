package com.eduardo.framework.vm;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class GenymotionRunner {
	
	private String deviceName;
	private String vmLocation = "C:/Program Files/Genymobile/Genymotion/player";

	public GenymotionRunner(String deviceName, String VMLocation) {
		setDeviceName(deviceName);
		vmLocation = VMLocation;
		init();
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}	
	
	public void setVmLocation(String vmLocation) {
		this.vmLocation = vmLocation;
	}
	
	private void init() {
		
		try {
			DefaultExecutor executor = new DefaultExecutor();
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

			CommandLine launchEmul = new CommandLine(vmLocation);
			launchEmul.addArgument("--vm-name");
			launchEmul.addArgument("\"" + getDeviceName() + "\"");
			executor.setExitValue(1);
			
		} catch (Exception e) {			
			System.out.println("Não foi possível abrir a VM. Erro: " + e.getMessage());		
		} 
		
	}
}
