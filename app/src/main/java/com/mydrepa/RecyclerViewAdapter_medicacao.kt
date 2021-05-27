package com.mydrepa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mydrepa.db.MedicamentoEntity
import kotlinx.android.synthetic.main.activity_medicacao.view.*
import kotlinx.android.synthetic.main.item_layout_medicacao.view.*

class RecyclerViewAdapter_medicacao(val listener: RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter_medicacao.MyViewHolder>() {

    var items = ArrayList<MedicamentoEntity>()

    fun setListData(data: ArrayList<MedicamentoEntity>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter_medicacao.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_medicacao, parent, false)
        return MyViewHolder(inflater, listener)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter_medicacao.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener.onItemClickListner(items[position])
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(view: View, val listener: RowClickListener): RecyclerView.ViewHolder(view){

        val txtNomeMed = view.lblMedicamento
        val txtDose1 = view.lblData1
        val txtDose2 = view.lblData2
        val btnDeleteMed = view.btnMedicacaoDelete

        fun bind(data: MedicamentoEntity){
            txtNomeMed.text = data.nomeMed
            txtDose1.text = data.Dose1
            txtDose2.text = data.Dose2

            btnDeleteMed.setOnClickListener{
                listener.onDeleteMedicamentoClickListener(data)
            }
        }
    }

    interface RowClickListener{
        fun onDeleteMedicamentoClickListener(medicamento: MedicamentoEntity)
        fun onItemClickListner(medicamento: MedicamentoEntity)
    }
}