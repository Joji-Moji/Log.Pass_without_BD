package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.databinding.ActivityMain2Binding
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn



class MainActivity2 : AppCompatActivity() {

    private lateinit var  viewBanding2: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBanding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBanding2.root)
        val SignIn = intent.getStringExtra("$keySingIn").toString()
        val Register = intent.getStringExtra("$keyRegister")
        if(SignIn != null){
            Log.d("Log", "rabotaet!!")
        }

    }

    fun onClickSignIn(view: View){
        Intent().putExtra("$keySingIn", "")
        setResult(RESULT_OK, Intent())
        finish()
        Intent().putExtra("$keyRegister", "")
        setResult(RESULT_OK, Intent())
        finish()

    }

}