package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import job.SendNotificationJob;

public class BackgroundJobManager implements SystemEventListener {
	private ScheduledExecutorService scheduler;

	public void init() 
	{
		System.out.println("init");
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new SendNotificationJob(), 0, 1, TimeUnit.DAYS);
	}

	public void destroy() 
	{
		System.out.println("destroy");
		scheduler.shutdownNow();
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return true;
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException 
	{
		if (event instanceof PostConstructApplicationEvent) 
		{
			init();
		} else if (event instanceof PreDestroyApplicationEvent)
		{
			destroy();
		}

	}
}
