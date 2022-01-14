package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val signIn = intent.getBooleanExtra("$keySingIn", true)
        val register = intent.getBooleanExtra("$keyRegister", true)
        when(signIn){
            true -> viewBanding2.layoutSignIn.visibility = View.VISIBLE
        }
        when (register){
            true -> viewBanding2.layoutRegister.visibility = View.VISIBLE
        }


    }

    fun onClickSignIn(view: View){
        Intent().putExtra("$keySingIn", "")
        setResult(RESULT_OK, Intent())
        finish()

    }fun onClickRegister(view: View){
        Intent().putExtra("$keyRegister", "")
        setResult(RESULT_OK, Intent())
        finish()
    }
}