<div align="center">

# 🚗 GOMON — Ride for Everyone

### Smart Ride-Sharing & Transport Management System

A modern **desktop-based ride-sharing application** built with **Java 17, Java Swing, Maven, and MySQL**, providing dedicated experiences for passengers, drivers, and administrators.

<p>
  <a href="https://github.com/junayeembd/gomon-ride-for-everyone">
    <img src="https://img.shields.io/badge/GitHub-Repository-181717?style=for-the-badge&logo=github" alt="GitHub Repository">
  </a>
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Java%20Swing-Desktop%20Application-1F6FEB?style=for-the-badge" alt="Java Swing">
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
</p>

<p>
  <img src="https://img.shields.io/badge/FlatLaf-3.6-4B6CB7?style=flat-square" alt="FlatLaf">
  <img src="https://img.shields.io/badge/JDBC-Database%20Access-2E7D32?style=flat-square" alt="JDBC">
  <img src="https://img.shields.io/badge/BCrypt-Password%20Hashing-8E24AA?style=flat-square" alt="BCrypt">
  <img src="https://img.shields.io/badge/Status-Active%20Development-F39C12?style=flat-square" alt="Active Development">
</p>

</div>

---

## 🌟 About GOMON

**GOMON (Ride for Everyone)** is a modular desktop ride-sharing and transport management system developed to bring common ride-management activities into a single application.

The project provides separate user experiences for:

- 👤 **Passengers** — book rides, view recent rides, manage wallet information, and access safety tools.
- 🚘 **Drivers** — manage ride requests, active rides, earnings, ratings, availability, and safety features.
- 🧑‍💼 **Administrators** — monitor and manage operational information through a dedicated administration interface.

The application is designed with a layered Java architecture, reusable Swing components, JDBC-based database access, authentication services, session management, and security utilities.

> 🎓 **Project Type:** Academic / educational software project  
> 🧩 **Development Status:** Active development

---

## 💡 Why GOMON?

GOMON is designed around a simple idea:

> **One platform. Multiple roles. A complete ride-management experience.**

Instead of treating booking, driver operations, account management, safety, and monitoring as separate systems, GOMON organizes them into role-specific dashboards with a consistent desktop interface.

---

## 🎯 Project Objectives

| Objective | Description |
|---|---|
| 🚗 Centralized Ride Management | Organize ride booking and ride-related workflows in one system |
| 👤 Better Passenger Experience | Provide simple booking, ride history, wallet and safety interfaces |
| 🚘 Better Driver Experience | Give drivers dedicated tools for requests, rides, earnings and ratings |
| 🔐 Secure Accounts | Use password hashing, OTP verification and validation |
| 🧑‍💼 Administrative Control | Provide structured monitoring and management interfaces |
| 🎨 Consistent UI | Use reusable Swing components for a unified application design |
| 🧱 Maintainable Architecture | Separate UI, service, DAO, model, session and utility responsibilities |

---

# 🧭 Application Overview

```text
                         ┌───────────────────────┐
                         │       GOMON App       │
                         └───────────┬───────────┘
                                     │
             ┌───────────────────────┼───────────────────────┐
             │                       │                       │
             ▼                       ▼                       ▼
      👤 PASSENGER               🚘 DRIVER              🧑‍💼 ADMIN
             │                       │                       │
             ▼                       ▼                       ▼
       User Dashboard         Driver Dashboard        Admin Dashboard
             │                       │                       │
       ┌─────┼─────┐           ┌─────┼─────┐           ┌────┼────┐
       │     │     │           │     │     │           │    │    │
     Booking Wallet Safety    Requests Earnings Safety  Users Drivers Reports
             │                       │                       │
             └───────────────────────┼───────────────────────┘
                                     ▼
                           Authentication / Services
                                     │
                                     ▼
                               DAO + JDBC
                                     │
                                     ▼
                              🗄️ MySQL Database
```

---

# ✨ Features

## 👤 Passenger Features

### 🔐 Account & Authentication
- Passenger registration
- Login using username or email
- Password reset
- OTP verification
- Account validation
- Session-based login state
- Logout

### 🚕 Ride Booking
- Pickup location
- Destination
- Vehicle type selection
- Estimated fare
- Estimated travel time
- **Ride Now**
- **Schedule Ride**
- Book Ride action

### 📊 Passenger Dashboard
- Total rides
- Total spending
- Rating / reward information
- Wallet balance
- Quick actions
- Recent rides
- Safety Center
- Live map area

### 💳 Wallet
- Wallet balance display
- Add Money action
- Dedicated wallet interface

### 🕘 Recent Rides
Recent ride entries can display:
- Route
- Date/time
- Ride status
- Fare

Example statuses:
- ✅ Completed
- 🔵 Ongoing
- ❌ Cancelled
- 🟠 Scheduled

