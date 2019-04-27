package com.haniffarhan.training.pertemuan_16.viewmodel

import com.haniffarhan.training.pertemuan_16.repo.AppException

class Resource<T> private constructor(
        val status: Status,
        val data: T?,
        val exception: AppException?
    ){

    enum class Status{
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun<T> success(data: T?) : Resource<T>{
            return Resource(Status.SUCCESS, data, null)
        }

        fun<T> error(exception: AppException?) : Resource<T>{
            return Resource(Status.ERROR, null, exception)
        }

        fun<T> loading(data: T?) : Resource<T>{
            return Resource(Status.LOADING, data, null)
        }
    }
}