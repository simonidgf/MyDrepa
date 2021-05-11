package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Go from login to registar
        val nao_conta = findViewById<TextView>(R.id.lblNãoconta)
        nao_conta.setOnClickListener(){
            val i  = Intent(this@MainActivity, RegistarActivity::class.java)
            startActivity(i)
        }
        ///////////////////////////

        //Logar user
        val entrar = findViewById<ImageView>(R.id.btnEntrar)
        entrar.setOnClickListener(){
            val i = Intent(this@MainActivity, EcraPrincipalActivity::class.java)
            startActivity(i)
        }
        ////////////
    }
}