### 🛡️ Passenger Safety
- Emergency assistance
- Live trip sharing
- Emergency contact concept
- Trusted contact support
- Night safety

---

# 🚘 Driver Features

## 📊 Driver Dashboard

The driver dashboard is designed as a dedicated operations workspace.

### Driver Overview
- Driver greeting
- Profile avatar
- Notification indicator
- Rating
- Verified Driver status
- Online status
- Live date and time

### 📈 Driver Statistics
The dashboard includes cards for:
- Today's Ride
- Today's Earnings
- Online Time
- Rating

### 📍 Live Route Area
A dedicated route/map section is included for ride navigation and route presentation.

### 🚨 Ride Request
The driver dashboard provides a New Ride Request interface containing:
- Passenger name
- Passenger rating
- Passenger type
- Pickup
- Drop
- Fare
- Vehicle / ride type
- ETA
- Accept action
- View action

### ⚡ Quick Actions

| Action | Purpose |
|---|---|
| 🚨 Emergency | Emergency assistance |
| 📞 Call Rider | Passenger communication |
| 💬 Chat | Ride-related messaging |
| 🧭 Navigate | Navigation access |
| 🚗 Vehicle | Vehicle information |
| 🎧 Support | Help and support |

### 🛡️ Driver Safety
- Emergency assistance
- Share Trip
- Trusted Contact
- Night Safety

### 📋 Driver Navigation
The driver sidebar provides:

```text
Dashboard
Ride Requests
Active Ride
Ride History
Earnings
Ratings & Reviews
Help & Support
Settings
Logout
```

Additional sidebar elements:
- 🟢 Go Online
- 🎁 Refer & Earn

---

# 🧑‍💼 Administrator Features

The admin side is structured for operational monitoring and management.

### Admin Dashboard Areas
- Admin header
- Admin sidebar
- Statistics
- Quick actions
- User registration views
- Driver verification
- Safety area
- Users vs Drivers comparison
- Operational/analytics-oriented panels

### Administrative Responsibilities
The project structure is designed to support areas such as:
- User management
- Driver management
- Driver verification
- System statistics
- Operational monitoring
- Support and safety workflows

---

# 🔐 Authentication & Security

Security is handled through dedicated service and utility classes rather than placing all logic inside the UI.

### Authentication Flow

```text
User / Driver
     │
     ▼
Registration
     │
     ▼
Account Validation
     │
     ▼
OTP Verification
     │
     ▼
Password Hashing
     │
     ▼
Database
     │
     ▼
Login
     │
     ▼
SessionManager
     │
     ▼
Role-Based Dashboard
```

### Security Components

- 🔒 BCrypt password hashing
- 📧 OTP generation
- ✉️ Email OTP delivery
- ✅ Username uniqueness validation
- ✅ Email uniqueness validation
- ✅ Phone uniqueness validation
- 👤 Session management
- 🚪 Logout / session clearing

The authentication service currently coordinates account checks, OTP verification, login validation, password reset, user registration, and driver registration.

---

# 🏗️ Architecture

GOMON follows a modular architecture that separates responsibilities across multiple layers.

```text
┌──────────────────────────────────────────────────┐
│                    UI Layer                       │
│ Auth • Passenger • Driver • Admin • Components   │
└────────────────────────┬─────────────────────────┘
                         │
                         ▼
┌──────────────────────────────────────────────────┐
│                 Service Layer                    │
│ Authentication • OTP • Business Services         │
└────────────────────────┬─────────────────────────┘
                         │
                         ▼
┌──────────────────────────────────────────────────┐
│                    DAO Layer                     │
│                 AccountDAO / JDBC                │
└────────────────────────┬─────────────────────────┘
                         │
                         ▼
┌──────────────────────────────────────────────────┐
│                 Database Layer                   │
│                  MySQL Database                  │
└──────────────────────────────────────────────────┘
```

### Supporting Layers

```text
Model
Session
Config
Utils
Reusable UI Components
```

---

# 📦 Project Structure

```text
Gomon_Ride_for_Everyone/
│
├── .gitignore
├── pom.xml
│
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── gomon/
        │           │
        │           ├── app/
        │           │   └── Main.java
        │           │
        │           ├── config/
        │           │   ├── AppConfig.java
        │           │   └── ThemeConfig.java
        │           │
        │           ├── controller/
        │           │
        │           ├── dao/
        │           │   └── AccountDAO.java
        │           │
        │           ├── database/
        │           │   ├── DatabaseConnection.java
        │           │   └── TestConnection.java
        │           │
        │           ├── model/
        │           │   ├── User.java
        │           │   └── Driver.java
        │           │
        │           ├── service/
        │           │   └── AuthenticationService.java
        │           │
        │           ├── session/
        │           │   └── SessionManager.java
        │           │
        │           ├── utils/
        │           │   ├── ColorPalette.java
        │           │   ├── Constants.java
        │           │   ├── EmailSender.java
        │           │   ├── FontManager.java
        │           │   ├── ImageLoader.java
        │           │   ├── OTPGenerator.java
        │           │   ├── PasswordHasher.java
        │           │   └── Validator.java
        │           │
        │           └── ui/
        │               ├── auth/
        │               ├── components/
        │               ├── user/
        │               ├── driver/
        │               └── admin/
        │
        └── resources/
            └── images/
```

