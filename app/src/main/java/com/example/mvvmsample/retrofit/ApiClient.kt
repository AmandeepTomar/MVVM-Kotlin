package com.example.mvvmsample.retrofit

import com.example.mvvmsample.utills.AppConstant.Companion.BASE_URL
import com.example.mvvmsample.view.dashboardview.apiinterface.DashboardApiInterface
import com.example.mvvmsample.view.loginview.apiinterface.LoginApiInterface
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    /**Return OkHttpClient with some additional interceptor
     * @return
     * */
    private val provideOkHttpClient by lazy {
        OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor { chain ->
                return@addInterceptor chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build()
                )
            }.build()
    }

    /**Return Retrofit client with base url , JSON parsing converter and coroutine adapter.
     * @return
     * */
    private val provideRetrofitClient: Retrofit by lazy {
        Retrofit.Builder().client(provideOkHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    /**Return the instance of LoginApiInterface that have all the method to hit api
     * @return
     * */
    val loginApiInterface:LoginApiInterface by lazy {
        provideRetrofitClient.create(LoginApiInterface::class.java)
    }
    /**Return the instance of DashboardApiInterface that have all the method to hit api
     * @return
     * */
    val dashboardApiInterface:DashboardApiInterface by lazy {
        provideRetrofitClient.create(DashboardApiInterface::class.java)
    }

}