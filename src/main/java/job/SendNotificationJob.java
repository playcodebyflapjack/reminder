package job;

public class SendNotificationJob implements Runnable 
{
	
	public SendNotificationJob()
	{
		System.out.println("SendNotificationJob");
	}

	@Override
	public void run() 
	{
	 
		System.out.println("Run");
	}

}
