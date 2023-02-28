package com.samiun.mycash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samiun.mycash.adapter.ItemAdapter
import com.samiun.mycash.data.DataSource
import kotlinx.android.synthetic.main.fragment_histoy.*


class HistoyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_histoy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset = DataSource().total()

        recycler_view.adapter = ItemAdapter(requireContext(),myDataset)


    }


}