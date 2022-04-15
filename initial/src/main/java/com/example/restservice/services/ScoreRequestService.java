package com.example.restservice.services;

import com.example.restservice.models.FeesEnum;
import com.example.restservice.models.RegionEnum;
import com.example.restservice.models.Scores;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScoreRequestService {

    public static String calculateRecommendation(Scores idealScore) {
        HttpURLConnection conn;
        String output;
        try {
            URL url = new URL("http://localhost:8010/calculateRecommendation");
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(idealScore);
            OutputStreamWriter request = new OutputStreamWriter(conn.getOutputStream());
            request.write(body);
            request.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            output = br.readLine();
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("Exception reading the response");
            output = "-1";
        }
        return output;
    }
}
