package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HistoriaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia)

        //Go back to Ecra Principal
        val anterior_hist = findViewById<ImageView>(R.id.btnAnterior_hist)
        anterior_hist.setOnClickListener(){
            val i = Intent(this@HistoriaActivity, EcraPrincipalActivity::class.java)
            startActivity(i)
        }
        ///////////////////////////
    }
}