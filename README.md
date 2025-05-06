
When they run the app, it will fail unless they:

Create their own application.properties file.
Sign up for their own Gemini API key at:
https://aistudio.google.com/app/apikey
💡 How to help users run your project easily:
Add a sample file and instructions:

✅ In GitHub, include this:
# application-sample.properties
gemini.api.key=REPLACE_WITH_YOUR_API_KEY
server.port=8080
spring.thymeleaf.cache=false
✅ In your README.md:
## 🔑 Setup Your Gemini API Key

1. Go to [Google AI Studio](https://aistudio.google.com/app/apikey)
2. Copy your API key
3. Rename `application-sample.properties` to `application.properties`
4. Paste your key:
gemini.api.key=your_key_here


✅ Now run the app using IntelliJ or `mvn spring-boot:run`
