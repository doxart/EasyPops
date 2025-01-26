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

Add the dependency to your module-level build.gradle:

```groovy
dependencies {
    implementation "com.github.doxart:easypops:1.0.0"
}
```

## 📖 Usage
Simple Popup Example

```java
EasyPopup.createProgress(this).buildAndShow();
```

Snack Example

```java
EasyPopup.createSnack(this).setSnackStyle(SnackStyle.SNACK_ERROR(this)).setMessage("This is error snack.").buildAndShow();
```

Date Picker Example

```java
DatePickerStyle datePickerStyle = new DatePickerStyle();
datePickerStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));

EasyPopup.createDatePicker(this).setTitle("Date picker").setMessage("Select your date").setDatePickerStyle(datePickerStyle).setOnDateSelectListener(new OnDateSelectListener() {
     @Override
     public void onDateSelected(int day, int month, int year) {
          String date = day + "/" + month + "/" + year;
     }

     @Override
     public void onDismiss() {
     }
}).buildAndShow();
```

Dialog Example

```java
EasyPopup.createDialog(this).setTitle("Title").setMessage("This is message").setDialogStyle(DialogStyle.DIALOG_NORMAL()).buildAndShow();
```

## 🛠️ Configuration
Customizing Global Defaults
You can set default styles and configurations for all popups in your Application class:

```
EasyPops.setDefaultBackgroundColor(Color.BLACK);
EasyPops.setDefaultTextColor(Color.WHITE);
EasyPops.setDefaultDuration(EasyPops.LENGTH_SHORT);
```

## 📦 Dependencies
Material Components
Ensures a modern look and feel that aligns with Android's material design principles.

```groovy
implementation "com.google.android.material:material:1.9.0"
```

## 📝 License
This library is licensed under the MIT License.
Feel free to use it in your personal and commercial projects.

## 🤝 Contributing
Contributions are welcome! If you have ideas, feature requests, or bug fixes, please create an issue or submit a pull request. Follow these steps to contribute:

Fork the repository.
Create a new branch for your feature (git checkout -b feature-name).
Commit your changes (git commit -m "Added feature X").
Push to the branch (git push origin feature-name).
Create a pull request.

## 🧑‍💻 Author
Developed with ❤️ by Doxart.
Feel free to reach out for support or collaboration opportunities.

## 🌟 Show Your Support
If you like this library, don't forget to give it a ⭐ on GitHub! 😊
