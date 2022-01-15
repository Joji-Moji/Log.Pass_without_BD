package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myfirsttestproj.Constance.Constance
import com.example.myfirsttestproj.Constance.Constance_key
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.databinding.ActivityMain2Binding
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn
import com.example.myfirsttestproj.Constance.Constance_key.keyStateSignIn


class MainActivity2 : AppCompatActivity() {

    private lateinit var  viewBanding2: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBanding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBanding2.root)

    }

    fun OnClickFinish(view: View){
        setResult(RESULT_OK, Intent().putExtra("$keySingIn", viewBanding2.editName.text))
        finish()
    }
}
