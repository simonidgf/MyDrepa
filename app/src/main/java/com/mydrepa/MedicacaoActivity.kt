package com.mydrepa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.mydrepa.db.MedicamentoEntity
import kotlinx.android.synthetic.main.activity_medicacao.*

class MedicacaoActivity : AppCompatActivity(), RecyclerViewAdapter_medicacao.RowClickListener {
    //DB
    lateinit var recyclerviewadapterMedicacao: RecyclerViewAdapter_medicacao
    lateinit var viewModel: MedicacaoViewModel
    ////
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
        recyclerView3.apply {
            layoutManager = LinearLayoutManager(this@MedicacaoActivity)
            recyclerviewadapterMedicacao = RecyclerViewAdapter_medicacao(this@MedicacaoActivity)
            adapter = recyclerviewadapterMedicacao
            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }
        viewModel = ViewModelProviders.of(this).get(MedicacaoViewModel::class.java)
        viewModel.getAllMedicamentosObservers().observe(this, Observer{
            recyclerviewadapterMedicacao.setListData(ArrayList(it))
            recyclerviewadapterMedicacao.notifyDataSetChanged()
        })

        btnAdicionar_medicacao.setOnClickListener{
            val medi = findViewById<EditText>(R.id.txtNome_medicamento)
            val d1 = findViewById<EditText>(R.id.txtDose1)
            val d2 = findViewById<EditText>(R.id.txtDose2)

            val medicamento = medi.text.toString()
            val dose1 = d1.text.toString()
            val dose2 = d2.text.toString()

            val m = MedicamentoEntity(0, medicamento, dose1, dose2)
            viewModel.insertMedicamentoInfo(m)

            medi.setText("")
            d1.setText("")
            d2.setText("")
        }

    }

    override fun onDeleteMedicamentoClickListener(medicamento: MedicamentoEntity) {
        viewModel.deleteMedicamentoInfo(medicamento)
    }

    override fun onItemClickListner(medicamento: MedicamentoEntity) {
        val medi = findViewById<EditText>(R.id.txtNome_medicamento)
        val d1 = findViewById<EditText>(R.id.txtDose1)
        val d2 = findViewById<EditText>(R.id.txtDose2)

        medi.setText(medicamento.nomeMed)
        d1.setText(medicamento.Dose1)
        d2.setText(medicamento.Dose2)
    }
    //////////
}