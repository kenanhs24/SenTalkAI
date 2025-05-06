# 🤖 SenTalk – AI Interview Practice App

**SenTalk** is a voice-enabled AI interview preparation tool powered by **Google Gemini API**. It simulates real interview scenarios by asking technical questions and providing natural, human-like responses.  
🎤 You can interact with it using voice, type your answers, and even get instant feedback!

---

## 🔧 Setup Instructions for SenTalk

### ✅ 1. Prerequisites

To run SenTalk on your local machine, make sure you have:

- ✅ **Java 17** or newer  
- ✅ **Apache Maven**  
- ✅ **IntelliJ IDEA** or any IDE that supports Spring Boot (VS Code, Eclipse, etc.)

---

## 📦 How to Clone the Project

### 🔗 Option 1: GitHub Desktop
1. Visit the repository:  
   👉 [https://github.com/kenanhs24/SenTalk](https://github.com/kenanhs24/SenTalk)
2. Click the green **"Code"** button
3. Choose **"Open with GitHub Desktop"**
4. Select a local folder → Click **"Clone"**

---

### 💻 Option 2: Git (Command Line)
Open your terminal and run:
```bash
git clone https://github.com/kenanhs24/SenTalk.git
cd SenTalk
```

---

## 🔑 2. Get Your Free Gemini API Key

SenTalk uses the **Google Gemini API** to generate intelligent answers.

Here’s how to get your **free API key**:

1. Go to 👉 [Google AI Studio](https://aistudio.google.com/app/apikey)
2. Log in with your Google account
3. Click **“Create API key”**
4. Copy the key (starts with `AIza...`) — you'll use it in the next step

---

## 🛠️ 3. Configure Your API Key

After cloning the project, you need to set up your own API key locally.

### ✅ Option A – Rename sample file
1. In the root of the project, go to:
   ```
   src/main/resources/
   ```
2. Rename:
   ```
   application-sample.properties → application.properties
   ```
3. Open `application.properties` and paste your API key:
   ```properties
   gemini.api.key=YOUR_GEMINI_API_KEY
   server.port=8080
   spring.thymeleaf.cache=false
   ```

### ✅ Option B – Create it manually
1. Create a file at:
   ```
   src/main/resources/application.properties
   ```
2. Paste the following content:
   ```properties
   gemini.api.key=YOUR_GEMINI_API_KEY
   server.port=8080
   spring.thymeleaf.cache=false
   ```

---

## 🚀 4. Run the Application

You can run the app in two ways:

### 💻 From Terminal:
```bash
mvn spring-boot:run
```

### 🧠 From IntelliJ IDEA:
1. Open the project
2. Locate `SenTalk.java`
3. Right-click → **Run 'SenTalk.main()'**

---

## 🌐 5. Access the Web App

After running the application, go to your browser and open:

```
http://localhost:8080
```

You’ll see the SenTalk interface with:
- 🎤 Voice-powered question generation
- ✍️ Answer editor
- 🧠 Smart auto-answer
- 📋 Interview history tracking

---

## 🤝 Contribute or Collaborate

If you'd like to improve the app, suggest features, or contribute code:
- Fork the repo
- Make changes in a new branch
- Submit a pull request

---

## 🛡️ Security Note

Your **Gemini API key is private**.  
This project does **NOT** expose it publicly thanks to the `.gitignore`.
