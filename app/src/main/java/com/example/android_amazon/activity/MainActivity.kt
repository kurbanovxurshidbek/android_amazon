package com.example.android_amazon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_amazon.R
import com.example.android_amazon.adapter.EssentialAdapter
import com.example.android_amazon.model.Essential

class MainActivity : AppCompatActivity() {
    lateinit var rv_essential: RecyclerView
    lateinit var ll_fashion: LinearLayout
    lateinit var ll_popular: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_popular)
        rv_essential = findViewById(R.id.rv_essential)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_essential.setLayoutManager(manager)

        refreshAdapter(getEssentials())

        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
    }

    fun setLinearHeight(layout: LinearLayout){
        // Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPixels = displayMetrics.widthPixels

        // Set layout width programmatically
        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }


    fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this, items)
        rv_essential!!.adapter = adapter
    }

    fun getEssentials(): ArrayList<Essential> {
        val items: ArrayList<Essential> = ArrayList<Essential>()
        items.add(Essential("Oculus", R.drawable.im_product_3))
        items.add(Essential("Gamer", R.drawable.im_product_2))
        items.add(Essential("Mobile", R.drawable.im_product_1))

        return items
    }
}