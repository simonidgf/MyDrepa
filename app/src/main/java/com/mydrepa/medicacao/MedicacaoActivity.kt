package com.mydrepa.medicacao

import android.content.Intent
import android.graphics.drawable.ClipDrawable.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mydrepa.EcraPrincipalActivity
import com.mydrepa.R
import com.mydrepa.medicacao.db.MedicacaoEntity
import kotlinx.android.synthetic.main.activity_diario.*
import kotlinx.android.synthetic.main.activity_medicacao.*

class MedicacaoActivity : AppCompatActivity(), RowClickListener {

    lateinit var recyclerViewAdapter_med: RecyclerAdapter_medicacao
    lateinit var viewModel: MedicacaoActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicacao)

        //Go back
        val anterior_medicacao = findViewById<ImageView>(R.id.btnAnterior_medicacao)
        anterior_medicacao.setOnClickListener(){
                val I = Intent(this@MedicacaoActivity, EcraPrincipalActivity::class.java)
                startActivity(I)
        }
        /////////

        //DB
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MedicacaoActivity)
            recyclerViewAdapter_med = RecyclerAdapter_medicacao(this@MedicacaoActivity)
            adapter = recyclerViewAdapter_med
            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }

        viewModel = ViewModelProviders.of(this).get(MedicacaoActivityViewModel:: class.java)
        viewModel.getAllMedicamentosObservers().observe(this, Observer {
            recyclerViewAdapter_med.setListData(ArrayList(it))
            recyclerViewAdapter_med.notifyDataSetChanged()
        })
        btnAdicionar_medicacao.setOnClickListener(){
            var medicamento_nome = txtNome_medicamento.text.toString()
            var data1 = txtDose1.text.toString()
            var data2 = txtDose2.text.toString()

            var med = MedicacaoEntity(0, medicamento_nome, data1, data2)
            viewModel.insertMedicamentoInfo(med)
        }
    }

    override fun onDeleteMedicamentoListener(medicamento: MedicacaoEntity) {
        viewModel.deleteMedicamentoInfo(medicamento)
    }

    override fun onItemClickListener(medicamento: MedicacaoEntity) {
        txtNome_medicamento.setText(medicamento.nome_medicamento)
        txtDose1.setText(medicamento.data1)
        txtDose2.setText(medicamento.data2)
    }
    ////
}