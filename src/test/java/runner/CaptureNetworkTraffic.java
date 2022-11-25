package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CaptureNetworkTraffic {

    DevTools devTools;

    public void setUpDevTool(WebDriver driver) {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    }

    public List<String> captureHttpRequests() {
        List<String> postRequest = new ArrayList<>();

        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    if (
                            entry.getRequest().getUrl().contains("/search.html")
                                    && entry.getRequest().getMethod().equalsIgnoreCase("POST")
                    ) {
                        postRequest.add(entry.getRequest().getMethod());
                        postRequest.add(entry.getRequest().getUrl());
                        postRequest.add(entry.getRequest().getPostData().toString());
                        postRequest.add(entry.getRequest().getTrustTokenParams().toString());
                    }
                });

        return postRequest;
    }

    public List<String> captureHttpResponses() {
        List<String> postResponse = new ArrayList<>();

        devTools.addListener(Network.responseReceived(),
                entry -> { if (
                        entry.getResponse().getUrl().contains("/search.html")
                ) {
                    postResponse.add(entry.getResponse().getStatus().toString());
                    postResponse.add(entry.getResponse().getStatusText());
                    postResponse.add(entry.getResponse().getUrl());
                }
                });

        return postResponse;
    }

}
