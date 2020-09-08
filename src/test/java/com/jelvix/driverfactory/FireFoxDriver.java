package com.jelvix.driverfactory;/* Created by user on 20.08.20 */

public class FireFoxDriver implements Driver {
    @Override
    public void init() {
        System.setProperty("webdriver.gecko.driver", "/home/user/Downloads/Drivers/geckodriver");
    }
}
