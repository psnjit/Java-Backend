class SquareT implements Runnable
{
	int a;
	long squareSum=0;
	public SquareT(int a)
	{
		this.a=a;
	}

	@Override
	public void run()
	{
		for(int i=a; i<=1000; i+=2)
		{
			squareSum= squareSum + (i*i);
		}
	}

}

public class SquareThread
{
	public static void main(String [] args) throws InterruptedException
	{
		SquareT odd= new SquareT(1);
		SquareT even= new SquareT(2);
		
		Thread todd= new Thread(odd);
		Thread teven= new Thread(even);
		
		todd.start();
		teven.start();
		
		todd.join(10*1000);
		teven.join(10*1000);
		
		System.out.println(even.squareSum+"  -  "+odd.squareSum+"    =    "+(even.squareSum-odd.squareSum));
	}
}
