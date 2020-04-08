package com.carterchen247.flippersetupdemo

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

object MyRepository {

    fun getDefaultApi(): Single<ResponseBody> {
        return NetworkModule.retrofit
            .create(MyService::class.java)
            .getDefaultApi("http://www.google.com")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
