# Description
This library allows the developer to easily add design to the application buttons.

# Example

![IMG-20240714-WA0033](https://github.com/user-attachments/assets/023885e5-0c71-41ec-9261-7cea6a2afbbc)


## Installation

Add the following to the `settings.gradle`:
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Add this dependency to your dependencies in the app `build.gradle`:

```groovy
dependencies {
      implementation 'com.github.adamozeri:CustomButtons-HW2:v1.0.3'
}
```

# How To Use
Create a `CustomButton` 
```
 <com.example.buttonslibrary.CustomButton/>
```
You can add the following attributes to the `CustomButton`:
### Gradient
```
app:gradient="true"
app:gradientEnd="#f0f011"
app:gradientStart="#00ffaa"
```

### Outline
```
app:outline="true"
```

### Round corners
```
app:rounded="40dp"
```

## Contributing

If you have any suggestions or find any bugs, please feel free to open an issue or submit a pull request. Contributions are always welcome!
