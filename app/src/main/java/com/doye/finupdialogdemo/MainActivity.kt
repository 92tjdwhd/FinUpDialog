package com.doye.finupdialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.doye.finupdialoglib.FinUpDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val test = findViewById<Button>(R.id.test)

        test.setOnClickListener {
            FinUpDialogBuilder()
                .setContentText("Content")
                .setContentTextAlignment(View.TEXT_ALIGNMENT_TEXT_END)
                .positiveButton("확인") {

                }
                .negativeButton("취소"){

                }
                .build()
                .show(supportFragmentManager,"normal")
        }
    }
}