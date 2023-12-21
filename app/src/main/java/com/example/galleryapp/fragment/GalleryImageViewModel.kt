package com.example.galleryapp.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.network.Photo
import com.example.galleryapp.network.PhotoApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryImageViewModel @Inject constructor(private val photoApiService: PhotoApiService, var photoGridAdapter: PhotoGridAdapter) : ViewModel() {

    private val _photosList = MutableLiveData<List<Photo>>()
    val photosList: LiveData<List<Photo>> =_photosList

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            try{
                _photosList.value = photoApiService.getPhotos().photos.photo
            }
            catch (e: Exception){
                _photosList.value = listOf()
            }
        }
    }
}