package com.samiun.mynews.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.samiun.mynews.databinding.FragmentNewsBinding
import com.samiun.mynews.model.Article


class NewsFragment : Fragment() {
    lateinit var navController: NavController

    private val viewModel: OverviewViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNewsBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this


        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        viewModel.articles.observe(viewLifecycleOwner, Observer { articles ->
            if (articles != null) {
                binding.newsArticle.adapter = NewsAdapter(requireContext(), viewModel, viewModel.articles.value!!)
            }
        })

        //binding.newsArticle.adapter = NewsAdapter(requireContext(), viewModel,viewModel.articles.value as ArrayList<Article>)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}