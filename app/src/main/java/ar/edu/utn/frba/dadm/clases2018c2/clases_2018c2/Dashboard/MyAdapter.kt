package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Dashboard

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Movie
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class MyAdapter(private val myDataset: MutableList<Movie>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_listitem_view, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.movie_name).text = myDataset[position].movieName

        if (position % 2 == 0)
            //even
            holder.view.findViewById<ImageView>(R.id.movie_cover).setImageResource(R.drawable.movie_icon_1)
        else
            //odd
            holder.view.findViewById<ImageView>(R.id.movie_cover).setImageResource(R.drawable.movie_icon_2)
    }

    override fun getItemCount() = myDataset.size
}