---

# 🧩 Package Responsibilities

| Package | Responsibility |
|---|---|
| `app` | Application entry point |
| `config` | Application and theme configuration |
| `controller` | Controller layer / application flow extension |
| `dao` | Database access |
| `database` | MySQL/JDBC connection utilities |
| `model` | Domain objects |
| `service` | Authentication and service logic |
| `session` | Current authenticated user/session |
| `utils` | OTP, email, hashing, validation, fonts, images and constants |
| `ui.auth` | Login, registration, OTP and password reset |
| `ui.user` | Passenger interface |
| `ui.driver` | Driver interface |
| `ui.admin` | Administrator interface |
| `ui.components` | Reusable Swing UI components |

---

# 🎨 UI / Design System

GOMON uses reusable Swing components to maintain a consistent visual language across the application.

Examples include:

- `RoundedButton`
- `RoundedTextField`
- `RoundedPasswordField`
- `RoundedComboBox`
- `LabeledField`
- `LabeledPasswordField`
- `OTPTextField`
- `RoundedSearchField`
- `AvatarButton`
- `NotificationButton`
- `MenuButton`
- `ShadowCard`
- `ShadowPanel`
- `SelectionCard`
- `GradientPanel`
- `ScrollablePanel`

### UI Goals

- Clean dashboard layouts
- Reusable components
- Consistent spacing
- Role-specific navigation
- Modern Swing appearance
- Responsive resizing where practical

---

# 🗄️ Database

GOMON currently uses **MySQL** with JDBC connectivity.

### Current database configuration

```text
Host     : localhost
Port     : 3306
Database : gomon_bd
User     : root
```

The project contains:

```text
DatabaseConnection.java
TestConnection.java
AccountDAO.java
```

### Account Data

The user/driver model represents account-level information such as:

- ID
- Full name
- Username
- Email
- Phone
- Address
- Password
- Role
- Status
- Creation information

### Driver Data

Driver-specific information includes:

- NID
- Driving License
- Vehicle Type
- Vehicle Number
- Work Time

### Driver Registration Flow

```text
Driver Registration
        ↓
Validate Account Data
        ↓
Insert Account
        ↓
Get Generated Account ID
        ↓
Insert Driver Information
        ↓
Commit Transaction
```

The DAO layer also performs rollback when a transactional driver registration operation fails.

---

# 🛠️ Technology Stack

## Core

- ☕ **Java 17**
- 🖥️ **Java Swing**
- 📦 **Maven**

## UI

- 🎨 **FlatLaf 3.6**
- Custom Swing components

## Database

- 🗄️ **MySQL**
- 🔌 **JDBC**
- **MySQL Connector/J**

## Security

- 🔐 **JBcrypt**

## Communication

- 📧 **Jakarta Mail**

---

# 📋 Requirements

Before running the project, install:

- **JDK 17 or later**
- **Maven**
- **MySQL Server**
- **VS Code / IntelliJ IDEA / Eclipse**

Recommended:

- MySQL Workbench
- Git

---

# 🚀 Getting Started

## 1. Clone the repository

```bash
git clone https://github.com/junayeembd/gomon-ride-for-everyone.git
cd gomon-ride-for-everyone
```

## 2. Create the database

Open MySQL and run:

```sql
CREATE DATABASE gomon_bd;
```

## 3. Configure database connection

The current JDBC configuration is located at:

```text
src/main/java/com/gomon/database/DatabaseConnection.java
```

Update the local credentials if necessary.

> ⚠️ For production use, database credentials should be moved to environment variables or an external configuration source rather than committed directly to the repository.

## 4. Install Maven dependencies

```bash
mvn clean install
```

## 5. Run the project

Run the application's main class:

```text
src/main/java/com/gomon/app/Main.java
```

You can run it directly from your IDE.

---

# 🔄 Core Ride Workflow

```text
┌───────────────┐
│ Register/Login│
└───────┬───────┘
        ▼
┌────────────────────┐
│ Enter Pickup/Drop  │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Select Vehicle     │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Estimate Fare/Time │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Request Ride       │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Driver Receives    │
│ Ride Request       │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Driver Accepts     │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Ride Starts        │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ Ride Completed     │
└─────────┬──────────┘
          ▼
┌────────────────────┐
│ History / Rating   │
└────────────────────┘
```

---

# 🔐 Role-Based Access

