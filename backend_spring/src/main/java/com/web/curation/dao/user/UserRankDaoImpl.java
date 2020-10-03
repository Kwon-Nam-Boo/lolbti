package com.web.curation.dao.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Repository;

@Repository
public class UserRankDaoImpl implements UserRankDao {
    static String root = "http://localhost:8081";
    // static String root = "http://j3a109.p.ssafy.io:8081";

    @Override
    public String userRank(String summonerName) throws IOException {
        String request = "/userGameData/userinfo/";
        String requestUrl = root + request + summonerName;
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String returnLine;
        StringBuffer result = new StringBuffer();
        while ((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n");
        }
        conn.disconnect();

        return result.toString();
    }
    
    
}
