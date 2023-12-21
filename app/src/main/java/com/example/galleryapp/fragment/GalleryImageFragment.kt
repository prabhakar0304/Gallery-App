package com.example.galleryapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.galleryapp.databinding.FragmentGalleryImageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryImageFragment : Fragment() {

    private val viewModel: GalleryImageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryImageBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = viewModel.photoGridAdapter
        return binding.root
    }
}