package com.carterchen247.flippersetupdemo

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface MyService {

    @GET
    fun getDefaultApi(@Url url: String): Single<ResponseBody>
}
