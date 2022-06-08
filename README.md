# Official documentation for [SciChart.Android](https://www.scichart.com) 📑

This repository contains official documentation for [SciChart.Android](https://www.scichart.com): High Performance Realtime [Android Chart Library](https://www.scichart.com/android-chart-features). 
 
[SciChart.Android Chart Examples](https://github.com/ABTSoftware/SciChart.Android.Examples) are provided in Java & Kotlin. If you are looking for other platforms then please see here:

* [iOS Charts](https://github.com/ABTSoftware/SciChart.iOS.Examples) (Swift / Objective C)
* [WPF Charts](https://github.com/ABTSoftware/SciChart.WPF.Examples) (C# / WPF)
* [Xamarin Charts](https://github.com/ABTSoftware/SciChart.Xamarin.Examples) (C#)
* [NativeScript Charts](https://github.com/ABTSoftware/SciChart.NativeScript.Examples) (TypeScript / Javascript) BETA!
  
***

## Documentation Samples
Here you can also find [Examples and Tutorials used in documentation articles](samples):
- [Creating Your First SciChart Android Appliation](samples/first-app)
- [Documentation Samples Sandbox](samples/sandbox)
- [SciChart Android Native Tutorials](samples/tutorials-native)
- [SciChart Android Xamarin Tutorials](samples/tutorials-xamarin)

***

## How to Build Documentation 
- [Required dependencies](#required-dependencies)
- [Project structure](#project-structure)
- [Build process](#build-process)
- [Development process](#development-process)
  - [Adding new article](#adding-new-article) 
  - [Adding new category](#adding-new-category)
  - [Alternative way to add article with new subcategory](#alternative-way-to-add-article-with-new-subcategory)

### **Required dependencies**
Need to install [DocFX](https://github.com/dotnet/docfx/)

On Mac it can be installed from brew: [brew install docfx](https://formulae.brew.sh/formula/docfx#default)

> **_NOTE:_** Brew installation [might be broken](https://github.com/dotnet/docfx/issues/5785). The sipmle workaround is manual installation like below: 
```sh
brew tap dotnet/docfx https://github.com/dotnet/docfx.git
brew extract --version 2.59 docfx dotnet/docfx
brew install --ignore-dependencies docfx@2.59
```

Latest stable version at this moment is v2.59

### **Project structure**
- The main configuration is stored at `docfx.json` (which folder should be scanned and so on).
- The homepage is generated from `index.md` file
- Primary table of content (TOC), that descibes main categoris is in `toc.yml`
- Metadata used to generate API docs is at `api` folder
- Documentation articles are stored at `articles` folder
- Images used by articles should be stored at `images` folder
- Each category contains its TOC where you need to add new articles and their position at tree view
- Style and template overrides for documentation website, that are applied on top of default `DocFX` theme can be found is at `templates/SciChart.Web` folder

### **Build process**
Run one of the following commands from the `build/build_docs.sh` script:
| **Command**       | **Description**                                                                                         |
| ----------------- | ------------------------------------------------------------------------------------------------------- |
| generate-api-docs | generates \`.yaml\` API files from SciChart.Android JavaDoc comments.                                   |
| generate-site     | generates full documentation site from \`.md\` articles and \`.yaml\` api docs metadata.                |
| build             | build full documentation from \`.md\` articles and SciChart.Android JavaDoc comments.                   |
| serve             | builds and serves site to \`localhost\` from \`.md\` articles and prepared \`.yaml\` api docs metadata. |

e.g `sh build/build_docs.sh generate-site`

### **Development process**
1. To build documentation at first we need to generate metadata from Javadoc comments. To do this need to execute special Gradle task from SciChart project, which builds project in release build (to generate all source files from templates) and then extracts comments as `*.yml` files into `api` folder:

`gradle generateReleaseApiDocs`

This task should be executed everytime Javadocs changed

2. Then to build documentation from modified *.md files and extracted *.yml metadata need to execute next command:

`docfx docfx.json --serve`

This will build documentation and launch server at [localhost](http://localhost:8080/)

### Adding new article
1. Create `*.md` file at `articles` or one of its subfolders
2. Edit `toc.yml` file at that folder and add new item, that has name that is used in tree and path to `*.md` file:

```yaml
- name: 'Installation and System Requirements'
  href: InstallationAndSystemRequirements.md
```

### Adding new category
1. Create new folder where new articles should be added
2. Create new `toc.yml` in this folder and add new article there
3. Modify `toc.yml` of parent folder to include new category - set name of subcategory and path to new toc.yml relative to current toc.yml:

```yaml
- name: 'Quick Start Guide'
  href: QuickStart/toc.yml
```

### Alternative way to add article with new subcategory
If there will be only one item in subcategory then another way would be to add new `*.md` files directly into parent `toc.yml`, but in this case href would need to contain relative path for `*.md` file and new subcategory by using `items`:

```yaml
- name: 'Quick Start Guide'
  items:
  - name: 'Installation and System Requirements'
    href: QuickStart/InstallationAndSystemRequirements.md
```

## Article content

DocFx uses [extended version of Github Markdown syntax](https://dotnet.github.io/docfx/spec/docfx_flavored_markdown.html). So in addition to standard Markdown syntax we can:
 - include code snippets
 - reference other articles and `yaml` articles extracted from JavaDoc comments in code by their ids 
 - add tabs ( for providing code snippets in both Java/Kotlin/Xamarin )

### Adding code sample into article
1. Create a file with required source ( it could be part of existing project in `samples` directory or completely new project )
2. In source code add comments to mark start and end of section which should be included into article:
```kotlin
fun createAxis() {
    // <CreateNewAxis>
    val xAxis = NumericAxis(context)
    // </CreateNewAxis>
}
```
3. In article which should include code sample use special [syntax for adding code snippets](https://dotnet.github.io/docfx/spec/docfx_flavored_markdown.html#code-snippet). Result should look similar to this one:
```markdown
[!code[CreateNewAxis](<RelativePathToFile>#CreateNewAxis)]
```

### Referencing extracted JavaDocs in article:
1. During process of extraction JavaDocs from source code you get `yml` files that are stored in `api` folder. For each class/method/property there is unique `uid` that is generated, that allows to reference it. You can also [add this `uids` for documentation articles](https://dotnet.github.io/docfx/spec/docfx_flavored_markdown.html#yaml-header) as alternative to referencing markdown files directly via relative path.
2. To reference API docs or article you can use next [syntax](https://dotnet.github.io/docfx/spec/docfx_flavored_markdown.html#cross-reference):
```markdown
<xref:<uidOfArticleOrAPiDoc>>

this will automatically generate link based on title from article:
<xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateXyAt(int,TX,TY)>

if you want custom text for link use next syntax:
[CustomTextForLink](xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateXyAt(int,TX,TY))
```

### Adding tabs
To add tabs use next [syntax](https://dotnet.github.io/docfx/spec/docfx_flavored_markdown.html#tabbed-content):
```markdown
# [Java](#tab/java)
<Java content>
# [Java with Builders API](#tab/javaBuilder)
<Java with Builders content>
# [Kotlin](#tab/kotlin)
<Kotlin content>
# [Xamarin.Android](#tab/xamarin)
<Xamarin.Android content>
***
```
We use same ids(`java`, `javaBuilder`, `kotlin`, `xamarin`) in `#tab/<id>` part, because in case reader selects another tab, e.g. changes from Java to Kotlin, and if there are multiple tabs on same page, then all tabs on current page will automatically switch to Kotlin.