
package com.roquebuarque.cpynpasta.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    inline fun <reified T> createNetworkService(): T {

        val log = HttpLoggingInterceptor()
        log.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient
            .Builder()
            .addInterceptor { chain ->

                val originalRequest = chain.request()
                val originalUrl = originalRequest.url
                val newUrl = originalUrl.newBuilder()
                    .build()

                val newRequest = originalRequest.newBuilder().url(newUrl).build()

                chain.proceed(
                    newRequest
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build()
                )
            }

            .addInterceptor(log)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(T::class.java)
    }
}