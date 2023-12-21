package com.example.galleryapp.network

data class PhotoResponse(
    val photos: PhotosInfo
)

data class PhotosInfo(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    var photo : List<Photo>
)

data class Photo (
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int,
    val url_s: String,
    val height_s: Int,
    val width_s: Int,
)