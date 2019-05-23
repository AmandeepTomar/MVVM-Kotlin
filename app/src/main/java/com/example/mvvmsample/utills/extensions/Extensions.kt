package com.marutidrivingschool.utility.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.marutidrivingschool.callback.CustomAlertDialogListener
import com.marutidrivingschool.views.alert_dialogs.CustomAlertDialog
import com.marutidrivingschool.views.alert_dialogs.CustomFileChooserDialog
import com.marutidrivingschool.views.alert_dialogs.CustomPermissionAlertDialog
import java.text.SimpleDateFormat
import java.util.*

fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun AppCompatActivity.hideKeyboard() {
    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun String.formatDate(millis: Long): String = SimpleDateFormat(this, Locale.US).apply {
    timeZone = TimeZone.getTimeZone("UTC")
}.format(millis)


internal fun AppCompatActivity.showAlertDialog(
    place: String,
    heading: String,
    subHeading: String,
    isCancle: Boolean
) {

    val customDialog = CustomAlertDialog.newInstance(place, heading, subHeading)
    customDialog.isCancelable = isCancle
    customDialog.show(supportFragmentManager, "alertDialog")

}


internal fun Fragment.showAlertDialog(
    place: String,
    heading: String,
    subHeading: String,
    isCancle: Boolean

) {
    val customDialog = CustomAlertDialog.newInstance(place, heading, subHeading)
    customDialog.isCancelable = isCancle
    customDialog.show(activity!!.supportFragmentManager, "alertDialog")

}

internal fun AppCompatActivity.showCustomFileChooser(
    place: String,
    isCancel: Boolean
) {
    val customDialog = CustomFileChooserDialog()
    customDialog.isCancelable = isCancel
    customDialog.show(supportFragmentManager, "fileChooser")

}


internal fun Fragment.showCustomFileChooser(
    place: String,
    isCancel: Boolean

) {
    val customDialog = CustomFileChooserDialog()
    customDialog.isCancelable = isCancel
    customDialog.show(activity!!.supportFragmentManager, "fileChooser")

}

internal fun AppCompatActivity.showCustomSettings(
    place: String,
    message: String,
    subMessage: String,
    isCancel: Boolean
) {
    val customDialog = CustomPermissionAlertDialog.newInstance(place, message, subMessage)
    customDialog.isCancelable = isCancel
    customDialog.show(supportFragmentManager, "showSettings")

}


internal fun Fragment.showCustomSettings(
    place: String,
    message: String,
    subMessage: String,
    isCancel: Boolean

) {
    val customDialog = CustomPermissionAlertDialog.newInstance(place, message, subMessage)
    customDialog.isCancelable = isCancel
    customDialog.show(activity!!.supportFragmentManager, "showSettings")

}

