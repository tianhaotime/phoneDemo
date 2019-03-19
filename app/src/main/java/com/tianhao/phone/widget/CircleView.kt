package com.tianhao.phone.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.tianhao.phone.R

class CircleView : View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    var paint  = Paint()
    var rectF = RectF()
    //定义一个圆形半径
    var r = resources.getDimension(R.dimen.dp_35)
    var progress:Float= 0f
    set(value) {
        field = value
        invalidate()
    }
    init {
        paint.color = Color.BLACK
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = resources.getDimension(R.dimen.dp_5)
        paint.style = Paint.Style.STROKE
        paint.flags = Paint.ANTI_ALIAS_FLAG
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rectF.set((width/2-r), (height/2-r), (width/2+r), (width/2+r))
        canvas?.drawArc(rectF, 0F, progress,false, paint)
    }


}