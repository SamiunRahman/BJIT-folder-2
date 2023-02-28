package com.samiun.mynews.overview

import android.content.ContentValues.TAG
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.samiun.mynews.R
import com.samiun.mynews.model.Article
import com.bumptech.glide.Glide
import com.samiun.mynews.data.ArticleBookmark
import com.samiun.mynews.data.ArticleEntity
import com.samiun.mynews.model.News
import com.samiun.mynews.ui.HomeFragmentDirections


class NewsAdapter(private val context:Context, private val viewModel: OverviewViewModel,private val arrayList:List<ArticleEntity>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    class NewsViewHolder(private var binding: View
    ): RecyclerView.ViewHolder(binding){


        val image=itemView.findViewById<ImageView>(R.id.news_image)
        val title=itemView.findViewById<TextView>(R.id.news_title)
        val description=itemView.findViewById<TextView>(R.id.news_content)
        val readBtn = itemView.findViewById<TextView>(R.id.read_more)
        val bookmarkBtn = itemView.findViewById<ImageView>(R.id.bookmark)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val root= LayoutInflater.from(parent.context).inflate(R.layout.news_list, parent,false)
        return NewsViewHolder(root)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=arrayList[position]
        val url = news.urlToImage

        if (!TextUtils.isEmpty(news.title)){
            holder.title.text=news.title
        }else{
            holder.title.text= "No title"
        }

        if (!TextUtils.isEmpty(news.title)){
            holder.description.text=news.description
        }else{
            holder.description.text="news.description"
        }

        if(news.bookmark){
            holder.bookmarkBtn.setImageResource(R.drawable.bookmarked)
        }
        else{
            Log.d("Adapter Bookmarked", "onBindViewHolder: ${news.bookmark}")
            holder.bookmarkBtn.setImageResource(R.drawable.not_bookmarked)
        }


        holder.readBtn.setOnClickListener {
            val action2 = HomeFragmentDirections.actionHomeFragmentToWebFragment(news.url.toString())
            holder.itemView.findNavController().navigate(action2)
            Toast.makeText(context, "Read More CLicked", Toast.LENGTH_SHORT).show()
        }

        holder.bookmarkBtn.setOnClickListener {
/*            if(news.bookmark){
               val updateNews = ArticleEntity(news.id,news.type,false,news.author,news.content,news.description,news.publishedAt,news.source,news.title,news.url,news.urlToImage)
                viewModel.updateArticle(updateNews)

                if(updateNews.bookmark){
                    Toast.makeText(context, "Updated to false", Toast.LENGTH_SHORT).show()
                }
                val articleBookmark = ArticleBookmark(news.id,news.author,news.content,news.description,news.publishedAt,news.source,news.title,news.url,news.urlToImage)
                viewModel.addBookmark(articleBookmark)
                holder.bookmarkBtn.setImageResource(R.drawable.not_bookmarked)
            }
            else{
                val updateNews = ArticleEntity(news.id,news.type,true,news.author,news.content,news.description,news.publishedAt,news.source,news.title,news.url,news.urlToImage)
                viewModel.updateArticle(updateNews)
                val articleBookmark = ArticleBookmark(news.id,news.author,news.content,news.description,news.publishedAt,news.source,news.title,news.url,news.urlToImage)
                viewModel.deleteBookmark(articleBookmark)
                holder.bookmarkBtn.setImageResource(R.drawable.bookmarked)
            }*/


            if(news.bookmark){
                news.bookmark=false
                viewModel.updateArticle(news)
                Toast.makeText(context, "Updated to false: ${news.bookmark}", Toast.LENGTH_SHORT).show()
                Log.d("BookMark btn", "onBindViewHolder: ${news.bookmark}")

            }
            else{
                news.bookmark=true
                viewModel.updateArticle(news)
                val articleBookmark = ArticleBookmark(news.id,news.author,news.content,news.description,news.publishedAt,news.source,news.title,news.url,news.urlToImage)
                viewModel.addBookmark(articleBookmark)
                Toast.makeText(context, "Updated to True: ${news.bookmark}", Toast.LENGTH_SHORT).show()
            }

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
        Log.d("Adapter News", "getItemCount: ${arrayList.size} ")
        return  arrayList.size
    }


}