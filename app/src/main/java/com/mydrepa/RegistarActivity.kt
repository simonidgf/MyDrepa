package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class RegistarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registar)

        //go from registar to login (without creating account)
        val anterior_regi = findViewById<ImageView>(R.id.btnAnterior)
        anterior_regi.setOnClickListener(){
            val i = Intent(this@RegistarActivity, MainActivity::class.java)
            startActivity(i)
        }
        ///////////////////////////

        //go from registar to login (creating account)
        val criar_conta = findViewById<ImageView>(R.id.btnRegistar)
        criar_conta.setOnClickListener(){
            val i = Intent(this@RegistarActivity, MainActivity::class.java)
            startActivity(i)
        }
        ///////////////////////////
    }
}
