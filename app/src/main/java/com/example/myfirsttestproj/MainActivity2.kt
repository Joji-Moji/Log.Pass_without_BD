package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.example.myfirsttestproj.Constance.Constance_key
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.databinding.ActivityMain2Binding
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn
import com.example.myfirsttestproj.Constance.Constance_key.keyState
import androidx.core.view.marginTop as viewMarginTop


class MainActivity2 : AppCompatActivity() {

    private lateinit var viewBanding2: ActivityMain2Binding
    private var SignState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBanding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBanding2.root)

        SignState = intent.getStringExtra("$keyState")!! // !! указывает что не будет null

        if (SignState == "$keySingIn") {
            viewBanding2.editName.visibility = View.GONE
            viewBanding2.editSurname.visibility = View.GONE
            viewBanding2.button2.visibility = View.INVISIBLE
        }

    }

    fun onClickSignIn(view: View) {
        if (SignState == "$keyRegister") {
           val intent = Intent()
            intent.putExtra(Constance_key.email, viewBanding2.editEMail.text.toString())
            intent.putExtra(Constance_key.password, viewBanding2.editPass.text.toString())
            intent.putExtra(Constance_key.name, viewBanding2.editName.text.toString())
            intent.putExtra(Constance_key.surname, viewBanding2.editSurname.text.toString())
            if (viewBanding2.imageView.isVisible)intent.putExtra(Constance_key.avatar_id,
                R.drawable.avatar) // т.к. картинку не выбираем поэтому прост берем  только если она видна
            setResult(RESULT_OK, intent)
            finish()
        } else if (SignState == "$keySingIn"){
            intent.putExtra(Constance_key.email, viewBanding2.editEMail.text.toString())
            intent.putExtra(Constance_key.password, viewBanding2.editPass.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatar (view: View){
        viewBanding2.imageView.visibility = View.VISIBLE
    }
}