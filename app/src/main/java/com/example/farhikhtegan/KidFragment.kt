package com.example.farhikhtegan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farhikhtegan.Adapter.AdapterComputer
import com.example.farhikhtegan.databinding.FragmentComputerBinding
import com.example.farhikhtegan.databinding.FragmentKidBinding
import com.example.farhikhtegan.services.DataSource


class KidFragment:Fragment() {

    private var _binding:FragmentKidBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: AdapterComputer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKidBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /***************************************************************/
        val data = DataSource()
        adapter = AdapterComputer(requireContext(), data.computers)
        binding.listKidCourse.adapter=adapter
        val layoutManager = LinearLayoutManager(requireContext())
        binding.listKidCourse.layoutManager=layoutManager
        binding.listKidCourse.setHasFixedSize(true )
        /*****************************************************************/
        return root
    }
    /************************************************************************/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}