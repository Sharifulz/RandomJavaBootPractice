package com.exam;

import java.io.IOException;

public class RunAdminCmd {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		rt.exec("C:\\Windows\\System32\\cmd.exe dir");
	} 
}
