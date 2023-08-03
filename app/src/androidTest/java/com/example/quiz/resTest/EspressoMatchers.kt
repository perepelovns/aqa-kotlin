package com.example.quiz.resTest

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher


object EspressoMatchers {

    fun withWrapContent(): Matcher<View> {
        return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("ImageView with wrap_content width and height")
            }

            override fun matchesSafely(imageView: ImageView): Boolean {
                val params = imageView.layoutParams
                return params.width == ViewGroup.LayoutParams.WRAP_CONTENT && params.height == ViewGroup.LayoutParams.WRAP_CONTENT
            }
        }
    }

    fun isCentered(): Matcher<View> {
        return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("ImageView is centered")
            }

            override fun matchesSafely(imageView: ImageView): Boolean {
                val params = imageView.layoutParams as? ViewGroup.MarginLayoutParams ?: return false

                val horizontalCenter = imageView.left + imageView.width / 2
                val verticalCenter = imageView.top + imageView.height / 2

                val parent = imageView.parent as? View
                val parentWidth = parent?.width ?: 0
                val parentHeight = parent?.height ?: 0

                val parentHorizontalCenter = parentWidth / 2
                val parentVerticalCenter = parentHeight / 2

                return horizontalCenter == parentHorizontalCenter && verticalCenter == parentVerticalCenter
            }
        }
    }
}
