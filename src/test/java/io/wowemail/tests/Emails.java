package io.wowemail.tests;/* Created by user on 17.08.20 */

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;


public class Emails {
    private final String url = "https://mailinator.com/api/v2/domains/public/inboxes/";
    private final String authorizationToken = "f836444904244057ab4d37030047f038";
    private final String sender = "wowemail.io";
    private final String fromFull = "support@wowemail.io";
    private final String theWelcomeMessageSubject = "Welcome to WowEmail!";
    private final String theOrderMessageSubject = "Great news! We’ve got your order";


    public boolean isWelcomeLetterReceives(String inbox) throws UnirestException {
        String responseWithLetterList = Unirest.get(url + inbox)
                .header("Authorization", authorizationToken)
                .asString()
                .getBody();

        List<String> subjectsList = JsonPath.read(responseWithLetterList, ".msgs[*].subject");
        for (String subject : subjectsList) {
            if (subject.equals(theWelcomeMessageSubject)) {
                return true;
            }
        }
        return false;
    }
}
