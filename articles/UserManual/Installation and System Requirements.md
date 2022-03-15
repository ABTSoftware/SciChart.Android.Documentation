---
uid: "userManual.InstallationAndSystemRequirements"
---

# Installation and System Requirements

### Q: What hardware is required to run SciChart Android?
SciChart Android is designed to run on any Android device capable of supporting Android v4.4 (KitKat) and up. Development of Android Applications with SciChart Android can be done on an OSX, Windows or Linux PC.

### Q: What IDEs are recommended?
At SciChart we recommend using latest version of [Android Studio](https://developer.android.com/studio/index.html).

### Q: Do I need a Fast Android Device?
Not necessarily! You only need a device capable of supporting KitKat (v4.4) and a GPU capable of supporting OpenGL ES 2.0 (which is pretty much everything). SciChart for Android is very memory and CPU efficient, using fewer CPU, GPU and memory resources than competitors, resulting in longer battery life in like-for-like applications.

### Q: But what hardware is recommended for Fastest Operation?
SciChart for Android favours faster CPU over faster GPU. For optimum performance it is recommended to run on a quad-core device with 1.3GHz (or better) CPU and a recent GPU capable of supporting OpenGL ES 2.0.

For instance, in our testing, we notice large performance increases when running on faster hardware such as the Samsung Galaxy S6 Edge vs. slower hardware such as Samsung Galaxy Tab 3.

### Q: How much RAM do I need to run SciChart?
SciChart is actually very memory efficient. SciChart Android uses not much more memory than required to hold the raw data, for instance, if you wish to display 1,000,000 points of XY data where X and Y types are double, you can expect to use just over 1M * 8 * 2 bytes = 16MB, plus approx. 30MB for the app to host the chart. So for 2D Charts, SciChart for Android can be run on just about any device so long as minimum operating system requirements are met.

### Q: Will SciChart for Android support Embedded Devices?
Yes! SciChart for Android was developed specifically to cope with the use-case of running on custom hardware, and has been optimised in the extreme. We have customers running SciChart for Android on custom hardware based on the Freescale I.MX-6 Dual core 800MHz device with acceptable performance for real-time monitoring equipment.
