
package org.test;

import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.login.LoginPage;



public class BrowserLaunch extends BaseClass{
	public static void main(String[] args) {
		
		launchBrowser("chrome");
		launchUrl("https://www.facebook.com/");
		implicityWait(10);
		
		LoginPage l=new LoginPage();
		
		sendkeys(l.getTxtUsername(), "ajith");
		sendkeys(l.getTxtUpassword(), "1234");
		
        driver.navigate().refresh();
		
		sendkeys(l.getTxtUsername(), "kumar");
		
		buttonClick(l.getBtnLogin());

	
		
	}
}

