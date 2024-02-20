package com.luizhf42.githubusersearch;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Fetcher {
    private final URI baseUri;
    HttpClient httpClient = HttpClient.newHttpClient();

    public Fetcher(String baseUri) throws URISyntaxException {
        this.baseUri = new URI(baseUri);
    }

    public void getUser(String username) throws URISyntaxException, IOException, InterruptedException {
        URI fullUri = baseUri.resolve(new URI(username));
        HttpRequest getRequest = HttpRequest.newBuilder().uri(fullUri).build();
        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
