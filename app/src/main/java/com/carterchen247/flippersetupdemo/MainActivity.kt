package com.carterchen247.flippersetupdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val disposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCallAPI.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val d = MyRepository.getDefaultApi()
            .subscribe({
                Log.d("tag", "response=${it.string()}")
            }, {
                Log.d("tag", "error")
            })
        disposable.add(d)
    }
}
