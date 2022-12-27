package network;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CaptureNetworkTraffic {

    DevTools devTools;

    public CaptureNetworkTraffic setUpDevTool(WebDriver driver) {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        return this;
    }

    public List<String> captureHttpRequests(String endPoint, String method) {
        List<String> methodRequest = new ArrayList<>();

        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    if (
                            entry.getRequest().getUrl().contains(endPoint)
                                    && entry.getRequest().getMethod().equalsIgnoreCase(method)
                    ) {
                        methodRequest.add(entry.getRequest().getMethod());
                        methodRequest.add(entry.getRequest().getUrl());
                        methodRequest.add(entry.getRequest().getPostData().toString());
                        methodRequest.add(entry.getRequest().getTrustTokenParams().toString());
                    }
                });

        return methodRequest;
    }

    public List<String> captureHttpRequestsExcluding(String excludingMethod) {
        List<String> postRequest = new ArrayList<>();

        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    if (!entry.getRequest().getMethod().equalsIgnoreCase(excludingMethod)) {
                        postRequest.add(entry.getRequest().getMethod());
                        postRequest.add(entry.getRequest().getUrl());
                        postRequest.add(entry.getRequest().getPostData().toString());
                        postRequest.add(entry.getRequest().getTrustTokenParams().toString());
                    }
                });

        return postRequest;
    }

    public List<String> captureHttpResponses(String endPoint) {
        List<String> postResponse = new ArrayList<>();

        devTools.addListener(Network.responseReceived(),
                entry -> {
                    if (
                            entry.getResponse().getUrl().contains(endPoint)
                    ) {
                        postResponse.add(entry.getResponse().getStatus().toString());
                        postResponse.add(entry.getResponse().getStatusText());
                        postResponse.add(entry.getResponse().getUrl());
                        postResponse.add(entry.getResponse().getResponseTime().toString());
                    }
                });

        return postResponse;
    }
}