# Material Resources

[![](https://jitpack.io/v/benidict1995/material-resources.svg)](https://jitpack.io/#benidict1995/material-resources) **|**  [Report issue here.](https://github.com/benidict1995/material-resources/issues). 

All resources defined and generated for android. this library will help you to 
organized your resources, also it might help you to develop faster since you
will do a less declaration to your resources.

# Download

You can download a jar from Github’s [releases page](https://github.com/benidict1995/material-resources/releases).

Or use Gradle:

To get a Git project into your build:
**Step 1.** Add the JitPack repository to your build file.

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2. ** Add the dependency.

```gradle
dependencies {
		implementation 'com.github.benidict1995:material-resources:1.1.0'
	}
```

Or Maven:

```maven
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
<dependency>
	 <groupId>com.github.benidict1995</groupId>
	 <artifactId>material-resources</artifactId>
	 <version>Tag</version>
</dependency>
```

## Values:
Resources covered by this library.

* Color
* Vector Icon
* Density Independent Pixel
* Scale Independent Pixel
