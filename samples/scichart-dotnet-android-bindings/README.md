# SciChart .NET Android Binding Library

This project provides a .NET Android binding for the SciChart Android charting library, enabling you to use SciChart's powerful charting capabilities in your .NET MAUI, Xamarin.Android, or .NET Android applications.

## Project Overview

This binding library wraps the SciChart Android Java libraries (provided as `.aar` files) and exposes them as C# APIs for use in .NET Android applications. The project includes custom transformations and additions to handle binding generator gaps and provide a more idiomatic .NET API surface.

### Target Framework

- **Target Framework:** `net8.0-android`
- **Minimum Android API Level:** API 21 (Android 5.0)

### SciChart Libraries Included

The binding wraps the following SciChart Android libraries:

1. `charting-release.aar` - Core 2D charting functionality
2. `charting3d-release.aar` - 3D charting functionality
3. `core-release.aar` - Core framework components
4. `data-release.aar` - Data handling and series
5. `drawing-release.aar` - Drawing and rendering components
6. `extensions-release.aar` - 2D chart extensions and utilities
7. `extensions3d-release.aar` - 3D chart extensions and utilities

## Prerequisites

Before building this project, ensure you have:

1. **.NET SDK 8.0 or later** - Required for `net8.0-android` target framework
2. **Android workload for .NET** - Install using: `dotnet workload install android`
3. **Android SDK** - Required for Android development tools
4. **Java JDK** - Required for Java interop and binding generation
5. **SciChart .aar files** - The 7 `.aar` files listed above

## Setup Instructions

### Step 1: Add the Required .aar Files

Place all 7 SciChart `.aar` files in the **root directory** of the project (the same directory where `SciChart.csproj` is located):

```
SciChart/
├── SciChart.csproj
├── charting-release.aar          ← Place here
├── charting3d-release.aar        ← Place here
├── core-release.aar              ← Place here
├── data-release.aar              ← Place here
├── drawing-release.aar           ← Place here
├── extensions-release.aar        ← Place here
├── extensions3d-release.aar      ← Place here
├── Additions/
├── Transforms/
└── ...
```

**Important:** The .NET Android binding SDK automatically detects `.aar` files placed in the project root directory. No explicit configuration in the `.csproj` file is needed.

### Step 2: Verify Project Structure

Ensure your project structure includes:

- `SciChart.csproj` - The project file
- `Transforms/Metadata.xml` - Metadata transformations for binding customization
- `Transforms/EnumFields.xml` - Enum field mappings (if present)
- `Transforms/EnumMethods.xml` - Enum method mappings (if present)
- `Additions/` folder - Contains C# partial classes and extensions for binding fixes

## Building the Project

### Build in Debug Configuration

To build the project in Debug mode:

```bash
dotnet build -c Debug
```

### Build in Release Configuration

To build the project in Release mode:

```bash
dotnet build -c Release
```

### Clean Build

If you need to perform a clean build (removes all build artifacts first):

```bash
dotnet clean -c Debug
dotnet build -c Debug
```

Or for Release:

```bash
dotnet clean -c Release
dotnet build -c Release
```

## Build Output

After a successful build, the output files will be located in the following directories:

### Debug Build Output

**Location:** `bin/Debug/net8.0-android/`

**Files Generated:**
- `SciChart.dll` - The compiled binding library (main output)
- `SciChart.pdb` - Debug symbols for debugging
- `SciChart.xml` - XML documentation (if available)
- All 7 `.aar` files (copied from project root)

### Release Build Output

**Location:** `bin/Release/net8.0-android/`

**Files Generated:**
- `SciChart.dll` - The compiled binding library (main output)
- `SciChart.pdb` - Release symbols
- `SciChart.xml` - XML documentation (if available)
- All 7 `.aar` files (copied from project root)

## Using the Binding Library

To use this binding library in your .NET Android application:

1. **Add a project reference** to this binding project in your application's `.csproj`:
   ```xml
   <ProjectReference Include="path/to/SciChart.csproj" />
   ```

2. **Or reference the compiled DLL** directly:
   ```xml
   <Reference Include="SciChart">
     <HintPath>path/to/bin/Debug/net8.0-android/SciChart.dll</HintPath>
   </Reference>
   ```

3. The `.aar` files will be automatically included when you reference the binding library.

## Project Structure

### Additions/

The `Additions/` folder contains C# partial classes and extensions that supplement the generated bindings. These files address binding generator limitations and provide:

- Interface adapters for Xamarin.Android compatibility
- Extension methods for improved API ergonomics
- Partial class implementations for missing or problematic generated code
- Generic collection helpers
- Type adapters for data series and calculators

See `ChangesSummary.md` for detailed information about what each addition file addresses.

### Transforms/

The `Transforms/` folder contains XML metadata files that customize the binding generation:

- **Metadata.xml** - Main metadata transformations that:
  - Relax abstract/final modifiers where needed
  - Map Java types to .NET types
  - Rename methods/properties for .NET conventions
  - Adjust method signatures for compatibility

- **EnumFields.xml** - Enum field mappings (if present)
- **EnumMethods.xml** - Enum method mappings (if present)

## Troubleshooting

### Build Errors

If you encounter build errors:

1. **Verify .aar files are present** - Ensure all 7 `.aar` files are in the project root directory
2. **Clean and rebuild** - Try `dotnet clean` followed by `dotnet build`
3. **Check .NET SDK version** - Ensure you're using .NET SDK 8.0 or later
4. **Verify Android SDK** - Ensure Android SDK is properly installed and configured

### Common Issues

- **Missing .aar files**: The build will fail if any of the required `.aar` files are missing from the project root
- **Binding errors**: If new binding errors appear after updating SciChart libraries, you may need to update `Transforms/Metadata.xml` or add new files to `Additions/`
