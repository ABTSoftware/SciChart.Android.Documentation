---
uid: "quickStartGuide.projectSetup.ProjectSetup"
---

# Creating your first SciChart Android App

Playing around with [SciChart Android Examples Suite](xref:quickStartGuide.SciChartAndroidExamplesSuite) is great, but you are probably interested in creating your own application by adding some charts! Let's get started and create our first SciChart Android App using Kotlin.

## Setting up a new Android Application
Assuming you've [created an Android project](https://developer.android.com/training/basics/firstapp/creating-project) in either `Java`, `Kotlin` or even `Xamarin.Android` - next step should be [integrating SciChart.framework](xref:userManual.IntegratingSciChartLibraries). The easiest way of doing so is by using [Maven](xref:userManual.IntegratingSciChartLibraries#integrating-scichart-using-maven). 

- Open the "build.gradle" file for the project and declare a new Maven repository in the "repositories" node. Use the URL from above:
[!code-gradle[MavenRepositories](../../../samples/sandbox/settings.gradle#AddSciChartMavenRepositories)]

- Open the "build.gradle" file for a module which SciChart is intended to be used within. Add SciChart Android libraries as module dependencies:
[!code-gradle[MavenDependencies](../../../samples/sandbox/app/build.gradle#DeclareSciChartLibariesAsMavenDependencies)]

> [!NOTE]
> You can also get the extensive sample app downloading the [SciChart Android Trial](https://www.scichart.com/downloads) package, which can be used for manual integration of SciChart.framework.

## Set the License Key
Before you build and run the application, you will need to apply a trial or purchased license key. You can find full instructions on the page [Licensing SciChart Android](https://www.scichart.com/licensing-scichart-android/).

You can fetch a Trial License Key directly from the [Downloads](https://www.scichart.com/downloads/) page following instructions from Licensing SciChart Android. Or, if you have purchased SciChart Android, you can find the full purchased license keys at your SciChart Account Page.

When you have your key, you should apply it via <xref:com.scichart.charting.visuals.SciChartSurface.setRuntimeLicenseKey(java.lang.String)> like below:

[!code-swift[SetRuntimeLicenseKey](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/DocSandboxApplication.kt#SetRuntimeLicenseKey)]

After creating MyApp add this to AnroidManifest file in application tag:

[!code-swift[SetRuntimeLicenseKey](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/DocSandboxApplication.kt#SetRuntimeLicenseKeyManifest)]

> [!NOTE]
> The License Key must be set in your app once, and once only before any <xref:com.scichart.charting.visuals.SciChartSurface> instance is initialized.

From here, you can create **2D or 3D chart**. Please refer to the following sections for more information:
- [The SciChartSurface Type](#the-scichartsurface-type)
- [The SciChartSurface3D Type](xref:quickStartGuide.projectSetup.AddingChartUsingxml#the-scichartsurface3d-type)

## The SciChartSurface Type
The root **2D chart** view is called the <xref:com.scichart.charting.visuals.SciChartSurface>. This is the [Android View](https://developer.android.com/reference/android/view/View) you will be adding to your applications wherever you need a **chart**. You can add more than one <xref:com.scichart.charting.visuals.SciChartSurface>, you can configure them independently, and you can link them together.

Since this is a ***Quick Start Example***, we will use the one instance of <xref:com.scichart.charting.visuals.SciChartSurface>, so let’s start by declaring one!

### Declaring a SciChartSurface Instance
There few ways of adding <xref:com.scichart.charting.visuals.SciChartSurface> to your application. We will look more closely into the following:
- [Using XML](xref:quickStartGuide.projectSetup.AddingChartUsingxml)
- [Purely from code](xref:quickStartGuide.projectSetup.AddingChartUsingCode)
- [Jetpack Compose](xref:quickStartGuide.projectSetup.AddingChartUsingCompose) 