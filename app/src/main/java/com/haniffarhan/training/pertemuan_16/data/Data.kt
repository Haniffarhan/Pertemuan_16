package com.haniffarhan.training.pertemuan_16.data

import com.google.gson.annotations.SerializedName

data class Product(val id: String,
                   val  title: String ="",
                   val images: List<Image> = ArrayList(),
                   val longDescription: String ="")

data class Image(@SerializedName("key") val size : String = "M",
                 @SerializedName("url") val url : String = "")

data class SearchResponse(val product: List<Product> = ArrayList())