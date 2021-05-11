package com.mydrepa

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DiarioActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diario)

        //Go back to painel principal
        val anterior_d = findViewById<ImageView>(R.id.btnAnterior_diario)
        anterior_d.setOnClickListener(){
            val i = Intent(this@DiarioActivity, EcraPrincipalActivity::class.java)
            startActivity(i)
        }
        /////////////////////////////

        //Date managing
        val dia = findViewById<EditText>(R.id.txtDia_diario)
        val mes = findViewById<EditText>(R.id.txtMes_diario)
        val ano = findViewById<EditText>(R.id.txtAno_diario)

        //////////////
    }
}