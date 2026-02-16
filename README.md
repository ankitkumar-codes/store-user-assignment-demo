# Store User Assignment Demo

A lightweight full-stack demo application that automatically assigns users to a serviceable store based on **pincode**, with **map-based location selection** for precise user positioning.

This project demonstrates clean backend logic, REST APIs, database integration, and a simple frontend with embedded maps.

---

## 📌 Problem Statement

- Admin can create stores with a serviceable **pincode**
- Users register by entering their **pincode**
- If a user’s pincode matches a store’s pincode, the user is automatically assigned to that store
- User selects their **exact location on a map** during registration
- Map automatically centers to the entered pincode area for better UX

---

## 🚀 Features

- Create store with pincode and coordinates
- User registration with auto store assignment
- Pincode-based serviceability logic
- Embedded map using OpenStreetMap (Leaflet)
- Auto-center map when pincode is entered
- Single marker handling (no duplicate markers)
- Clean REST API design
- MySQL database integration

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- REST APIs

### Frontend
- HTML
- CSS
- JavaScript
- Leaflet.js (OpenStreetMap)

---

## 📂 Project Structure

```
store-user-assignment-demo
├── backend
│   ├── src
│   ├── pom.xml
│   └── mvnw
├── frontend
│   ├── index.html
│   ├── style.css
│   └── script.js
├── .gitignore
└── README.md
```

---

## ⚙️ How to Run the Project

### 1️⃣ Backend Setup

1. Create MySQL database:
   ```sql
   CREATE DATABASE store_service_demo;
   ```

2. Update database credentials in:
   ```
   backend/src/main/resources/application.properties
   ```

3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

Backend runs on:
```
http://localhost:8080
```

---

### 2️⃣ Frontend Setup

1. Go to `frontend` folder
2. Open `index.html` directly in browser
3. No server required for frontend

---

## 🔗 API Endpoints

### Create Store
```
POST /stores
```

### Register User
```
POST /users/register
```

---

## 🧪 Demo Flow

1. Admin creates a store
2. User registers with pincode
3. Map auto-centers
4. User selects exact location
5. Store is assigned automatically

---

## 👤 Author

**Ankit Kumar**
