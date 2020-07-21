package com.jelvix.httpclient;/* Created by user on 20.07.20 */

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class RequestSender {


    public boolean isImagesLinkValid(List<WebElement> elements) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        int testCounter = 1;
        for (WebElement imgElement : elements) {
            try {
                HttpGet requestByLink = new HttpGet(imgElement.getAttribute("src"));
                CloseableHttpResponse response = httpClient.execute(requestByLink);
                try {
                    System.out.println(testCounter + " " + requestByLink + " " + response.getStatusLine().getStatusCode());
                    testCounter++;// Debug print
                    if (response.getStatusLine().getStatusCode() != 200) {
                        System.out.println(response.getStatusLine().getStatusCode());
                        System.out.println(requestByLink);
                        return false;
                    }
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        httpClient.close();
        return true;
    }
}
