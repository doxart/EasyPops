# EasyPops

EasyPops is a lightweight and easy-to-use Android library for creating customizable and visually appealing popup messages in your application. Whether you need a simple toast, a fancy alert, or a fully customizable popup, EasyPops makes it effortless to integrate popups into your project.

---

## 🎉 Features

- Simple and intuitive API.
- Fully customizable popups (colors, text, animations, etc.).
- Supports multiple popup styles like progress, snackbars, date pickers and dialogs.
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

### Progress

```java
EasyPopup.createProgress(this)
     .buildAndShow();
```

![progress](https://github.com/doxart/EasyPops-Easy-Android-Pop-Up/blob/master/res/progress.gif)

#### Customizing

```java
EasyPopup.createProgress(this)
     .setProgressColor(ContextCompat.getColor(this, R.color.primary))
     .setAutoCancel(10000)
     .buildAndShow();
```

### Snack

```java
EasyPopup.createSnack(this)
     .setSnackStyle(SnackStyle.SNACK_ERROR(this))
     .setMessage("This is error snack.")
     .buildAndShow();
```

![snack](https://github.com/doxart/EasyPops-Easy-Android-Pop-Up/blob/master/res/snack.gif)

#### Customizing

```java
SnackStyle snackStyle = new SnackStyle();
snackStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
snackStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
snackStyle.setButtonColor(ContextCompat.getColor(this, R.color.primary));
snackStyle.setPosition(SnackStyle.Position.BOTTOM);
```

or use direct styling

```java
EasyPopup.createSnack(this)
     .setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
     .buildAndShow();
```

### Date Picker

```java
DatePickerStyle datePickerStyle = new DatePickerStyle();
datePickerStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));

EasyPopup.createDatePicker(this)
     .setTitle("Date picker")
     .setMessage("Select your date")
     .setDatePickerStyle(datePickerStyle)
     .setOnDateSelectListener(new OnDateSelectListener() {
     @Override
     public void onDateSelected(int day, int month, int year) {
          String date = day + "/" + month + "/" + year;
     }

     @Override
     public void onDismiss() {
     }
}).buildAndShow();
```

![datepicker](https://github.com/doxart/EasyPops-Easy-Android-Pop-Up/blob/master/res/datepicker.gif)

#### Customizing

```java
DatePickerStyle datePickerStyle = new DatePickerStyle();
datePickerStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
datePickerStyle.setTitleColor(ContextCompat.getColor(this, R.color.white));
datePickerStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
datePickerStyle.setPositiveButtonColor(ContextCompat.getColor(this, R.color.primary));
datePickerStyle.setPositiveButtonTextColor(ContextCompat.getColor(this, R.color.white));
```

or use direct styling

```java
EasyPopup.createDatePicker(this)
     .setBackgroundColor(ContextCompat.getColor(this, R.color.white))
     .buildAndShow();
```

### Dialog

```java
EasyPopup.createDialog(this)
     .setTitle("Title")
     .setMessage("This is message")
     .setDialogStyle(DialogStyle.DIALOG_NORMAL())
     .buildAndShow();
```

![dialog](https://github.com/doxart/EasyPops-Easy-Android-Pop-Up/blob/master/res/dialog.gif)

#### Customizing

```java
DialogStyle dialogStyle = new DialogStyle();
dialogStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
dialogStyle.setTitleColor(ContextCompat.getColor(this, R.color.white));
dialogStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
dialogStyle.setPositiveButtonColor(ContextCompat.getColor(this, R.color.primary));
dialogStyle.setPositiveButtonTextColor(ContextCompat.getColor(this, R.color.white));
dialogStyle.setNegativeButtonColor(ContextCompat.getColor(this, R.color.primary));
dialogStyle.setNegativeButtonTextColor(ContextCompat.getColor(this, R.color.white));
```

or use direct styling

```java
EasyPopup.createDialog(this)
     .setTitleColor(ContextCompat.getColor(this, R.color.primary))
     .buildAndShow();
```

#### Customizing

## 📦 Dependencies
Material Components
Ensures a modern look and feel that aligns with Android's material design principles.

```groovy
implementation "com.google.android.material:material:1.12.0"
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
