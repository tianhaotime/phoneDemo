package com.tianhao.phone.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.owen.tvrecyclerview.widget.TvRecyclerView
import com.tianhao.phone.R
import com.tianhao.phone.adapter.MetroAdapter
import com.tianhao.phone.bean.ItemBean

class TvActivity : AppCompatActivity() {
    private var recyclerView : TvRecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv)
        initView()
    }

    private fun initView() {
       recyclerView = findViewById(R.id.list)
        recyclerView?.setSpacingWithMargins(10,10)
        recyclerView?.adapter = MetroAdapter(this,ItemBean.getDatas(60))

    }
}
