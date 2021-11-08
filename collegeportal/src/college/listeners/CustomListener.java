package college.listeners;

import java.util.Calendar;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CustomListener
 *
 */
@WebListener
public class CustomListener implements HttpSessionListener {
	HttpSession hs=null;

    /**
     * Default constructor. 
     */
    public CustomListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  
    { 
        hs=se.getSession();
        String id=hs.getId();
        System.out.println("session_id is"+id);
    	long info=hs.getCreationTime();
    	System.out.println(info);
    	Calendar c=Calendar.getInstance();
    	c.setTimeInMillis(info);
    	int hour=c.get(Calendar.HOUR);
    	int minutes=c.get(Calendar.MINUTE);
    	int second=c.get(Calendar.SECOND);
    	int day=c.get(Calendar.DATE);
    	int month=c.get(Calendar.MONTH);
    	int year=c.get(Calendar.YEAR);
    	System.out.println("Hour"+hour+"Minutes"+minutes+"Seconds"+second+"day"+day+"Month"+(month+1)+"year"+year);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
