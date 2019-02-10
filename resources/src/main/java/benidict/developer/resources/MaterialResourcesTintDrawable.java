package benidict.developer.resources;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;


@SuppressWarnings("WeakerAccess")
public class MaterialResourcesTintDrawable {

    @NonNull
    Context mContext;
    @ColorRes
    private int mColor;
    private Drawable mDrawable;
    private Drawable mWrappedDrawable;

    public MaterialResourcesTintDrawable(@NonNull Context context){
        this.mContext = context;
    }

    /**
     * @param context - pass here the context of the class.
     */
    public static MaterialResourcesTintDrawable withContext(@NonNull Context context){
        return new MaterialResourcesTintDrawable(context);
    }

    /**
     * @param drawableRes - pass here the drawable resources id
     */
    public MaterialResourcesTintDrawable withDrawable(@DrawableRes int drawableRes){
        mDrawable = ContextCompat.getDrawable(mContext, drawableRes);
        return this;
    }

    /**
     * @param drawable - pass here the drawable
     */
    public MaterialResourcesTintDrawable withDrawable(@NonNull Drawable drawable) {
        mDrawable = drawable;
        return this;
    }

    /**
     * @param colorRes - pass here the color id you want to use.
     */
    @SuppressLint("ResourceAsColor")
    public MaterialResourcesTintDrawable withColor(@ColorRes int colorRes) {
        mColor = ContextCompat.getColor(mContext, colorRes);
        return this;
    }


    @SuppressLint("ResourceAsColor")
    public MaterialResourcesTintDrawable tint(){
        if (mDrawable == null) {
            throw new NullPointerException("\n" +
                    "You must enter the color to be defined by the method withDrawable()");
        }

        if (mColor == 0) {
            throw new IllegalStateException("\n" +
                    "You must enter the color to be defined by the method withColor()");
        }

        mWrappedDrawable = mDrawable.mutate();
        mWrappedDrawable = DrawableCompat.wrap(mWrappedDrawable);
        DrawableCompat.setTint(mWrappedDrawable, mColor);
        DrawableCompat.setTintMode(mWrappedDrawable, PorterDuff.Mode.SRC_IN);

        return this;
    }

    @SuppressLint("ObsoleteSdkInt")
    @Deprecated
    public void applyToBackground(@NonNull View view){
        if (mWrappedDrawable == null){
            throw new NullPointerException("\n" +
                    "You must call the method tint()");
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(mWrappedDrawable);
        } else {

            view.setBackgroundDrawable(mWrappedDrawable);
        }
    }

    /**
     * @param imageView - pass here the image view component that you will use.
     */
    public void applyTo(@NonNull ImageView imageView) {
        if (mWrappedDrawable == null) {
            throw new NullPointerException("You must call the method tint()");
        }

        imageView.setImageDrawable(mWrappedDrawable);
    }

    public void applyTo(@NonNull MenuItem menuItem) {
        if (mWrappedDrawable == null) {
            throw new NullPointerException("You must call the method tint()");
        }

        menuItem.setIcon(mWrappedDrawable);
    }

    /**
     * get the drawable
     */
    public Drawable get() {
        if (mWrappedDrawable == null) {
            throw new NullPointerException("You must call the method tint()");
        }

        return mWrappedDrawable;
    }
}