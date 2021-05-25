package com.mydrepa

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class EcraPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecra_principal)



        val term_sess = findViewById<ImageView>(R.id.btnTerminarSess)
        val historico = findViewById<ImageView>(R.id.btnHistorico)
        val diario = findViewById<ImageView>(R.id.btnDiario)
        val perfil = findViewById<ImageView>(R.id.btnPerfil)
        val add_registo = findViewById<ImageView>(R.id.btnAddRegisto)
        val medicacao = findViewById<ImageView>(R.id.btnMedicacao)

        //Go to medicacao
        medicacao.setOnClickListener(){
            val i = Intent(this@EcraPrincipalActivity, MedicacaoActivity::class.java)
            startActivity(i)
        }
        /////////////////

        //Terminar Sessão
        term_sess.setOnClickListener(){
            val i = Intent(this@EcraPrincipalActivity, MainActivity::class.java)
            startActivity(i)
        }
        //////////////////

        //Go to diario
        diario.setOnClickListener(){
            val i = Intent(this@EcraPrincipalActivity, DiarioActivity::class.java)
            startActivity(i)
        }
        //////////////

        //Go to perfil
        perfil.setOnClickListener(){
            val i = Intent(this@EcraPrincipalActivity, PerfilActivity::class.java)
            startActivity(i)
        }
        //////////////

        //Go to adicionar reisto
        add_registo.setOnClickListener(){
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Que tipo de registo deseja realizar ?")
                    .setCancelable(true)
                    // positive button text and action
                    .setPositiveButton("Nota", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                        //Navegate to register note
                        val i = Intent(this@EcraPrincipalActivity, NotaRegistoActivity::class.java)
                        startActivity(i)
                    })
                    // negative button text and action
                    .setNegativeButton("Dor", DialogInterface.OnClickListener {
                            dialog, id -> finish()
                        //Navegate to resgister pain
                        val i = Intent(this@EcraPrincipalActivity, DorRegistoActivity::class.java)
                        startActivity(i)

                    })

            val alert = dialogBuilder.create()
            alert.setTitle("Tipo de Registo")
            alert.show()
        }
        ////////////////////////

        //Go to Historico
        historico.setOnClickListener(){
            val i = Intent(this@EcraPrincipalActivity, HistoriaActivity::class.java)
            startActivity(i)
        }
        /////////////////

    }
}