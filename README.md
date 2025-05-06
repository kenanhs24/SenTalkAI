🤖 SenTalk – AI Interview Practice App

SenTalk is a voice-enabled AI interview preparation tool powered by Google Gemini API. It simulates real interview scenarios by asking technical questions and providing natural, human-like responses.
🎤 You can interact with it using voice, type your answers, and even get instant feedback!

🔧 Setup Instructions for SenTalk

✅ 1. Prerequisites
To run SenTalk on your local machine, make sure you have:

✅ Java 17 or newer
✅ Apache Maven
✅ IntelliJ IDEA or any IDE that supports Spring Boot (VS Code, Eclipse, etc.)
📦 How to Clone the Project

🔗 Option 1: GitHub Desktop
Visit the repository:
👉 https://github.com/kenanhs24/SenTalk
Click the green "Code" button
Choose "Open with GitHub Desktop"
Select a local folder → Click "Clone"
💻 Option 2: Git (Command Line)
Open your terminal and run:

git clone https://github.com/kenanhs24/SenTalk.git
cd SenTalk
🔑 2. Get Your Free Gemini API Key

SenTalk uses the Google Gemini API to generate intelligent answers.

Here’s how to get your free API key:

Go to 👉 Google AI Studio
Log in with your Google account
Click “Create API key”
Copy the key (starts with AIza...) — you'll use it in the next step
🛠️ 3. Configure Your API Key

After cloning the project, you need to set up your own API key locally.

✅ Option A – Rename sample file
In the root of the project, go to:
src/main/resources/
Rename:
application-sample.properties → application.properties
Open application.properties and paste your API key:
gemini.api.key=YOUR_GEMINI_API_KEY
server.port=8080
spring.thymeleaf.cache=false
✅ Option B – Create it manually
Create a file at:
src/main/resources/application.properties
Paste the following content:
gemini.api.key=YOUR_GEMINI_API_KEY
server.port=8080
spring.thymeleaf.cache=false
🚀 4. Run the Application

You can run the app in two ways:

💻 From Terminal:
mvn spring-boot:run
🧠 From IntelliJ IDEA:
Open the project
Locate SenTalk.java
Right-click → Run 'SenTalk.main()'
🌐 5. Access the Web App

After running the application, go to your browser and open:

http://localhost:8080
You’ll see the SenTalk interface with:

🎤 Voice-powered question generation
✍️ Answer editor
🧠 Smart auto-answer
📋 Interview history tracking
🤝 Contribute or Collaborate

If you'd like to improve the app, suggest features, or contribute code:

Fork the repo
Make changes in a new branch
Submit a pull request
🛡️ Security Note

Your Gemini API key is private.
This project does NOT expose it publicly thanks to the .gitignore.

