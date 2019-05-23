package com.findmyfans.util.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.marutidrivingschool.R


/**
 * Created by Bhuvnesh on 18/07/18.
 */
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

internal fun FragmentManager.replaceFragmentWithTransition(
    containerViewId: Int,
    fragment: Fragment,
    tag: String
) {
    this.beginTransaction().disallowAddToBackStack()
        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
        .replace(containerViewId, fragment, tag)
        .commit()

}

internal fun FragmentManager.replaceFragmentWithBackStack(
    containerViewId: Int,
    fragment: Fragment,
    tag: String
) {
    this.beginTransaction()
        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
        .replace(containerViewId, fragment, tag)
        .addToBackStack(tag)
        .commit()

}


internal fun FragmentManager.replaceWithSharedElement(
    containerViewId: Int,
    fragment: Fragment,
    tag: String,
    sharedview: View,
    sharedElementName: String
) {
    this.beginTransaction()
        .addSharedElement(sharedview, sharedElementName)
        .replace(containerViewId, fragment, tag)
        .addToBackStack(tag)
        .commit()

}



