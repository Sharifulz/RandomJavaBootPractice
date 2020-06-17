package com.exam.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//return "<h1 style='color:blue; text-align:center;'>Welcome from CTrends <span style='color:red'>GIS</span> App </h1>";
		return "index.html";
	}
	
	@GetMapping("/ip")
	public String ipAddressPrint() {
		//return "<h1 style='color:blue; text-align:center;'>Welcome from CTrends <span style='color:red'>GIS</span> App </h1>";
		String res = printIpInfo();
		return res;
	}
	
	public String printIpInfo() {
		 InetAddress ip;
	     String hostname;
	     String fullAddress="";
	     
	        try {
	            ip = InetAddress.getLocalHost();
	            String[] latLngArray = ip.toString().split("/");
	            hostname = ip.getHostName();
	            System.out.println("Your current IP address : " + latLngArray[1]);
	            System.out.println("Your current Hostname : " + hostname);
	            fullAddress += latLngArray[1]+hostname;
	 
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        }
	        return fullAddress;
	       
	}
}
