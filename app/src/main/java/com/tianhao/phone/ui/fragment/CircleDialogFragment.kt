package com.tianhao.phone.ui.fragment

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.graphics.PointF
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.tianhao.phone.R
import com.tianhao.phone.widget.CircleView

class CircleDialogFragment : DialogFragment() {
    var circleView :CircleView ?= null
    var rootView : View?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.circlefragment_layout,null)
        initView()
        return rootView
    }

    private fun initView() {
        circleView = rootView?.findViewById<CircleView>(R.id.circleview)

        //开始执行动画
//        var objectAnimator = ObjectAnimator.ofFloat(circleView,"progress",0f,360f)
        var objectAnimator = ObjectAnimator.ofObject(circleView,"progress",MyFloatEvaluator(),0f,360f)
        objectAnimator.interpolator = LinearInterpolator()
        objectAnimator.duration = 2000
        objectAnimator.repeatMode = ObjectAnimator.RESTART
        objectAnimator.repeatCount = -1
        objectAnimator.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
    }
    class MyPointEvaluator : TypeEvaluator<PointF> {
        override fun evaluate(fraction: Float, startValue: PointF?, endValue: PointF?): PointF {
            var x  = startValue!!.x +(endValue!!.x -startValue!!.x)*fraction
            var y  = startValue!!.y +(endValue!!.y -startValue!!.y)*fraction
            return PointF(x,y)
        }

    }
    class MyFloatEvaluator : TypeEvaluator<Float>{
        override fun evaluate(fraction: Float, startValue: Float?, endValue: Float?): Float {
            var i= startValue!! + ((endValue?.minus(startValue))?.times(fraction)!!)
            return i
        }

    }
}