package com.example.myapplication


//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import androidx.appcompat.app.AppCompatActivity
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import okhttp3.*
//import java.io.IOException
//class MainActivity : AppCompatActivity() {
//    private lateinit var editText: EditText
//    private lateinit var sendButton: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        editText = findViewById(R.id.textView2)
//        sendButton = findViewById(R.id.textView3)
//
//        sendButton.setOnClickListener {
//            val message = editText.text.toString()
//            // メッセージを送信する処理を実装する
//        }
//    }
//}

//
//class MainActivity : AppCompatActivity() {
//    private val client = OkHttpClient()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val editText = findViewById<EditText>(R.id.textView2)
//        val inputText = editText.text.toString()
//
//        val url = "http://api/endpoint"
//        val requestBody = FormBody.Builder().add("inputValue", inputText).build()//フォームデータを構築
//
//        val request = Request.Builder()
//            .url(url)
//            .post(requestBody)
//            .build()//メゾットを呼び出しリクエストオブジェクトを完成させます。
//
//        val nextButton = findViewById<Button>(R.id.button)
//        nextButton.setOnClickListener {
//            GlobalScope.launch(Dispatchers.IO) {//非同期タスクを開始
//                try {
//                    val response = client.newCall(request).execute()//オブジェクト使用し手HTTPリクエストを実行し、レスポンスを取得、このコードは同期的に実行されます。
//                    if (response.isSuccessful) {//HTTPリクエストが成功したかどうかをチェックする。”response.isSuccessful”は、ステータスコードが成功の範囲にあるかどうか確認。
//                        // レスポンスの処理（成功時）
//                        val responseBody = response.body?.string()//レスポンスのボディを文字列に取得
//                        Log.d("MainActivity", "レスポンス: $responseBody")//ログにレスポンスの内容を表示
//                    } else {
//                        // レスポンスの処理（エラー時）
//                        Log.e("MainActivity", "リクエストが失敗しました。")//リクエストが成功しなっかた場合にエラーログを表示する。
//                    }
//                } catch (e: IOException) {//通信エラーが発生した場合例外をキャッチし、エラーログを表示します。
//                    // 通信エラーの処理
//                    e.printStackTrace()
//
//
//                    //非同期タスクとは、プログラム内で実行されるタスクや処理のことをさします。他に処理と同時に実行され、待機せずに結果を取得したり、他の処理をおこなうことができます。
//                    //
//                }
//            }
//        }
//    }
//}


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.FormBody
import java.io.IOException



class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.textView2)
        var inputText = editText.text.toString()

        val url = "http://localhost:8080/api/kozin"
        val client = OkHttpClient()
        val requestBody = FormBody.Builder()
            .add("inputValue", inputText)
            .build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        val nextButton = findViewById<Button>(R.id.button)
        nextButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = client.newCall(request).execute()
                    if (response.isSuccessful) {
                        val responseBody = response.body?.string()
                        Log.d("MainActivity", "レスポンス: $responseBody")
                    } else {
                        Log.e("MainActivity", "リクエストが失敗しました。")
                    }
                } catch (e: IOException) {
                    Log.e("MainActivity", "通信が失敗しました。")
                    e.printStackTrace()
                }
            }
//レスポンス：反応や応答と言ってこと
//
//        var editText = findViewById<EditText>(R.id.textView2)
//        var inputText = editText.text
//
        var editText2 = findViewById<EditText>(R.id.textView3)
        var inputText2 = editText2.text
//
        val nextButton = findViewById<Button>(R.id.button)

        nextButton.setOnClickListener {
            if (inputText != null || inputText2 != null) {//editTextの中に何か入っている場合中身を実行
                val intent = Intent(this, SubActivity::class.java)//subActivityに移動
                val intent2 = Intent(this, SubActivity::class.java)
                intent.putExtra("INPUT_TEXT", inputText.toString())
                intent.putExtra("INPUT_TEXT2", inputText2.toString())//キーの値を文字列に変換
                startActivity(intent)//別のアクティビティを開始するため（今回の場合subActivity)

                if (inputText2 != null) {//editTextの中に何か入っている場合中身を実行
                    val intent2 = Intent(this, SubActivity::class.java)//subActivityに移
                    intent.putExtra("INPUT_TEXT2", inputText2.toString())//キーの値を文字列に変換
                    startActivity(intent)//別のアクティビティを開始するため（今回の場合subActivity)


                }
            }
        }
    }
}
}

//        val btnIntent = findViewById<Button>(R.id.button)
//        btnIntent.setOnClickListener (object : View.OnClickListener {
//            override fun  onClick(v: View?){
//                val intent = Intent(this@MainActivity,SubActivity::class.java)
//
//                startActivity(intent)

//import android.annotation.SuppressLint
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import android.os.AsyncTask
//import android.util.Log
//import okhttp3.FormBody
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import okhttp3.RequestBody
//import java.io.IOException
//
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    private val apiUrl = "http://your-spring-boot-app/api/endpoint"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
////        var inputText = editText.text
//        // 送信するデータを取得
//        var editText = findViewById<EditText>(R.id.textView2)
//        val inputValue = editText.text.toString()
//
//        // リクエストの作成
//        val client = OkHttpClient()
//        val requestBody: RequestBody = FormBody.Builder()
//            .add("inputValue", inputValue)
//            .build()
//        val request: Request = Request.Builder()
//            .url(apiUrl)
//            .post(requestBody)
//            .build()
//
//        // リクエストの非同期実行
//        SendChatTask().execute(request)
//    }
//
//    private inner class SendChatTask : AsyncTask<Request, Void, String>() {
//        override fun doInBackground(vararg requests: Request): String {
//            val client = OkHttpClient()
//            val request = requests[0]
//
//            try {
//                val response = client.newCall(request).execute()
//                if (response.isSuccessful) {
//                    // レスポンスの処理（成功時）
//                    return response.body?.string() ?: "Empty response body"
//                } else {
//                    // レスポンスの処理（エラー時）
//                    return "Request failed"
//                }
//            } catch (e: IOException) {
//                // 通信エラーの処理
//                e.printStackTrace()
//                return "Communication error"
//            }
//        }
//
//        override fun onPostExecute(result: String) {
//            Log.d(TAG, "Response: $result")
//            // レスポンスの表示や処理を行う場合はここで行う
//        }
//    }
//}










