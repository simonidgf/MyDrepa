package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DorRegistoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dor_registo)

        //Go back to Ecra Principal
        val anterior_dor = findViewById<ImageView>(R.id.btnAnterior_dor)
        anterior_dor.setOnClickListener(){
            val i = Intent(this@DorRegistoActivity, EcraPrincipalActivity::class.java)
            startActivity(i)
        }
        ///////////////////////////

        //Registar
        val registar = findViewById<ImageView>(R.id.btnRegistarDor)
        registar.setOnClickListener(){
            startActivity(Intent(this@DorRegistoActivity, SugestaoActivity::class.java))
        }
        //////////
    }
}