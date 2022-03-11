package com.example.restservice.controllers;

import com.example.restservice.models.FeesEnum;
import com.example.restservice.models.RegionEnum;
import com.example.restservice.models.Scores;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScoreController {

    public String calculateRecommendation(Scores idealScore) throws Exception {
        URL url = new URL("http://localhost:8010/calculateRecommendation");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(idealScore);

        OutputStreamWriter request = new OutputStreamWriter(conn.getOutputStream());
        request.write(body);
        request.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output = br.readLine();
        conn.disconnect();

        return output;
    }
}
