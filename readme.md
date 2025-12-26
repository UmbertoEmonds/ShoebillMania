# 🦢 Shoebill Mania

**Shoebill Mania** est une application Android moderne conçue pour découvrir et parcourir des anecdotes fascinantes. L'application met l'accent sur une expérience utilisateur fluide et une architecture robuste.

---

## 🚀 Fonctionnalités

* Affichage des anecdotes qui changent au swipe.
* Chargement des données via une API distante.

---

## 🛠 Stack Technique

L'application s'appuie sur les dernières bibliothèques recommandées pour le développement Android :

* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Pour la construction d'interfaces utilisateur déclaratives et natives.
* **[Hilt](https://developer.android.com/training/dependency-injection/hilt-android):** Pour l'injection de dépendances (DI), facilitant la modularité et les tests.
* **[Retrofit](https://square.github.io/retrofit/):** Pour la gestion des appels réseau et la communication avec l'API.
* **[Gson](https://github.com/google/gson):** Pour la sérialisation et désérialisation des données JSON.
* **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html):** Pour la gestion des tâches asynchrones et la programmation non-bloquante.

---

## 🏗 Architecture du Projet

L'application suit les principes de la **Clean Architecture** et du **MVVM (Model-View-ViewModel)**. Elle est organisée par fonctionnalités (*feature-based*) pour une meilleure scalabilité :

### Structure des dossiers (`features.story`) :

* **`domain` :** Le cœur métier de l'application. Contient les modèles de données (`Story`), les interfaces des dépôts (`StoryRepository`) et les cas d'utilisation (`GetAllStoriesUseCase`). Cette couche est indépendante de toute plateforme.
* **`data` :** Gère la provenance des données. Contient l'implémentation du dépôt (`StoryRepositoryImpl`) et les sources de données (`StoryService` via Retrofit).
* **`presentation` :** Gère l'affichage et l'interaction utilisateur.
* `viewmodel` : Gère la logique de l'UI et la communication avec la couche Domain.
* `state` : Définit l'état de l'écran (chargement, succès, erreur).
* `composable` : Contient les composants UI développés avec Jetpack Compose (ex: `StoryCard`).



### Injection de Dépendances (`di`) :

* **`NetworkModule` :** Configuration de Retrofit et Gson.
* **`RepositoryModule` :** Liaison entre les interfaces du domaine et leurs implémentations dans la couche data.

---

## 📂 Aperçu de l'Arborescence

```text
app/src/main/java/com/umbertoemonds.shoebillmania/
├── di/                         # Injection de dépendances
│   ├── NetworkModule.kt
│   └── RepositoryModule.kt
├── features.story/             # Feature : Gestion des anecdotes
│   ├── data/                   # Couche Données (DataSource, Repo Impl)
│   ├── domain/                 # Couche Métier (Models, UseCases, Repo Interface)
│   └── presentation/           # Couche UI (Compose, ViewModel, State)
├── MainActivity.kt             # Point d'entrée de l'UI
└── MainApplication.kt          # Initialisation de Hilt

```

---

## 🛠 Installation

1. Clonez le dépôt :
```bash
git clone https://github.com/votre-utilisateur/shoebill-mania.git

```


2. Ouvrez le projet dans **Android Studio**.
3. Synchronisez le projet avec les fichiers **Gradle**.
4. Lancez l'application sur un émulateur ou un appareil physique.