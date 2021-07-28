package com.doye.finupdialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.doye.finupdialoglib.FinUpDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val test = findViewById<Button>(R.id.test)

        test.setOnClickListener {
            FinUpDialogBuilder()
                .setTitle("test")
                .setContentText("teastaetaet")
                .positiveButton("확인") {
                    Log.ERROR
                }
                .negativeButton("확인") {
                    Log.ERROR
                }
                .build()
                .show(supportFragmentManager,"normal")
        }
    }
}