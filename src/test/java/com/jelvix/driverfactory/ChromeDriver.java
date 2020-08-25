package com.jelvix.driverfactory;/* Created by user on 20.08.20 */

public class ChromeDriver implements Driver {
    @Override
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Downloads/Drivers/chromedriver");
    }
}
