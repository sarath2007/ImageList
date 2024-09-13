package com.zapcom.interview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zapcom.interview.databinding.FragmentFirstBinding
import com.zapcom.interview.models.ImageListObject
import com.zapcom.interview.modelview.ImageListModelView


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var imageGalleryAdapter: ImageGalleryAdapter
    private lateinit var itemList: ArrayList<ImageListObject>
    private lateinit var viewModel: ImageListModelView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // binding.buttonFirst.setOnClickListener {
         //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
       // }
        mainRecyclerView = view.findViewById<RecyclerView>(R.id.mainRecyclerView)
        itemList = ArrayList()
      //  for (i in 1..20) {
       //     itemList.add(JKObject("Item $i",ArrayList<JKObjectItem>(10)))
       // }
        imageGalleryAdapter = ImageGalleryAdapter(activity?.applicationContext,itemList)
        mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = imageGalleryAdapter
        }


        viewModel = ViewModelProvider(this)[ImageListModelView::class.java]
        viewModel.getImageList()
        viewModel.observeImagesLiveData().observe(this, Observer { imageList ->
            imageGalleryAdapter.itemList = imageList
            imageGalleryAdapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}