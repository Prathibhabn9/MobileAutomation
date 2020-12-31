package SDET_Appium.Mobile_assessment_new;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class capabilities {
	protected static String deviceName,appActivity,appPackage,chromeDriverExecutable;
	
	public AppiumDriverLocalService service;
	
	
	//Start Appium Server through nodejs
	public AppiumDriverLocalService startServer() {
		boolean flag=checkifserviceisRunning(4723);
		if(!flag)
		{
		
//		service=AppiumDriverLocalService.buildDefaultService();
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\PrathibhaBN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723));
		        service.start();
		        }
		
		return service;
		
	}
	public static boolean checkifserviceisRunning(int port)
	{
		boolean isserverRunning=false;
		ServerSocket serverSocket;
		try {
			
		   serverSocket = new ServerSocket(port);
		   serverSocket.close();
        }
        catch (Exception e) {
            isserverRunning= true;
        }
        finally {
            serverSocket=null;
        }
        return isserverRunning;
    }
	
	public static void StartEmulator() throws IOException, InterruptedException
	{
		 Runtime.getRuntime().exec(System.getProperty("user.dir")+"./AndroidEmulator.bat");
		 Thread.sleep(10000);
	}
	
	public static AndroidDriver<AndroidElement> Base() throws IOException, InterruptedException  {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
	
	     deviceName=   ReadPropertyFileMethod("global.properties","deviceName");         
	          appActivity=  ReadPropertyFileMethod("global.properties","appActivity");  
	          appPackage= ReadPropertyFileMethod("global.properties","appPackage");  
	          chromeDriverExecutable= ReadPropertyFileMethod("global.properties","chromeDriverExecutable");  
	          if(deviceName.contains("Prathibha"))
		  		{
		  			StartEmulator();
		  		}
		  		
	          
	          System.out.println(appActivity+appPackage+chromeDriverExecutable+deviceName);
	          
	          cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	  		cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
	  		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
	  		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
	  		cap.setCapability(MobileCapabilityType.NO_RESET, true);
	  		//cap.setCapability(AndroidMobileCapabilityType., value);
	  		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
	  		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
	  		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,chromeDriverExecutable);
	  		
	  		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(10000);
		return driver;
	}
	        
	        public static String ReadPropertyFileMethod(String filename,String Key)
	        {
	            String Value = "";
	            try
	            {
	                Properties p = new Properties();
	                File F = new File(System.getProperty("user.dir") + "/src/main/java/"+filename);
	                FileInputStream FIS = new FileInputStream(F);
	                p.load(FIS);
	                
	                Value = p.getProperty(Key);
	                
	                FIS.close();
	            }
	            catch(Exception ex)
	            {
	                ex.printStackTrace();
	            }
	            
	            return Value;
	        }


}
