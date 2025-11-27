# LoginApp

Simple Full-Stack Login Application built with **Spring Boot** (backend) and static **HTML/CSS/JS** (frontend).  
Features: user registration, password hashing (BCrypt), login with session, and a protected home page.

---

## 🚀 Features
- Register with email and password (passwords stored hashed with `BCrypt`)
- Login with session
- Protected home endpoint (`/page/home`)
- Static frontend served from `src/main/resources/static`
- Simple UI with show/hide password icons

---

## 🧰 Tech Stack
- Java 17+  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- BCrypt Password Encoder  
- HTML / CSS / JavaScript  
- Maven  

---

## 🔧 Prerequisites
Install the following:
- Java JDK 11/17+
- Maven
- MySQL (running locally)

---

## 🛠 Setup & Run


### 1️⃣ Clone the repository
```bash
git clone https://github.com/EswarLeon/LoginApp.git
cd LoginApp


2️⃣ Create the database
Open MySQL and run:

sql
Copy code
CREATE DATABASE userpage;
(Default Spring Boot config uses:
spring.datasource.url=jdbc:mysql://localhost:3306/userpage)


3️⃣ Configure your DB credentials
Edit:

css
Copy code
src/main/resources/application.properties
Update this if needed:

properties
Copy code
spring.datasource.username=root
spring.datasource.password=root


4️⃣ Build & run the project
Option 1: Using Maven
bash
Copy code
mvn clean package
mvn spring-boot:run
Option 2: Run JAR
bash
Copy code


🌐 Open the Application
Register:
http://localhost:8080/register.html

Login:
http://localhost:8080/login.html


📦 API Endpoints
Register
POST /page/register
Body:

json
Copy code
{
  "email": "example@mail.com",
  "password": "12345",
  "confirmedpassword": "12345"
}
Login
POST /page/login
Body:

json
Copy code
{
  "email": "example@mail.com",
  "password": "12345"
}
Protected Home
GET /page/home
Requires login session.

💡 Notes & Tips
Passwords are always stored as BCrypt hashes

Login sessions stored using HttpSession

If static files do not update → clear browser cache

Restarting server resets sessions


bash
Copy code
docs/images/
Example usage in README:

markdown
Copy code
![Login Page](docs/images/login.png)


🧪 Testing with curl
Register
bash
Copy code
curl -X POST http://localhost:8080/page/register \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"abc123","confirmedpassword":"abc123"}'
Login (save session cookies)
bash
Copy code
curl -i -c cookies.txt -X POST http://localhost:8080/page/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","password":"abc123"}'
Access protected route
bash
Copy code
curl -b cookies.txt http://localhost:8080/page/home


✍️ Contributing
Fork the repo

Create a new branch

bash
Copy code
git checkout -b feat/your-feature
Commit and push

Open a Pull Request

📜 License
You can add a license (MIT recommended).
Create a file named:

nginx
Copy code
LICENSE


📧 Contact
Eswar D
linkedin.com/in/eswar-d-2355b8244

yaml
Copy code

---

# ✅ Next Step for You

Now just do:

```powershell
notepad README.md
Paste the entire content above → Save → then:

powershell
Copy code
git add README.md
git commit -m "Add README.md"
git push
