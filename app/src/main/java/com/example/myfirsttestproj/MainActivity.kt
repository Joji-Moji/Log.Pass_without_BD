package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn
import com.example.myfirsttestproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var viewBinding: ActivityMainBinding

private var launcherLogin: ActivityResultLauncher<Intent>? = null //создаем коллбэк и даем ему пустой нулл
private var launcherRegister: ActivityResultLauncher<Intent>? = null //создаем коллбэк и даем ему пустой нулл

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        launcherLogin = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {// регистрирует
                result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {//если всё окей то получит результат
                val text = result.data?.getStringExtra("$keySingIn")
            }
        }

        launcherRegister = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){// регистрирует
            result : ActivityResult ->
            if (result.resultCode == RESULT_OK){//если всё окей то получит результат
                val text = result.data?.getStringExtra("$keyRegister")
            }
        }

    }

    fun onClickSignIn (view: View){
        launcherLogin?.launch(Intent(this, MainActivity2::class.java))

    }

    fun onClickRegister (view: View){
        launcherRegister?.launch(Intent(this, MainActivity2::class.java))

    }
}