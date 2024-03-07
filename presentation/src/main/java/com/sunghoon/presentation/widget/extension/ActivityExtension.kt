package com.sunghoon.presentation.widget.extension

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

//Activity Intent
fun AppCompatActivity.startActivityAndFinish(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    this.finish()
}