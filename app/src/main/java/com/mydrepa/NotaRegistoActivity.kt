package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class NotaRegistoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_registo)

        //Go back to ecra principal
        val anterior_nota = findViewById<ImageView>(R.id.btnAnterior_nota)
        anterior_nota.setOnClickListener(){
            val i = Intent(this@NotaRegistoActivity, EcraPrincipalActivity::class.java)
            startActivity(i)
        }
        ///////////////////////////
    }
}