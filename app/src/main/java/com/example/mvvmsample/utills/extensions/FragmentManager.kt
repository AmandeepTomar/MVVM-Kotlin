package com.example.mvvmsample.utills.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


internal fun FragmentManager.removeFragment(
    tag: String,
    slideIn: Int = android.R.anim.slide_in_left,
    slideOut: Int = android.R.anim.slide_out_right
) {
    this.findFragmentByTag(tag)?.let {
        this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(it)
            .commitNow()
    }
}

internal fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String,
    slideIn: Int = android.R.anim.slide_in_left,
    slideOut: Int = android.R.anim.slide_out_right
) {
    this.beginTransaction().disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .add(containerViewId, fragment, tag)
        .commit()
}

internal fun FragmentManager.replaceFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String
) {
    this.beginTransaction().disallowAddToBackStack()
        .replace(containerViewId, fragment, tag)
        .commit()

}

internal fun FragmentManager.replaceFragmentWithBack(
    containerViewId: Int,
    fragment: Fragment,
    tag: String
) {
    this.beginTransaction()
        .replace(containerViewId, fragment, tag)
        .addToBackStack(tag)
        .commit()

}




