package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Dashboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.MoviesApi
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class DashboardActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val myDataset = MoviesApi().getMovies()

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = MyAdapter(myDataset)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}