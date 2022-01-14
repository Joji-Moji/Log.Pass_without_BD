package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirsttestproj.Constance.Constance_key
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.databinding.ActivityMain2Binding
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn
import com.example.myfirsttestproj.Constance.Constance_key.keyState


class MainActivity2 : AppCompatActivity() {

    private lateinit var  viewBanding2: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBanding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBanding2.root)
        var signIn = intent.getStringExtra("$keySingIn")
        val register = intent.getStringExtra("$keyRegister")


    }

    fun onClickSignIn(view: View){
        Intent().putExtra("$keySingIn", "")
        setResult(RESULT_OK, Intent())
        finish()

    }
    fun onClickAvatar(view: View){
        viewBanding2.imageView.visibility = View.VISIBLE
    }
}