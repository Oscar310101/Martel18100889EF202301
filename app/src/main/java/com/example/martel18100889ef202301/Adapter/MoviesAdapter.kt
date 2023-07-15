package com.example.martel18100889ef202301.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.martel18100889ef202301.Model.MoviesModel
import com.example.martel18100889ef202301.R

class MoviesAdapter(private var lstCourses: List<MoviesModel>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val tvID: TextView = itemView.findViewById(R.id.txtid)
        val tvMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val tvDuration: TextView = itemView.findViewById(R.id.txtDuration)
        val tvDirector: TextView = itemView.findViewById(R.id.txtDirector)
        val tvImage: TextView = itemView.findViewById(R.id.txtImage)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_movies,parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCourse = lstCourses[position]
        holder.tvID.text = itemCourse.id
        holder.tvMovie.text = itemCourse.movie
        holder.tvDuration.text = itemCourse.durationinminutes
        holder.tvDirector.text = itemCourse.director
        holder.tvImage.text = itemCourse.coverimage
    }
    override fun getItemCount(): Int {
        return lstCourses.size
    }

}