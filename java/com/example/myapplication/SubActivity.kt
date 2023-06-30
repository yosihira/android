package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

//        var getText = findViewById<TextView>(R.id.get_text)
//        val intentText = intent.getStringExtra("INPUT_TEXT")
//
//        var getText2 = findViewById<TextView>(R.id.get_text2)
//        val intentText2 = intent.getStringExtra("INPUT_TEXT2")
//
//        getText.text = intentText
//        getText2.text = intentText2


        val returnButton = findViewById<Button>(R.id.button3)
        returnButton.setOnClickListener {
            finish()
        }

            val returnButton2 = findViewById<Button>(R.id.button2)
            returnButton2.setOnClickListener{
                val intent = Intent(this, Kozinchat::class.java)
                startActivity(intent)

        }
    }


}