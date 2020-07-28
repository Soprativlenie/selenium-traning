package com.jelvix.cookies;/* Created by user on 28.07.20 */

import org.openqa.selenium.Cookie;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

public class CookiesHandler {
    private String cookiePath = "/";
    private Date cookieExpires = DatatypeConverter.parseDateTime("2021-01-01T12:00:00Z").getTime();
    private Cookie closeSubscribeCookie = new Cookie("close_subscribe", "true", cookiePath, cookieExpires);
    private Cookie closeCovidCookie = new Cookie("close_covid", "true", cookiePath, cookieExpires);
    private Cookie cookieNoticeAcceptedCookie = new Cookie("cookie_notice_accepted", "true", cookiePath, cookieExpires);

    public Cookie getCloseSubscribeCookie() {
        return closeSubscribeCookie;
    }

    public Cookie getCloseCovidCookie() {
        return closeCovidCookie;
    }

    public Cookie getCookieNoticeAcceptedCookie() {
        return cookieNoticeAcceptedCookie;
    }
}
