package com.example.farhikhtegan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farhikhtegan.Adapter.AdapterComputer
import com.example.farhikhtegan.databinding.FragmentAcuuntingBinding
import com.example.farhikhtegan.databinding.FragmentComputerBinding
import com.example.farhikhtegan.databinding.FragmentKidBinding
import com.example.farhikhtegan.services.DataSource


class AcuuntingFragment:Fragment() {

    private var _binding:FragmentAcuuntingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: AdapterComputer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAcuuntingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /***************************************************************/
        val data = DataSource()
        adapter = AdapterComputer(requireContext(), data.computers)
        binding.listAccuntingCourse.adapter=adapter
        val layoutManager = LinearLayoutManager(requireContext())
        binding.listAccuntingCourse.layoutManager=layoutManager
        binding.listAccuntingCourse.setHasFixedSize(true )
        /*****************************************************************/
        return root
    }
    /************************************************************************/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}