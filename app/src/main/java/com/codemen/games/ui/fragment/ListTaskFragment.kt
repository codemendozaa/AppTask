package com.codemen.games.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.codemen.games.R
import com.codemen.games.databinding.FragmentListTaskBinding
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_list_task.*

class ListTaskFragment : Fragment() {
    private  var _binding : FragmentListTaskBinding? = null
    private var count:Int = 0
    private  val binding get() = _binding!!
   // private var navController : NavController = Navigation.findNavController(myNavHostFragment)



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
        /* navController = Navigation.findNavController(view)
        addTask.setOnClickListener {
            navController.navigate(R.id.action_listTaskFragment_to_createTaskFragment)
        }*/
        initListeners()
        binding.addTask.setOnClickListener {
            findNavController().navigate(R.id.createTaskFragment)
           // navController.navigate(R.id.createTaskFragment)
        }


    }




    private fun initListeners() {
       binding.likeLogo.setOnClickListener {
            count++
         //  binding.tvLikeCount.text = "$count"
        }
    }


}
