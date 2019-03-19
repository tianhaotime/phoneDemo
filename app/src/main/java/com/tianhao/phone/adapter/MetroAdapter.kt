package com.tianhao.phone.adapter

import android.content.Context
import android.widget.TextView
import com.owen.adapter.CommonRecyclerViewAdapter
import com.owen.adapter.CommonRecyclerViewHolder
import com.owen.tvrecyclerview.widget.MetroGridLayoutManager
import com.tianhao.phone.R
import com.tianhao.phone.bean.ItemBean

class MetroAdapter(context: Context?, datas: List<ItemBean>?) : CommonRecyclerViewAdapter<ItemBean>(context, datas) {
    override fun getItemLayoutId(viewType: Int): Int {
        return R.layout.metro_adapter_item
    }

    override fun onBindItemHolder(helper: CommonRecyclerViewHolder?, item: ItemBean?, position: Int) {
        val itemView = helper?.itemView
        val lp = itemView?.layoutParams as MetroGridLayoutManager.LayoutParams
        var tv = helper.holder.getView<TextView>(R.id.tv)
        tv.text = position.toString()
        if (position > 18) {
            lp.rowSpan = 3
            lp.colSpan = 2
        } else if (position > 6) {
            if (position < 10) {
                lp.rowSpan = 15
                lp.colSpan = 20
            } else if (position < 14) {
                lp.rowSpan = 9
                lp.colSpan = 15
            } else {
                lp.rowSpan = 7
                lp.colSpan = 12
            }
        } else {
            if (position == 0 || position == 6) {
                lp.rowSpan = 3
                lp.colSpan = 4
            } else {
                lp.rowSpan = 6
                lp.colSpan = 4
            }
        }
        itemView.layoutParams = lp
    }

}