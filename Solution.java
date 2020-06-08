import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class FactorialThread implements Runnable
{
	private BigInteger number;
	private boolean stopFlag;
	
	public void setStopFlag()
	{
		this.stopFlag=true;
	}
	
	public FactorialThread (BigInteger number)
	{
		this.stopFlag=false;
		this.number=number;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void factorial()
	{
	    BigInteger result = BigInteger.ONE;
	    BigInteger targetNumber= new BigInteger(number.toString());
	    while (!targetNumber.equals(BigInteger.ZERO) && !this.stopFlag)
	    {
	        result = result.multiply(number);
	        targetNumber = targetNumber.subtract(BigInteger.ONE);
	    }
	    
	    if(!this.stopFlag)
	    System.out.println("The factorial of "+number+" is: "+result);
	}
	
	public void run()
	{
		this.factorial();
	}
}


class Solution
{
	public static void main2(String [] args) throws IOException
	{
			BigInteger inputArray[]= {new BigInteger("1562374"), new BigInteger("5211643782214253"),
					                  new BigInteger("4152637"), new BigInteger("4637"), new BigInteger("3422")};
			
			FactorialThread threadList[]= new FactorialThread[5];
			
			for(int index=0; index<5; index++)
			{
				threadList[index] = new FactorialThread(inputArray[index]);
			}
			try
			{
				Thread.sleep(4000*1000);
				for(int index=0; index<5; index++)
				{
					threadList[index].setStopFlag();
				}
				System.out.println("40 secs over. Closing the threads.");
			}
			catch (InterruptedException e)
			{
				System.out.println("Interrupted"+e.getStackTrace());
			}
	}
}