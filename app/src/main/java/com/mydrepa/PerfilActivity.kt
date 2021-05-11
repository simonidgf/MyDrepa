package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        //Go back
        val anterior_perfil = findViewById<ImageView>(R.id.btnAnterior_perfil)
        anterior_perfil.setOnClickListener(){
            val i = Intent(this@PerfilActivity, EcraPrincipalActivity::class.java)
            startActivity(i)
        }
        ///////////
    }
}