package com.web.curation.dao.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RecommendDaoImpl implements RecommendDao {
//    static String root = "http://localhost:8081";
    static String root = "http://j3a109.p.ssafy.io:8081";

    @Override
    public boolean renewalPoint(String summonerName) throws IOException {
        String request = "/userGameData/update/mastery/";
        String requestUrl = root + request;
        // String summon= URLEncoder.encode(summonerName, "UTF-8");
        // URL url = new URL(requestUrl+summon);
        URL url = new URL(requestUrl+summonerName);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String returnLine;
        StringBuffer result = new StringBuffer();
        while ((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n");
        }
        conn.disconnect();
//        System.out.println(result.substring(11,result.length()-1));
        if (result.substring(11,result.length()-2).toString().equals("true"))
            return true;

        return false;
    }

    @Override
    public String recommendPoint(String summonerName) throws IOException {
        String request = "/userGameData/recommend/mastery/";
        String requestUrl = root + request;
        // String summon= URLEncoder.encode(summonerName, "UTF-8");
        // URL url = new URL(requestUrl+summon);
        URL url = new URL(requestUrl+summonerName);

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
    
    @Override
    public String getChampByMbti(String mbti) throws IOException {
        String request = "/userGameData/recommend/mbtitomastery/";
        String requestUrl = root + request;
        // String summon= URLEncoder.encode(summonerName, "UTF-8");
        // URL url = new URL(requestUrl+summon);
        URL url = new URL(requestUrl+mbti);

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
    
    @Override
    public String test() throws IOException {
        String request = "/userGameData/test/";
        String requestUrl = root + request;
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

    @Override
    public String recommendItem(String myChamp, String opponentChamp) throws IOException {
        String request = "/userGameData/recommend/item/" + myChamp + "/" + opponentChamp;
        String requestUrl = root + request;
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
