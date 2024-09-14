package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    final static Gson gson = new Gson();
    static final String url1 = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team1=%s";
    static final String url2 = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team2=%s";
    static final String url3 = "https://jsonmock.hackerrank.com/api/football_matches?year=%d&team1goals=%d&team2goals=%d";
    static final String url4 = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";
    static final String url5 = "https://jsonmock.hackerrank.com/api/asteroids/search?discovery_date=%s&pha=%s";

    static JsonObject get(String endpoint) throws IOException {
        final URL url = new URL(endpoint);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Content-Type", "application/json");

        final int status = con.getResponseCode();
        if (status < 200 || status >= 300) {
            throw new IOException("Error in reading data with status:" + status);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response;
        StringBuilder sb = new StringBuilder();
        while ((response = br.readLine()) != null) {
            sb.append(response);
        }

        br.close();
        con.disconnect();
        return gson.fromJson(sb.toString(), JsonObject.class);
    }

    static void callApi(String url, ResponseApi response, Type typeOfT) {
        try {
            JsonObject json = get(url+"&page="+response.getPage());
            int totalPages = json.get("total_pages").getAsInt();
            int total = json.get("total").getAsInt();
            int per_page = json.get("per_page").getAsInt();
            response.setPer_page(per_page);
            response.setTotal_pages(totalPages);
            response.setTotal(response.getTotal() + total);
            JsonArray data = json.getAsJsonArray("data");
            for (JsonElement element : data) {
                if (url.contains("/movies/")) {
                    response.getPriorityQueue().add(gson.fromJson(element, typeOfT));
                } else if (url.contains("/football_matches")) {
                    response.getData().add(gson.fromJson(element, typeOfT));
                } else if (url.contains("/asteroids/")) {
                    response.getAsteroids().add(gson.fromJson(element, typeOfT));
                }
            }
            if (response.getPage() < totalPages) {
                response.setPage(json.get("page").getAsInt() + 1);
                callApi(url, response, typeOfT);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        /*football_matches*/
        System.out.println("football_matches");
        ResponseApi response = new ResponseApi();
        long total = 0;
        String url = String.format(url1, 2011, URLEncoder.encode("Barcelona", StandardCharsets.UTF_8));
        callApi(url, response, FootballMatches.class);
        total += response.getData().stream().mapToLong(i -> Long.parseLong(i.getTeam1goals())).sum();
        System.out.println(response);
        response = new ResponseApi();
        url = String.format(url2, 2011, URLEncoder.encode("Barcelona", StandardCharsets.UTF_8));
        callApi(url, response, FootballMatches.class);
        total += response.getData().stream().mapToLong(i -> Long.parseLong(i.getTeam2goals())).sum();
        System.out.println(response);
        System.out.println(total);

        /*football_matches drawMatches*/
        System.out.println("football_matches drawMatches");
        response = new ResponseApi();
        int goal = 11;
        while(goal-- >0) {
            url = String.format(url3, 2011, goal, goal);
            callApi(url, response, FootballMatches.class);
        }
        total = response.getData().size();
        System.out.println(response);
        System.out.println(total);

        /*movies*/
        System.out.println("movies");
        response = new ResponseApi();
        url = String.format(url4, URLEncoder.encode("Waterworld", StandardCharsets.UTF_8));
        callApi(url, response, Movies.class);
        System.out.println(response);
        List<String> titles = new ArrayList<>();
        response.getPriorityQueue().stream().map(i-> {
            String title = i.getTitle();
            titles.add(title);
            return title;
        }).forEach(System.out::println);
        System.out.println("Done");
        Collections.sort(titles);
        titles.forEach(System.out::println);


        /*Asterois*/
        System.out.println("Asteroids");
        response = new ResponseApi();
        url = String.format(url5, URLEncoder.encode("2010", StandardCharsets.UTF_8), URLEncoder.encode("Y", StandardCharsets.UTF_8));
        callApi(url, response, Asteroid.class);
        System.out.println(response);
        List<String> result = response.getAsteroids().stream().sorted().map(i-> i.toString()).collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("Done");
    }
}