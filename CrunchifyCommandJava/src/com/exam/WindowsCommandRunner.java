package com.exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WindowsCommandRunner {
	
	public WindowsCommandRunner(String execCommand) {
 
		Runtime rt = Runtime.getRuntime();
		printOutput errorReported, outputMessage;
 
		try {
			Process proc = rt.exec(execCommand);
			errorReported = this.getStreamWrapper(proc.getErrorStream(), "ERROR");
			outputMessage = this.getStreamWrapper(proc.getInputStream(), "OUTPUT");
			errorReported.start();
			outputMessage.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	public printOutput getStreamWrapper(InputStream is, String type) {
		return new printOutput(is, type);
	}
 
	private class printOutput extends Thread {
		InputStream is = null;
 
		printOutput(InputStream is, String type) {
			this.is = is;
		}
 
		public void run() {
			String s = null;
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));
				while ((s = br.readLine()) != null) {
					System.out.println(s);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
