# EasyPops

EasyPops is a lightweight and easy-to-use Android library for creating customizable and visually appealing popup messages in your application. Whether you need a simple toast, a fancy alert, or a fully customizable popup, EasyPops makes it effortless to integrate popups into your project.

---

## 🎉 Features

- Simple and intuitive API.
- Fully customizable popups (colors, text, animations, etc.).
- Supports multiple popup styles like toast, snackbars, and alerts.
- Lightweight and optimized for performance.
- Compatible with Android API level 24 and above.
- Built-in support for material design principles.

---

## 🚀 Installation

### Step 1: Add the Dependency

Add the following to your **build.gradle (project)** file to include the GitHub Packages repository:
```groovy
allprojects {
    repositories {
        maven {
            url "https://maven.pkg.github.com/your-username/EasyPops"
            credentials {
                username = "GITHUB_USERNAME"
                password = "GITHUB_TOKEN"
            }
        }
    }
}
Then, add the dependency to your module-level build.gradle:

groovy
Copy
Edit
dependencies {
    implementation "com.github.doxart:easypops:1.0.0"
}
📖 Usage
Simple Popup Example
java
Copy
Edit
EasyPops.showToast(context, "Hello, EasyPops!");
Customizing Popup Appearance
java
Copy
Edit
EasyPops.create(context)
    .setMessage("This is a custom popup!")
    .setTextColor(Color.WHITE)
    .setBackgroundColor(Color.parseColor("#6200EE"))
    .setDuration(EasyPops.LENGTH_LONG)
    .show();
Adding Animations
java
Copy
Edit
EasyPops.create(context)
    .setMessage("Popup with animation!")
    .setAnimationStyle(EasyPops.ANIMATION_FADE)
    .show();
🛠️ Configuration
Customizing Global Defaults
You can set default styles and configurations for all popups in your Application class:

java
Copy
Edit
EasyPops.setDefaultBackgroundColor(Color.BLACK);
EasyPops.setDefaultTextColor(Color.WHITE);
EasyPops.setDefaultDuration(EasyPops.LENGTH_SHORT);
📦 Dependencies
Material Components
Ensures a modern look and feel that aligns with Android's material design principles.
groovy
Copy
Edit
implementation "com.google.android.material:material:1.9.0"
📝 License
This library is licensed under the MIT License.
Feel free to use it in your personal and commercial projects.

🤝 Contributing
Contributions are welcome! If you have ideas, feature requests, or bug fixes, please create an issue or submit a pull request. Follow these steps to contribute:

Fork the repository.
Create a new branch for your feature (git checkout -b feature-name).
Commit your changes (git commit -m "Added feature X").
Push to the branch (git push origin feature-name).
Create a pull request.
🧑‍💻 Author
Developed with ❤️ by Doxart.
Feel free to reach out for support or collaboration opportunities.

🌟 Show Your Support
If you like this library, don't forget to give it a ⭐ on GitHub! 😊
