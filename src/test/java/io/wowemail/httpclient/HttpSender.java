package io.wowemail.httpclient;/* Created by user on 14.08.20 */

import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class HttpSender {
    private final String email = "support@wowemail.io";
    private final String password = "WXcTnijDPJ";
    private final String installationId = "Chrome-browser-1597402721991";
    private final String loginLink = "https://api.flockmail.com/r/mailSessionInfo";


    private Map<String, Object> getLoginBody() {
        Map<String, Object> loginBody = new HashMap<>();
        loginBody.put("email", email);
        loginBody.put("password", password);
        loginBody.put("installation_id", installationId);
        return loginBody;
    }

    private String getBaseUrl(String json) {
        return JsonPath.read(json, "$.base_url");
    }

    private String getSession(String json) {
        return JsonPath.read(json, "$.session");
    }

    private String loginToMailBox() throws UnirestException {
        return Unirest.post(loginLink)
                .fields(getLoginBody())
                .asString()
                .getBody();
    }

    public String getDataOfTheFirstMessage() throws UnirestException {
        String responseBody = loginToMailBox();
        String baseUrl = getBaseUrl(responseBody);
        String session = getSession(responseBody);
        String listOfMessagesResponse = Unirest.get(baseUrl + "threads?folder_id=8&folder_type=other&limit=100")
                .header("x-session-token", session)
                .asString()
                .getBody();
        return JsonPath.read(listOfMessagesResponse, "$.threads[0].snippet");
    }
}
