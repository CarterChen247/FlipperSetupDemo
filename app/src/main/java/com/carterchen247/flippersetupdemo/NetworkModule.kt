package com.carterchen247.flippersetupdemo

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object NetworkModule {
    val networkFlipperPlugin by lazy { NetworkFlipperPlugin() }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .baseUrl("http://www.google.com")
            .build()
    }

    fun getOkHttpClient() = OkHttpClient.Builder()
        .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
        .build()
}
