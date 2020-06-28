package com.example.pokedex.view.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View

//TODO change to XML file with animation
class ZoomCloseFarAnimator :ZoomAnimator {

    override fun zoom(view: View) {
        animateScales(view).start()
    }

    private fun animateScales(view: View): AnimatorSet {
        val set = AnimatorSet()
        set.playTogether(animateScaleX(view), animateScaleY(view))
        return set
    }

    private fun animateScaleX(view: View): ObjectAnimator = animateProperty(
        view, "scaleX", 1f, 1.3f, 1200
    )

    private fun animateScaleY(view: View): ObjectAnimator = animateProperty(
        view, "scaleY", 1f, 1.1f, 1200
    )

    private fun animateProperty(
        view: View,
        property: String,
        startValue: Float,
        stopValue: Float,
        duration: Long
    ): ObjectAnimator {
        val anim: ObjectAnimator = ObjectAnimator
            .ofFloat(view, property, startValue, stopValue)
        anim.duration = duration
//        anim.interpolator = AccelerateDecelerateInterpolator()
        anim.repeatMode = ValueAnimator.REVERSE
        anim.repeatCount = ValueAnimator.INFINITE
        return anim
    }
}