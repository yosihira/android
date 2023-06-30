package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView

class Kozinchat : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var scrollView: ScrollView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kozinchat)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        scrollView = findViewById(R.id.scrollView)
        textView = findViewById(R.id.textView)

            val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            scrollView.getWindowVisibleDisplayFrame(rect)
            val screenHeight = scrollView.rootView.height

            // キーボードが表示されているか判定
            val keypadHeight = screenHeight - rect.bottom
            if (keypadHeight > screenHeight * 0.15) {
                // キーボードが表示されている場合、スクロールしてテキスト入力欄が見えるようにする
                scrollView.postDelayed({
                    scrollView.smoothScrollTo(0, scrollView.bottom)
                }, 200)
            }


        // リスナーを追加
//        scrollView.viewTreeObserver.addOnGlobalLayoutListener(listener)
    }


        button.setOnClickListener {
            val newText = editText.text.toString()
            val currentText = textView.text.toString()

            val updatedText = "$currentText\n$newText"

            textView.text = updatedText
            editText.text.clear()

            // 自動スクロール
            scrollView.post {
                scrollView.fullScroll(View.FOCUS_DOWN)
            }
        }
    }
}

