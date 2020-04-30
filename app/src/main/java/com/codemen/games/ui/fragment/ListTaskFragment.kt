package com.codemen.games.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codemen.games.R
import com.codemen.games.databinding.FragmentListTaskBinding
import kotlinx.android.synthetic.main.fragment_list_task.*

class ListTaskFragment : Fragment() {
    private  var _binding : FragmentListTaskBinding? = null
    private var count:Int = 0
    private  val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

    }




    private fun initListeners() {
       binding.likeLogo.setOnClickListener {
            count++
           binding.tvLikeCount.text = "$count"
        }
    }


}
