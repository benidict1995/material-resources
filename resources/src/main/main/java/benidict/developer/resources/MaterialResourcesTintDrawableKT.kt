package benidict.developer.resources

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import java.lang.ref.WeakReference

class MaterialResourcesTintDrawableKT(context: Context) {

        companion object {

                    private lateinit var mContext : WeakReference<Context>

                    @ColorRes private var mColor : Int = 0

                    private var mDrawable: Drawable? = null

                    private var mWrappedDrawable: Drawable? = null

                    /**
                     * @param context - pass here the context of the class.
                     */
                    fun withContext(context: Context): MaterialResourcesTintDrawableKT = MaterialResourcesTintDrawableKT(context)


                    /**
                     * @param drawableRes - pass here the drawable resources id
                     */
                    fun withDrawable(@DrawableRes drawableRes: Int): MaterialResourcesTintDrawableKT.Companion {
                        val context: Context = mContext.get()!!
                        mDrawable = ContextCompat.getDrawable(context, drawableRes)

                        return this
                    }

                    /**
                     * @param drawable - pass here the drawable
                     */
                    fun withDrawable(drawable: Drawable): MaterialResourcesTintDrawableKT.Companion {

                        mDrawable = drawable

                        return this
                    }

                    /**
                     * @param colorRes - pass here the color id you want to use.
                     */
                    @SuppressLint("ResourceAsColor")
                    fun withColor(@ColorRes colorRes: Int): MaterialResourcesTintDrawableKT.Companion {
                        val context: Context = mContext.get()!!
                        mColor = ContextCompat.getColor(context, colorRes)

                        return this
                    }

                    @SuppressLint("ResourceAsColor")
                    fun tint(): MaterialResourcesTintDrawableKT.Companion {

                        if (mDrawable == null) throw NullPointerException("\n" + "You must enter the color to be defined by the method withDrawable()")

                        if (mColor == 0) throw IllegalStateException("\n" + "You must enter the color to be defined by the method withColor()")

                        mWrappedDrawable = mDrawable?.mutate()
                        mWrappedDrawable = DrawableCompat.wrap(mWrappedDrawable!!)
                        DrawableCompat.setTint(mWrappedDrawable!!, mColor)
                        DrawableCompat.setTintMode(mWrappedDrawable!!, PorterDuff.Mode.SRC_IN)

                        return this
                    }

                    @SuppressLint("ObsoleteSdkInt")
                    @Deprecated("")
                    fun applyToBackground(view: View) {

                        if (mWrappedDrawable == null) throw NullPointerException("\n" + "You must call the method tint()")

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) view.background = mWrappedDrawable else view.setBackgroundDrawable(mWrappedDrawable)

                    }

                    /**
                     * @param imageView - pass here the image view component that you will use.
                     */
                    fun applyTo(imageView: ImageView) {

                        if (mWrappedDrawable == null) throw NullPointerException("You must call the method tint()")

                        imageView.setImageDrawable(mWrappedDrawable)

                    }

                    fun applyTo(menuItem: MenuItem) {

                        if (mWrappedDrawable == null) throw NullPointerException("You must call the method tint()")

                        menuItem.icon = mWrappedDrawable

                    }

                    /**
                     * get the drawable
                     */
                    fun get(): Drawable {

                        if (mWrappedDrawable == null) throw NullPointerException("You must call the method tint()")

                        return mWrappedDrawable!!

                    }

        }


}