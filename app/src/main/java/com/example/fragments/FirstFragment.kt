package com.example.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentFirstBinding
import com.example.fragments.Item as Item


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var list = arrayListOf<Item>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PortraitAdapter(list, this::onClick)
        binding.recyclerView.adapter = adapter


    }

    private fun onClick(position:Int) {
      //  findNavController().navigate(R.id.secondFragment, bundleOf("key" to list[position]))
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(list[position]))


    }


    private fun loadData() {
        list.clear()
        list.add(Item(R.drawable.image_1, "Alive", "Rich Sanchez"))
        list.add(Item(R.drawable.image_2, "Alive", "Morty Smith"))
        list.add(Item(R.drawable.image_3, "Died", "Albert Einstein"))
        list.add(Item(R.drawable.image_4, "Alive", "Jerry Smith"))
    }
}


