# 🦢 Shoebill Mania

**Shoebill Mania** is a modern Android application designed to discover and browse fascinating anecdotes. The app focuses on a smooth user experience and a robust architecture.

---

## 🚀 Features

* Display of anecdotes that change with a swipe.
* Data loading via a remote API.

---

## 🛠 Tech Stack

The application relies on the latest recommended libraries for Android development:

* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** For building declarative and native user interfaces.
* **[Hilt](https://developer.android.com/training/dependency-injection/hilt-android):** For Dependency Injection (DI), facilitating modularity and testing.
* **[Retrofit](https://square.github.io/retrofit/):** For managing network calls and API communication.
* **[Gson](https://github.com/google/gson):** For JSON data serialization and deserialization.
* **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html):** For managing asynchronous tasks and non-blocking programming.

---

## 🏗 Project Architecture

The application follows **Clean Architecture** principles and the **MVVM (Model-View-ViewModel)** pattern. It is organized by features for better scalability:

### Folder Structure (`features.story`):

* **`domain`:** The business core of the application. Contains data models (`Story`), repository interfaces (`StoryRepository`), and use cases (`GetAllStoriesUseCase`). This layer is platform-independent.
* **`data`:** Manages data sourcing. Contains the repository implementation (`StoryRepositoryImpl`) and data sources (`StoryService` via Retrofit).
* **`presentation`:** Manages display and user interaction.
* `viewmodel`: Manages UI logic and communication with the Domain layer.
* `state`: Defines the screen state (loading, success, error).
* `composable`: Contains UI components built with Jetpack Compose (e.g., `StoryCard`).



### Dependency Injection (`di`):

* **`NetworkModule`:** Retrofit and Gson configuration.
* **`RepositoryModule`:** Binding between domain interfaces and their implementations in the data layer.

---

## 📂 Directory Overview

```text
app/src/main/java/com/umbertoemonds.shoebillmania/
├── di/                         # Dependency Injection
│   ├── NetworkModule.kt
│   └── RepositoryModule.kt
├── features.story/             # Feature: Anecdote Management
│   ├── data/                   # Data Layer (DataSource, Repo Impl)
│   ├── domain/                 # Domain Layer (Models, UseCases, Repo Interface)
│   └── presentation/           # UI Layer (Compose, ViewModel, State)
├── MainActivity.kt             # UI Entry Point
└── MainApplication.kt          # Hilt Initialization

```

---

## 🛠 Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/shoebill-mania.git

```

2. Open the project in **Android Studio**.
3. Sync the project with **Gradle** files.
4. Run the application on an emulator or a physical device.

---
