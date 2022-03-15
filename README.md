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