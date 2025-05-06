package com.api.testing.testYourself.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    // ✅ Use the correct endpoint
    private final String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=";

    public String getInterviewQuestion(String role) {
        String prompt = "Act as an interviewer. Ask me 1 technical interview question for a " + role + " position.";
        return sendToGemini(prompt);
    }

    public String getFeedback(String question, String answer) {
        String prompt = "Here is a candidate's answer to a job interview question.\n" +
                "Question: " + question + "\n" +
                "Answer: " + answer + "\n" +
                "Please provide constructive feedback for the answer.";
        return sendToGemini(prompt);
    }

    public String sendToGemini(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = URL + apiKey;

        Map<String, Object> messagePart = new HashMap<>();
        messagePart.put("text", prompt);

        Map<String, Object> content = new HashMap<>();
        content.put("parts", List.of(messagePart));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("contents", List.of(content));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            Map response = restTemplate.postForObject(endpoint, entity, Map.class);
            List<Map> candidates = (List<Map>) response.get("candidates");
            if (candidates != null && !candidates.isEmpty()) {
                Map contentMap = (Map) candidates.get(0).get("content");
                List<Map> parts = (List<Map>) contentMap.get("parts");
                return parts.get(0).get("text").toString();
            }
            return "No response from Gemini.";
        } catch (Exception e) {
            return "Error calling Gemini API: " + e.getMessage();
        }
    }
    public String getAnswerToQuestion(String question) {
        String prompt = "Answer this interview question:\n" + question;
        return sendToGemini(prompt);
    }

}