```text
                  GOMON
                    │
        ┌───────────┼───────────┐
        │           │           │
        ▼           ▼           ▼
   PASSENGER      DRIVER      ADMIN
        │           │           │
        ▼           ▼           ▼
   User Dashboard  Driver      Admin
                   Dashboard   Dashboard
```

Each role receives a dedicated interface and role-specific navigation.

---

# 📈 Current Development Status

### ✅ Implemented / Structured

- Java 17 project setup
- Maven project configuration
- Java Swing application interface
- Login interface
- Passenger registration UI
- Driver registration UI
- OTP verification flow
- Password reset flow
- Authentication service
- BCrypt password hashing
- Session management
- MySQL/JDBC connectivity
- Passenger dashboard
- Driver dashboard
- Admin dashboard structure
- Reusable UI component system
- Passenger booking interface
- Driver ride-request interface
- Driver statistics
- Driver quick actions
- Safety UI sections

### 🚧 Ongoing / Future Integration

Some advanced operational features are represented by UI and architecture but require further service/database integration, including:

- Full real-time GPS tracking
- Production map integration
- Real-time driver matching
- Complete digital payment integration
- Full live chat/calling backend
- Advanced ride-state synchronization
- Production notification system
- Expanded admin operations
- Advanced analytics and reporting

> The repository intentionally distinguishes between **implemented UI/architecture** and **features that still require full backend/integration work**.

---

# 🗺️ Roadmap

### Phase 1 — Foundation
- [x] Project architecture
- [x] Maven configuration
- [x] Authentication UI
- [x] Database connectivity
- [x] Session management

### Phase 2 — Core Ride System
- [x] Passenger booking interface
- [x] Driver dashboard
- [x] Ride request interface
- [ ] Full ride-state backend integration
- [ ] Real-time driver matching

### Phase 3 — Communication & Safety
- [x] Safety UI
- [x] Emergency concepts
- [x] Trip sharing UI
- [ ] Real-time chat
- [ ] Calling integration
- [ ] Production emergency workflow

### Phase 4 — Payments & Maps
- [x] Wallet UI
- [ ] Digital payment gateway
- [ ] Real-time map integration
- [ ] GPS tracking
- [ ] Route optimization

### Phase 5 — Production Readiness
- [ ] Cloud deployment
- [ ] Mobile companion application
- [ ] Advanced analytics
- [ ] Automated testing
- [ ] Production monitoring

---

# 📊 Project Highlights

| Area | GOMON |
|---|---|
| Application Type | Desktop |
| Architecture | Modular / Layered |
| GUI | Java Swing |
| Language | Java 17 |
| Build Tool | Maven |
| Database | MySQL |
| Connectivity | JDBC |
| Authentication | Service + DAO |
| Password Security | BCrypt |
| OTP | Email-based |
| Roles | Passenger / Driver / Admin |
| UI Style | Custom Swing + FlatLaf |
| Version Control | Git / GitHub |

---

# 🔮 Future Vision

GOMON is designed as a foundation that can grow beyond a desktop academic project.

Potential future directions include:

- 📱 Android / iOS companion application
- 🌍 Real-time location tracking
- 🗺️ Advanced route planning
- 🤖 AI-assisted fare prediction
- 🚦 Traffic-aware route recommendations
- 💳 bKash / Nagad / card payments
- 🔔 Push notifications
- 📞 Voice and video communication
- 👨‍👩‍👧 Trusted family trip sharing
- 📊 Advanced analytics
- ☁️ Cloud-based backend
- 🔐 Improved production security
- 🧪 Automated testing and CI/CD

---

# 🧪 Development & Collaboration

### Clone

```bash
git clone https://github.com/junayeembd/gomon-ride-for-everyone.git
```

### Create a branch

```bash
git checkout -b feature/your-feature
```

### Commit

```bash
git add .
git commit -m "Add your feature"
```

### Push

```bash
git push origin feature/your-feature
```

For small personal updates on `main`:

```bash
git add .
git commit -m "Update project"
git push
```

---

# ⚠️ Notes

- This project is currently intended for **academic and educational development**.
- Some UI features are prepared for future backend integration.
- Database configuration should be customized for the local environment.
- Production deployment should use secure external configuration for credentials and mail settings.

---

# 👨‍💻 Author

<div align="center">

### Jannat UI Nayeem

Computer Science & Engineering Student

<a href="https://github.com/junayeembd">
  <img src="https://img.shields.io/badge/GitHub-junayeembd-181717?style=for-the-badge&logo=github" alt="GitHub">
</a>

</div>

---

# ⭐ Support the Project

If you find **GOMON – Ride for Everyone** interesting or useful, consider giving the repository a ⭐ on GitHub.

<div align="center">

### 🚗 GOMON
**Ride for Everyone**

*Built with Java. Designed for smarter rides.*

</div>
