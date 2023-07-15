package com.example.martel18100889ef202301

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.martel18100889ef202301.Adapter.MoviesAdapter
import com.example.martel18100889ef202301.Model.MoviesModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()
        var lstMovies: List<MoviesModel>
        val rvMovies: RecyclerView = findViewById(R.id.rvMovies)

        db.collection("movies")
            .addSnapshotListener{snap, e->
                if(e!=null){
                    Log.w("Firebase", "Error al consultar la colección de cursos")
                Snackbar.make(
                            findViewById(android.R.id.content),
                           "Error al consultar",
                           Snackbar.LENGTH_LONG
                        ).show()
                    return@addSnapshotListener
                }
                lstMovies = snap!!.documents.map { document ->
                    MoviesModel(document["id"].toString(),
                        document["MovieTitle"].toString(),
                    document["DurationInMinutes"].toString(),
                    document["Director"].toString(),
                    document["CoverImage"].toString())
                }

                rvMovies.adapter = MoviesAdapter(lstMovies)
               // rvMovies.layoutManager = LinearLayoutManager(requireContext())

            }
    }

}
