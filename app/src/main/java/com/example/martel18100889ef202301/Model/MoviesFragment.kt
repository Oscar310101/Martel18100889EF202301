package com.example.martel18100889ef202301.Model

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.martel18100889ef202301.Adapter.MoviesAdapter
import com.example.martel18100889ef202301.R
import com.google.firebase.firestore.FirebaseFirestore

class MoviesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_movies, container, false)
        val db = FirebaseFirestore.getInstance()
        var lstCourses: List<MoviesModel>
        val rvCourse: RecyclerView = view.findViewById(R.id.rvMovies2)

        db.collection("movies")
            .addSnapshotListener{snap, e->
                if(e!=null){
                    Log.w("Firebase", "Error al consultar la colección de cursos")
//                    Snackbar
//                        .make(
//                            findViewById(android.R.id.content),
//                            "Error al consultar",
//                           Snackbar.LENGTH_LONG
//                        ).show()
                    return@addSnapshotListener
                }
                lstCourses = snap!!.documents.map { document ->
                    MoviesModel(document["id"].toString(),
                        document["movie"].toString(),
                        document["durationinminutes"].toString(),
                        document["director"].toString(),
                        document["coverimage"].toString())
                }

                rvCourse.adapter = MoviesAdapter(lstCourses)
                rvCourse.layoutManager = LinearLayoutManager(requireContext())

            }
        return view
    }
}