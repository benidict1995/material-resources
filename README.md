# Material Resources

[![](https://jitpack.io/v/benidict1995/material-resources.svg)](https://jitpack.io/#benidict1995/material-resources) **|**  [Report issue here](https://github.com/benidict1995/material-resources/issues).

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
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency.

```gradle
dependencies {
		implementation 'com.github.benidict1995:material-resources:1.1.1’
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

## Values
Resources covered by this library.

* Color
* Vector Icon
* Density Independent Pixel
* Scale Independent Pixel

| Resources        | Values           |
| ------------- |:-------------:|
| color      | @color/material_resources_white_hex_FFFFFF |
| icon      | @drawable/material_resources_ic_star_default_24dp      |
| dimen (dp) | @dimen/material_resources_margin_10dp      |
| dimen (sp) | @dimen/material_resources_text_size_16sp      |


## How do I use Tint Drawable Helper?

Simple use case will look something like this:

Create helper object.

```kotlin
object ImageHelper{

fun imageTintChanger(context: Context, img: ImageView, 	drawable : Int, color : Int) : Unit =
            MaterialResourcesTintDrawable
                    .withContext(context)
                    .withColor(color)
                    .withDrawable(drawable)
                    .tint()
                    .applyTo(img)
}
```

in Activity:

```kotlin
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        	ImageLoader.imageTintChanger(context!!, imageView ,R.drawable.material_resources_ic_star_default_24dp , R.color.material_resources_yellow_400_hex_FFEE58
)

    }

}
```	

## MaterialResourcesTintDrawable

| Function        | Description           |
| ------------- |:-------------:|
| withContext      | Pass the context of current class. |
| withColor      | Pass the color that will tint.      |
| withDrawable | Image or Icon that want to change tint.     |
| tint | Call this to process the tint.   |
| applyToBackground | Pass the view and this will be change the background of the icon or image.  |
| applyTo | Pass the component that you used **eg. ImageView, MenuItem.**    |
