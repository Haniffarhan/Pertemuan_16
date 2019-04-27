package com.haniffarhan.training.pertemuan_16

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.haniffarhan.training.pertemuan_16.data.SearchResponse
import com.haniffarhan.training.pertemuan_16.ui.viewMvc.pdp.ProductDetailView
import com.haniffarhan.training.pertemuan_16.viewmodel.ProductViewModel
import com.haniffarhan.training.pertemuan_16.viewmodel.Resource

class MainActivity : FragmentActivity() {

    var productDetails : ProductViewModel? = null
    var view : ProductDetailView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ProductDetailView(layoutInflater, object : ProductDetailView.Listener{
            override fun search(s: String) {
                productDetails?.search(s)
            }
        })
        setContentView(view?.rootView)

        productDetails = ProductViewModel.create(this)
        App.appcomponent.inject(productDetails!!)

        productDetails?.searchResult?.observe(
            this, Observer<Resource<SearchResponse>>{
                resource ->
                if (resource != null){
                    when(resource.status){
                        Resource.Status.SUCCESS ->{
                            val product = resource.data
                            val products = product?.product
                            if (!products!!.isEmpty()){
                                view?.populatedProduct(
                                    products.first())
                            }
                        }
                        Resource.Status.ERROR ->{
                            Toast.makeText(
                                this, " Error : " +
                                        resource.exception?.message, Toast.LENGTH_SHORT
                            ).show()
                        }
                        Resource.Status.LOADING ->{
                            //do nothing
                        }
                    }
                }
            }
        )
    }
}
