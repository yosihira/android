//package com.example.myapplication
//
//import okhttp3.*
//import okhttp3.logging.HttpLoggingInterceptor
//
//import java.io.IOException
//
//class ApiClient {
//    private val client: OkHttpClient
//
//    init {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        client = OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            .build()
//    }
//
//    fun executeRequest(url: String, requestBody: RequestBody, callback: Callback) {
//        val request = Request.Builder()
//            .url(url)
//            .post(requestBody)
//            .build()
//
//        client.newCall(request).enqueue(callback)
//    }
//}
