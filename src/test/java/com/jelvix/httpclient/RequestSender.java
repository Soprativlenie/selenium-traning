package com.jelvix.httpclient;/* Created by user on 20.07.20 */

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RequestSender {
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    public boolean isImagesLinkValid(WebElement element) {
        HttpGet request = new HttpGet(element.getAttribute("src"));
        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println(request);
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(response.getStatusLine().getReasonPhrase());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
