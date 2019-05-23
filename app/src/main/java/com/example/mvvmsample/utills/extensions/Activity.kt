package com.findmyfans.util.extension

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/*
 *
 */
internal fun <T : AppCompatActivity> AppCompatActivity.start(cls: Class<T>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

internal fun <T : AppCompatActivity> AppCompatActivity.start(cls: Class<T>, bundle: Bundle) {
    val intent = Intent(this, cls)
    intent.putExtra("bundle", bundle)
    startActivity(intent)
}

internal fun <T : AppCompatActivity> Fragment.start(cls: Class<T>) {
    val intent = Intent(context, cls)
    startActivity(intent)
}

internal fun <T : AppCompatActivity> Fragment.startWithFinish(cls: Class<T>) {
    val intent = Intent(context, cls)
    startActivity(intent)
    (context as AppCompatActivity).finish()
}

internal fun <T : AppCompatActivity> Fragment.start(cls: Class<T>, bundle: Bundle) {
    val intent = Intent(context, cls)
    intent.putExtra("bundle", bundle)
    startActivity(intent)
}



