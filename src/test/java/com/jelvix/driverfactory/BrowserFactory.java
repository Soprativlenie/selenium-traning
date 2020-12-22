package com.jelvix.driverfactory;/* Created by user on 20.08.20 */

public class BrowserFactory {

    public Browser getDriver(BrowserType type) {
        Browser driver = null;
        switch (type) {
            case CHROME:
                driver = new ChromeBrowser();
                break;
            case FIREFOX:
                driver = new FireFoxBrowser();
                break;
            default:
                throw new IllegalArgumentException("Wrong driver type " + type);
        }
        return driver;
    }
}
