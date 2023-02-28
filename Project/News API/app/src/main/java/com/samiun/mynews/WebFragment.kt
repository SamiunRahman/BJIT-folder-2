package com.samiun.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.samiun.mynews.overview.OverviewViewModel


class WebFragment : Fragment() {
    val gerArgs : WebFragmentArgs by navArgs()
    private lateinit var viewModel: OverviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OverviewViewModel::class.java]

        val url = gerArgs.url

        val webView = view.findViewById<WebView>(R.id.webView)
        webView.loadUrl(url)


    }
}