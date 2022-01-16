package com.example.myfirsttestproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myfirsttestproj.Constance.Constance_key
import com.example.myfirsttestproj.Constance.Constance_key.keyRegister
import com.example.myfirsttestproj.Constance.Constance_key.keySingIn
import com.example.myfirsttestproj.Constance.Constance_key.keyState
import com.example.myfirsttestproj.Constance.Constance_key.request_code_in
import com.example.myfirsttestproj.Constance.Constance_key.request_code_reg
import com.example.myfirsttestproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var name = "empty"
    private var surname = "empty"
    private var email = "empty"
    private var password = "empty"
    private var avatarImageId = 0 // нужно для получения картинки, в папке drawble получаем числа поэтому Int


private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == request_code_in){
            // делаем проверку на вход
            val i = data?.getStringExtra(Constance_key.email)//берем данные из Intent
            val p = data?.getStringExtra(Constance_key.password)
            if (email == i && password == p){
                // если совпадает то
                viewBinding.avatar.visibility = View.VISIBLE
                viewBinding.avatar.setImageResource(avatarImageId)
                viewBinding.textInfo.text = "$name $surname"
                // прячем одну кнопку
                viewBinding.buttonRegister.visibility = View.INVISIBLE
                viewBinding.buttonSignIn.text = "logout"

            } else { //если нет то
                viewBinding.avatar.visibility = View.VISIBLE
                viewBinding.avatar.setImageResource(R.drawable.avatar1)
                viewBinding.textInfo.text = "Неправильный логин или пароль"
            }


        } else if(requestCode == request_code_reg){ // условие для регистрации

            email = data?.getStringExtra(Constance_key.email)!!
            password = data.getStringExtra(Constance_key.password)!!
            name = data.getStringExtra(Constance_key.name)!!
            surname = data.getStringExtra(Constance_key.surname)!!

            avatarImageId = data.getIntExtra(Constance_key.avatar_id, 0)
            viewBinding.avatar.visibility = View.VISIBLE
            viewBinding.avatar.setImageResource(avatarImageId)
            viewBinding.textInfo.text = "$name $surname"

            // прячем 1 кнопку
            viewBinding.buttonRegister.visibility = View.INVISIBLE
            viewBinding.buttonSignIn.text = "logout"
        }
    }

    fun onClickSignIn (view: View){
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("$keyState","$keySingIn" )
        startActivityForResult(intent, Constance_key.request_code_in)

    }

    fun onClickRegister (view: View){
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("$keyState","$keyRegister" )
        startActivityForResult(intent, Constance_key.request_code_reg)

    }
}