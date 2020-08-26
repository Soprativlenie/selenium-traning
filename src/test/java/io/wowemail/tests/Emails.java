package io.wowemail.tests;/* Created by user on 17.08.20 */


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Emails {
    private String baseFlockUrl;
    private String session;

    public void getMessageFromTheSupportWowEmailMailBox() throws UnirestException {
        String responseFromTheLoginFlock = Unirest.post("https://api.flockmail.com/r/mailSessionInfo")
                .queryString("email", "support@wowemail.io")
                .queryString("password", "WXcTnijDPJ")
                .queryString("installation_id", "Chrome-browser-1597402721991")
                .asString()
                .getBody();
    }

    public String LoginToTheFlockMail() throws UnirestException {
        return Unirest.post("https://api.flockmail.com/r/mailSessionInfo")
                .queryString("email", "support@wowemail.io")
                .queryString("password", "WXcTnijDPJ")
                .queryString("installation_id", "Chrome-browser-1597402721991")
                .asString()
                .getBody();
    }
}
