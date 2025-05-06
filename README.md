# 🤖 SenTalk – AI Interview Practice App

SenTalk is an AI-powered mock interview tool that helps you practice technical questions and receive natural-sounding answers using Google's Gemini API. Includes voice support and feedback features.

---

## 🔧 Setup Instructions for SenTalk

### ✅ 1. Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven
- IntelliJ IDEA (recommended)

---

### 🔑 2. Get Your Free Gemini API Key

Your app uses **Google Gemini API** to generate interview questions and answers. To use it:

1. Visit **[Google AI Studio](https://aistudio.google.com/app/apikey)**
2. Click **"Create API Key"**
3. Copy the generated key (it starts with `AIza...`)

---

### 📄 3. Configure Your API Key

After cloning the project, you need to set up your own API key:

#### ✅ Option A – Quick Setup

1. Rename the sample config file:

```bash
mv src/main/resources/application-sample.properties src/main/resources/application.properties
```

2. Open `application.properties` and paste your API key:

```properties
gemini.api.key=PASTE_YOUR_API_KEY_HERE
server.port=8080
spring.thymeleaf.cache=false
```

#### ✅ Option B – Create from scratch

If you prefer creating it manually:

1. Inside: `src/main/resources/`, create a file named:

```
application.properties
```

2. Add the following content:

```properties
gemini.api.key=PASTE_YOUR_API_KEY_HERE
server.port=8080
spring.thymeleaf.cache=false
```

---

### 🚀 4. Run the App

From terminal:

```bash
mvn spring-boot:run
```

Or from IntelliJ:  
Right-click on `SenTalk.java` → **Run**

---

### 🌐 5. Access the Web App

Once running, open your browser:

```
http://localhost:8080
```

Start practicing interview questions with AI-powered answers and voice support!

---
