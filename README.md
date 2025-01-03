# Example Product App

A modern Android application that demonstrates clean architecture, MVVM pattern, and modern Android development practices. The app displays a list of products from DummyJSON API and allows users to view detailed information about each product.

## Features

- Product list with search functionality
- Product details view with images and complete information
- Material Design UI components
- Data binding for efficient UI updates
- Navigation component for seamless navigation
- Retrofit for API communication
- Glide for image loading

## Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Kotlin version: 1.9.10
- Gradle version: 8.2.0

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone [repository-url]
   ```

2. Open Android Studio and select "Open an existing project"

3. Navigate to the cloned directory and click "OK"

4. Wait for the Gradle sync to complete

5. Run the app on an emulator or physical device:
   - Select Run -> Run 'app'
   - Choose your target device
   - Click "OK"

## Project Structure

The project follows a modular architecture with three main modules:

- `app`: Main application module
- `data`: Data layer with API services and repositories
- `ui`: Presentation layer with fragments, viewmodels, and UI components

## Dependencies

- AndroidX Core KTX: 1.12.0
- AndroidX AppCompat: 1.6.1
- Material Design Components: 1.11.0
- Navigation Component: 2.7.5
- Retrofit: 2.9.0
- Glide: 4.16.0
- Kotlin Coroutines: 1.7.3