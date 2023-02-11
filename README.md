# JetpackComposeApp
<img width="323" alt="Screenshot 2023-02-11 at 16 40 21" src="https://user-images.githubusercontent.com/52719177/218258468-890aa23d-72be-4ad1-8acb-abd9042a8006.png">

### Structural design pattern
The app is built with the Model-View-ViewModel (MVVM) is its structural design pattern that separates objects into three distinct groups:
- Models hold application data
- Views to display screens
- View models transform data from model into values that can show on a view


## Used in project
- [Kotlin] - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.
- [Androidx Core KTX ] - This is a collection of Kotlin extensions for Android app development. It helps to simplify and make the code more readable and concise.
- [Androidx Lifecycle (runtime-ktx, viewmodel-compose, viewmodel-ktx)] - These dependencies are used for managing the lifecycle of Android components and provide a way to persist data across configuration changes.
- [Androidx Compose(ui, material, ui-test-junit4, ui-tooling, ui-tooling-preview)] - Android Compose is a modern toolkit for building UI, and these dependencies provide the necessary components for building a UI in the app, as well as testing and previewing tools.
- [Androidx Navigation (navigation-compose) - This dependency provides a simple and efficient way to handle navigation within the app.
- [ViewModel] -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
- [Coroutines (kotlinx-coroutines-core, kotlinx-coroutines-android) ]- These dependencies are used to manage background tasks in a more efficient and organized way, which helps to improve the app's performance.
- [Dagger Hilt (hilt-android, hilt-android-compiler)] - This dependency provides a way to implement dependency injection in the app, making it easier to manage and maintain the app's code.
- [Paging Compose] - This dependency is used to load and display large datasets in a more efficient way, improving the app's performance and user experience.
- [Constraintlayout Compose] - This dependency is used to create a flexible and efficient layout for the app.
- [System UI controller for theme] - This dependency is used to control the app's appearance and behavior, including themes and styles.
- [Local datastore] - This dependency is used to store data locally on the device, providing offline functionality and improved performance.


## App features
- Show car's data from local datastore
- Change car's doors' locking state (lock/unlock)
- Click to refresh button to refresh data(Actually just changing date of update)
