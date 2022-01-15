package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn
import com.example.myfirsttestproj.Constance.Constance_key.keyStateSignIn
import com.example.myfirsttestproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var name = "empty"
    private var surname = "empty"
    private var email = "empty"
    private var password = "empty"
    private var avatarImageId = 0 // нужно для получения картинки, в папке drawble получаем числа поэтому Int


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
                Log.d("Log", "Nice")

            }
        }

        launcherRegister = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){// регистрирует
            result : ActivityResult ->
            if (result.resultCode == RESULT_OK){//если всё окей то получит результат
                val text = result.data?.getStringExtra("$keyRegister")
                Log.d("Log", "Good")
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