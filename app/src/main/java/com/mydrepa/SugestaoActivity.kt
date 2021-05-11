package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SugestaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugestao)

        //Thankssssssss
        val obrigado = findViewById<ImageView>(R.id.btnObrigado)
        obrigado.setOnClickListener(){
            startActivity(Intent(this@SugestaoActivity, EcraPrincipalActivity::class.java))
        }
        ///////////////
    }
}