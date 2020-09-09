package com.exam.threads;

public class SingleThread extends Thread{
	SingleThread(){
	     super("my extending thread");
	     System.out.println("my thread created" + this);
	     start();
	   }
	   public void run()
	   {
	     try
	     {
	        for (int i=0 ;i<10;i++)
	        {
	           System.out.println("Printing the count " + i);
	           Thread.sleep(1000);
	        }
	     }
	     catch(InterruptedException e)
	     {
	        System.out.println("my thread interrupted");
	     }
	     System.out.println("My thread run is over" );
	   }
	}

	class ExtendingExample
	{
	   public static void main(String args[])
	   {
		   SingleThread cnt = new SingleThread();
	      try
	      {
	         while(cnt.isAlive())
	         {
	           System.out.println("Main thread will be alive till the child thread is live");
	           Thread.sleep(1500);
	         }
	      }
	      catch(InterruptedException e)
	      {
	        System.out.println("Main thread interrupted");
	      }
	      System.out.println("Main thread's run is over" );
	   } 
}

