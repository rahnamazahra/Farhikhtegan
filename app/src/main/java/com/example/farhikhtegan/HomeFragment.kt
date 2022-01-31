package com.example.farhikhtegan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farhikhtegan.databinding.FragmentHomeBinding

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farhikhtegan.Adapter.ImageAdapter
import com.example.farhikhtegan.Adapter.TeacherAdapter
import com.example.farhikhtegan.services.DataSource
import com.smarteist.autoimageslider.SliderView

import java.util.ArrayList
import com.smarteist.autoimageslider.SliderAnimations

class HomeFragment:Fragment() {

    private var _binding:FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var adapter: TeacherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
/***************************************************************/
        val data = DataSource()
        adapter = TeacherAdapter(requireContext(), data.teachers)
        binding.recyclerviewTeacher.adapter = adapter
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewTeacher.layoutManager=layoutManager
 /***************************************************************/
        return root
    }
/************************************************************************/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}