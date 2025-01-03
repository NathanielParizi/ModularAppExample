# Product App

An Android app built with MVVM architecture that displays and searches products from DummyJSON API.

## Features

- Product list with search
- Product details with images
- Material Design UI
- Data Binding
- Navigation Component
- Retrofit for API calls
- Glide for images

## Requirements

- Android Studio Hedgehog (2023.1.1+)
- Min SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Kotlin: 1.9.10
- Gradle: 8.2.0

## Setup

1. Clone the repository:
   ```bash
   git clone [repository-url]
   ```

2. Open in Android Studio

3. Let Gradle sync complete

4. Run the app:
   - Run → Run 'app'
   - Select device
   - Click OK

## Usage

1. Browse products in the main list

2. Search products using the top bar icon

3. Tap a product to see details:
   - Images
   - Description
   - Price
   - Specifications

## Project Structure

Three main modules:

- `app`: Main application module
- `data`: API services and repositories
- `ui`: Fragments, ViewModels and layouts

## Libraries

- AndroidX Core KTX: 1.12.0
- AppCompat: 1.6.1
- Material: 1.11.0
- Navigation: 2.7.5
- Retrofit: 2.9.0
- Glide: 4.16.0
- Coroutines: 1.7.3
