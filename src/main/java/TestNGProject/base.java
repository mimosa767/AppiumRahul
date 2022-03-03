package TestNGProject;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
    public static AppiumDriverLocalService service;
    public void startServer() {
       service =  AppiumDriverLocalService.buildDefaultService();
       service.start();
    }
}
