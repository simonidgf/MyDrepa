package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.mydrepa.db_registar.RegistarEntity
import com.mydrepa.db_registar.RegistoViewModel

class RegistarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registar)

        lateinit var viewModel: RegistoViewModel

        viewModel = ViewModelProviders.of(this).get(RegistoViewModel::class.java)


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
            val nm = findViewById<EditText>(R.id.txtName).text.toString()
            val apl = findViewById<EditText>(R.id.txtApelido).text.toString()
            val nasc = findViewById<EditText>(R.id.txtDate).text.toString()
            //Falta genero
            val nacio = findViewById<EditText>(R.id.txtNacionalidade).text.toString()
            val contct = findViewById<EditText>(R.id.txtContacto).text.toString()
            val nmID = findViewById<EditText>(R.id.txtIDcivil).text.toString()
            val mail = findViewById<EditText>(R.id.txtEmail).text.toString()
            val passe = findViewById<EditText>(R.id.txtPassword).text.toString()
            val confpasse = findViewById<EditText>(R.id.txtConfPassword).text.toString()

            val data = RegistarEntity(nmID, nm, apl, "?", mail, nacio, contct, passe)

            viewModel.insertUserInfo(data)

            val i = Intent(this@RegistarActivity, MainActivity::class.java)
            startActivity(i)

        }
        ///////////////////////////
    }
}
