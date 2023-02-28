package com.samiun.mynews.overview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.samiun.mynews.R
import com.samiun.mynews.model.Article
import com.bumptech.glide.Glide
import com.samiun.mynews.HomeFragmentDirections
import com.samiun.mynews.WebFragment


class NewsAdapter(private val context:Context, private val viewModel: OverviewViewModel,private val arrayList:List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    class NewsViewHolder(private var binding: View
    ): RecyclerView.ViewHolder(binding){
        val image=itemView.findViewById<ImageView>(R.id.news_image)
        val title=itemView.findViewById<TextView>(R.id.news_title)
        val description=itemView.findViewById<TextView>(R.id.news_content)
        val readBtn = itemView.findViewById<TextView>(R.id.read_more)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val root= LayoutInflater.from(parent.context).inflate(R.layout.news_list, parent,false)
        return NewsViewHolder(root)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=arrayList[position]
        val url = news.urlToImage
        holder.title.text=news.title
        holder.description.text=news.description

        holder.readBtn.setOnClickListener {

           val action =NewsFragmentDirections.actionNewsFragmentToWebFragment(news.url.toString())
            val action2 = HomeFragmentDirections.actionHomeFragmentToWebFragment(news.url.toString())
            holder.itemView.findNavController().navigate(action2)
            Toast.makeText(context, "Read More CLicked", Toast.LENGTH_SHORT).show()
        }

        Log.v("News Adapter ", "${news.urlToImage}")


        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(holder.image)




    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }


}