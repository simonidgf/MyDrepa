package com.mydrepa.medicacao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mydrepa.R
import com.mydrepa.medicacao.db.MedicacaoEntity
import kotlinx.android.synthetic.main.activity_medicacao.view.*

class RecyclerAdapter_medicacao(val listener: RowClickListener): RecyclerView.Adapter<RecyclerAdapter_medicacao.MyViewHolder>(){

    var items = ArrayList<MedicacaoEntity>()

    fun setListData(data: ArrayList<MedicacaoEntity>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter_medicacao.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_medicacao, parent, false)
        return MyViewHolder(inflater, listener)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter_medicacao.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener(){
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(view: View, val listener: RowClickListener): RecyclerView.ViewHolder(view){

        var medicamento = view.txtNome_medicamento.toString()
        var data1 = view.txtDose1.toString()
        var data2 = view.txtDose2.toString()
        var deleteMed = view.btnDelete_medicamento

        fun bind(data: MedicacaoEntity){
            medicamento = data.nome_medicamento
            data1 = data.data1
            data2 = data.data2

            deleteMed.setOnClickListener(){
                listener.onDeleteMedicamentoListener(data)
            }

        }
    }
}

interface RowClickListener{
    fun onDeleteMedicamentoListener(medicamento: MedicacaoEntity)
    fun onItemClickListener(medicamento: MedicacaoEntity)
}
