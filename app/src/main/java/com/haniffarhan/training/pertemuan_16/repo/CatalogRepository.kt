package com.haniffarhan.training.pertemuan_16.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.haniffarhan.training.pertemuan_16.api.Catalog
import com.haniffarhan.training.pertemuan_16.data.SearchResponse
import com.haniffarhan.training.pertemuan_16.viewmodel.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class CatalogRepository @Inject constructor(val api: Catalog) {

    fun doSearch(q: String, limit: Int = 1, offset: Int = 0)
            : LiveData<Resource<SearchResponse>>{
        val data = MutableLiveData<Resource<SearchResponse>>()

        api.search(q, limit, offset).enqueue(
            object : Callback<SearchResponse> {
                override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {
                    val exception = AppException(t)
                    data.value = Resource.error(exception)
                }

                override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>?) {
                    data.value = Resource.success(response?.body())
                }
            }
        )
        return data
    }
}