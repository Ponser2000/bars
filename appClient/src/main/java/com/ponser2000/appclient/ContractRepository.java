package com.ponser2000.appclient;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContractRepository {

    private static final String URI_CONTRACT = "http://localhost:8080/appserver/all/";

    public List<Contract> getAllContracts() throws Exception {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String json = null;
        List<Contract> result = new ArrayList<>();

        try {
            URL endPoint = new URL(URI_CONTRACT);
            connection = (HttpURLConnection) endPoint.openConnection();
            connection.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonSb.append(line);
            }
            json = jsonSb.toString();

            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();

            ContractJson[] contracts = mapper.readValue(json, ContractJson[].class);
            result = Arrays.stream(contracts).
                    map(c -> new Contract(c.getCreateDate(), c.getRevision(), c.getUpdateDate(), c.isActual())).
                    collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
