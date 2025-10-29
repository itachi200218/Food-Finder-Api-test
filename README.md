# 🍲 Food Finder – REST Assured API Automation with Allure Reports

This repository contains **automated REST API tests** for the **Food Finder User Application**, which delivers intelligent recipe recommendations using **Flask, Gemini AI, Redis, and Fuzzy Matching**.  
The tests are built using **Java + REST Assured + TestNG + Allure Reports**, ensuring API stability, data accuracy, and smart AI responses.

---

## 🌐 Project Overview

The **Food Finder User Application** is a dynamic recipe platform with:
- 🥗 Category sidebar (Veg, Non-Veg, Tiffins, etc.)
- 🧠 AI-powered search (Gemini AI suggestions when DB data not found)
- 🔎 Intelligent search bar with **fuzzy matching** for real-time suggestions
- 💬 Chatbot page integrated with Gemini AI

This automation suite validates all major endpoints, ensuring both the database and Gemini AI work seamlessly together.

---

## 🧠 Tech Stack

| Layer | Technology |
|--------|-------------|
| **Backend** | Python (Flask), MySQL, Redis, Gemini AI |
| **Automation** | REST Assured |
| **Framework** | TestNG |
| **Reporting** | Allure Reports |
| **Language** | Java |
| **Build Tool** | Maven |

---

## ⚙️ Features Tested

| Category | Description |
|-----------|-------------|
| 🍛 **Recipe APIs** | Fetch recipe details, search by category, and name |
| 🧠 **AI Features** | Gemini AI integration for suggestions and chatbot |
| 🔍 **Search Suggestions** | Real-time search responses using fuzzy logic |
| 💬 **Chatbot API** | AI-based conversation endpoints |
| 🧾 **AI Search** | Intelligent recipe generation from Gemini when not found in DB |

---

## 🧪 API Endpoints Covered

| Endpoint | Method | Description | Severity |
|-----------|---------|-------------|-----------|
| `/get-recipe-detail?id=2` | GET | Fetch specific recipe by ID | 🔴 Critical |
| `/get-recipes?category=Non-Veg` | GET | Retrieve Non-Veg recipes | 🟢 Normal |
| `/get-suggestions?query=chi` | GET | Fuzzy suggestion for “chi” | 🟢 Normal |
| `/get-suggestions?query=veg recipe` | GET | Suggest recipes via Gemini if not found | 🟢 Normal |
| `/get-suggestions?query=fish` | GET | Returns fish-related recipes | 🟢 Normal |
| `/chatbot-api` | POST | Chatbot response for query | 🔴 Critical |
| `/ai-search` | POST | AI-based recipe generation | 🔴 Critical |
| `/recipe/Chicken Biryani` | GET | Fetch recipe by name | 🟢 Normal |

---

## 🧱 Project Structure

