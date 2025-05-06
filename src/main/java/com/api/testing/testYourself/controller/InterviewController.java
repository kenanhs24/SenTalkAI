package com.api.testing.testYourself.controller;

import com.api.testing.testYourself.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class InterviewController {

    @Autowired
    private GeminiService geminiService;

    // Stores the current question for feedback context
    private String currentQuestion;

    private String currentRole;

    // 🚀 Home page
    @GetMapping("/")
    public String showForm() {
        return "interview";
    }
    @GetMapping("/history")
    public String showHistory(Model model) {
        model.addAttribute("history", historyList);
        return "history"; // history.html
    }


    // 🎯 Get interview question based on role
    @PostMapping("/get-question")
    public String getQuestion(@RequestParam String role, Model model) {
        this.currentRole = role;


        // Generate the question using Gemini service
        currentQuestion = geminiService.getInterviewQuestion(role);

        // Safety check in case Gemini returns null or empty
        if (currentQuestion == null || currentQuestion.trim().isEmpty()) {
            currentQuestion = "⚠️ No question generated. Please try again.";
        }

        // Send question and role to the view
        model.addAttribute("question", currentQuestion);
        model.addAttribute("role", role);

        // Record in history with placeholder for answer
        String formatted = """
        🟨 Question:
        %s

        🟩 Answer:
        [Waiting for user or AI response...]
        ------------------------------
        """.formatted(currentQuestion);
        historyList.add(formatted);

        return "interview";
    }





    // 📩 Submit answer and get AI feedback
    @PostMapping("/get-feedback")
    public String getFeedback(@RequestParam String answer, Model model) {
        try {
            System.out.println("Answer received: " + answer);
            String feedback = geminiService.getFeedback(currentQuestion, answer);
            System.out.println("Feedback returned: " + feedback);
            model.addAttribute("question", currentQuestion);
            model.addAttribute("answer", answer);
            model.addAttribute("feedback", feedback);
        } catch (Exception e) {
            System.out.println("Error getting feedback: " + e.getMessage());
            model.addAttribute("error", "Failed to get feedback. Please try again.");
        }
        return "interview";
    }

    // 🤖 Generate AI Answer from Question + Role
    @PostMapping("/generate-answer")
    @ResponseBody
    public String generateAIAnswer(@RequestBody Map<String, String> body) {
        try {
            String rawPrompt = body.get("prompt");

            // Wrap user prompt with human-style answer request
            String modifiedPrompt = """
            You're a senior %s being interviewed. 
            Answer the following question naturally, in 2–3 full sentences. 
            Avoid using bullets, headings, or phrases like "AI Answer" or "Summary". 
            Speak like a confident human interviewee:
            
            %s
        """.formatted(currentRole != null ? currentRole : "SDET", rawPrompt);

            return geminiService.sendToGemini(modifiedPrompt);
        } catch (Exception e) {
            return "Error generating AI answer: " + e.getMessage();
        }
    }

    @PostMapping("/ask")
    public String askCustomQuestion(@RequestParam String userQuestion, Model model) {
        try {
            String aiAnswer = geminiService.sendToGemini(userQuestion);
            model.addAttribute("customQuestion", userQuestion);
            model.addAttribute("aiAnswer", aiAnswer);
        } catch (Exception e) {
            model.addAttribute("error", "Error getting AI answer: " + e.getMessage());
        }
        return "interview";
    }
    @PostMapping("/voice-question")
    @ResponseBody
    public String handleVoiceQuestion(@RequestBody Map<String, String> body) {
        String question = body.get("question");
        return geminiService.getAnswerToQuestion(question);
    }
    @GetMapping("/next-question")
    public String nextQuestion(Model model) {
        if (currentRole == null) {
            currentRole = "QA Engineer"; // fallback
        }

        currentQuestion = geminiService.getInterviewQuestion(currentRole);
        model.addAttribute("question", currentQuestion);
        model.addAttribute("role", currentRole);

        // Add to history
        String formatted = """
        🟨 Question:
        %s

        🟩 Answer:
        [Waiting for user or AI response...]
        ------------------------------
        """.formatted(currentQuestion);
        historyList.add(formatted);

        return "interview";
    }

    @GetMapping("/single-screen")
    public String showSingleScreen() {
        return "interview"; // or the correct Thymeleaf template name if different
    }
    @PostMapping("/save-transcript")
    @ResponseBody
    public ResponseEntity<String> saveTranscript(@RequestBody Map<String, String> payload) {
        String question = payload.get("question");
        String answer = payload.get("answer");

        String formatted = """
        🟨 Question:
        %s

        🟩 Answer:
        %s
        ------------------------------
        """.formatted(question, answer);

        historyList.add(formatted);
        return ResponseEntity.ok("Saved to history");
    }



    private final List<String> historyList = new ArrayList<>();







}
