package com.exam;

//------- Follow The link: https://dzone.com/articles/extracting-text-from-image-converting-image-text


import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class RunFromImage {
	 public String getImgText(String imageLocation) {
	      ITesseract instance = new Tesseract();
	      try 
	      {
	         String imgText = instance.doOCR(new File(imageLocation));
	         return imgText;
	      } 
	      catch (TesseractException e) 
	      {
	         e.getMessage();
	         return "Error while reading image";
	      }
	   }
	   public static void main ( String[] args)
	   {
		   RunFromImage app = new RunFromImage();
	      System.out.println(app.getImgText("C:\\Users\\shariful\\Documents\\DOCS\\IMGS\\Capture.PNG"));
	   }
}
