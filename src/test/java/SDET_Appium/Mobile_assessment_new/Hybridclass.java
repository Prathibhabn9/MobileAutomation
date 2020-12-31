package SDET_Appium.Mobile_assessment_new;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Hybridclass extends capabilities{
AndroidDriver<AndroidElement> driver;

	@Test(priority=0)
	public void Testcase1() throws InterruptedException, IOException {
		
		service=startServer();
		
		driver=Base();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		driver.findElement(By.xpath(".//*[@class='android.widget.Button']")).click();
//		driver.findElement(By.xpath(".//*[@text='Dismiss']")).click();
		driver.findElement(By.xpath(".//*[@text='Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@text='Sign in']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@text='Enter an e-mail address or username']")).sendKeys("Testkhanacademy_123@gmail.com");
		
		driver.findElement(By.xpath(".//*[@text='Password']")).sendKeys("Test123$$");
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
		Thread.sleep(5000);
	}
		
		@Test(priority=1)
		public void TC2() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@text='Join class']")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("e.g. ABC123 or teacher@example.com")).sendKeys("testteacher@gmail.com");
		Thread.sleep(5000);
		//to Hide the keyboard
				driver.hideKeyboard();
				
				
				driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		Thread.sleep(5000);
		System.out.println("Clicked on add");
		Thread.sleep(5000);

				String message=driver.findElement(By.id("android:id/message")).getText();
				System.out.println(message);
		driver.findElement(By.xpath(".//*[@text='DISMISS']")).click();
		}
		@Test(priority=2)
		public void TC3() throws InterruptedException
		{
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Licenses\"))").click();
		//driver.findElement(By.xpath(".//*[@text='Licenses']")).click();
		
	  String  message=driver.findElement(By.className("android.view.View")).getText();
	    		System.out.println(message);
	    		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    	    Thread.sleep(5000);
	    	    Set<String> contextNames = driver.getContextHandles();
	    	    for (String contextName : contextNames) {
	    		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
	    		}
	    	    
		driver.context("NATIVE_APP");
		}
		@Test(priority=3)
		public void TC4() throws InterruptedException
		{
		driver.findElement(By.xpath(".//*[@text='Manage teachers']")).click();
		driver.findElement(By.xpath(".//*[@text='Add a teacher']")).click();
				
		driver.findElement(MobileBy.AccessibilityId("e.g. ABC123 or teacher@example.com")).sendKeys("test123456@gmail.com");
		driver.findElement(By.xpath(".//*[@text='ADD']")).click();
		driver.findElement(By.xpath(".//*[@text='ADD']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@text='DISMISS']")).click();
		Thread.sleep(8000);
		driver.findElement(MobileBy.AccessibilityId("Delete")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@text='REMOVE']")).click();
		Thread.sleep(5000);
		}
		
		@Test(priority=4)
		public void Tc5() throws InterruptedException
		{
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(5000);
	    
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(5000);
		for(int i=0;i<12;i++)
		{
		driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		}

	    driver.findElement(By.xpath(".//*[@text='Download now']")).click();
	    Thread.sleep(5000);
	    Set<String> contextNames = driver.getContextHandles();
	    for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context("NATIVE_APP");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
		driver.findElement(By.xpath(".//*[@text='Sign out']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("android:id/button1")).click();
		service.stop();
		}	
		
	
	@AfterClass
	public void close()
	{
		
	}

}