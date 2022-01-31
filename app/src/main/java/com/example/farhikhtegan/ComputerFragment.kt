package com.example.farhikhtegan

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farhikhtegan.Adapter.AdapterComputer
import com.example.farhikhtegan.databinding.FragmentComputerBinding
import com.example.farhikhtegan.services.DataSource


class ComputerFragment:Fragment() {

    private var _binding:FragmentComputerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: AdapterComputer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComputerBinding.inflate(inflater, container, false)
        val root: View = binding.root
        /***************************************************************/
        val searchIcon = binding.ComputerCourseSearch.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.WHITE)

        val cancelIcon = binding.ComputerCourseSearch.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.WHITE)


       binding.ComputerCourseSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               /* adapter.filter.filter(newText)*/
                return false
            }

        })
        /***************************************************************/
        val data = DataSource()
        var spanCount:Int=2
        adapter = AdapterComputer(requireContext(), data.computers)
        binding.listComuterCourse.adapter=adapter

        val layoutManager =LinearLayoutManager(requireContext())
        binding.listComuterCourse.layoutManager=layoutManager
        binding.listComuterCourse.setHasFixedSize(true )
        /*****************************************************************/
        return root
    }
    /************************************************************************/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}