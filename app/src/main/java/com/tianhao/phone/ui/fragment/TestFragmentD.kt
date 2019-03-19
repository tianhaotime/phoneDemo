package com.tianhao.phone.ui.fragment

import android.content.Intent
import android.view.View
import android.widget.Button
import com.tianhao.phone.R
import com.tianhao.phone.ui.RegisterActivity
import com.tianhao.phone.ui.TvActivity

class TestFragmentD : ImmersionFragment(), View.OnClickListener {

     var button2 : Button? = null
    var button3  : Button? = null
    lateinit var button4 : Button
    override fun getLayoutId(): Int {
        return R.layout.fragment_test_d
    }

    override fun getTitleBarId(): Int {
        return 0
    }

    override fun initView() {
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)

    }

    override fun initData() {
        button2!!.setOnClickListener(this)
        button3!!.setOnClickListener(this)
        button4!!.setOnClickListener(this)
    }

    companion object {


        fun newInstance(): TestFragmentD {
            return TestFragmentD()
        }
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button2 -> {
                startActivity(Intent(activity, RegisterActivity::class.java))
            }
            R.id.button3 ->{
                startActivity(Intent(activity,TvActivity::class.java))
            }
            R.id.button4 ->{
                CircleDialogFragment().show(fragmentManager,"c")

            }
        }
    }
}
