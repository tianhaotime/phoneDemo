package com.tianhao.phone.bean

import android.util.Log

class ItemBean{
    companion object {
         fun getDatas(count:Int):List<ItemBean>{
             var list = ArrayList<ItemBean>()
            for (i in IntRange(1,count)){
                Log.e("aking","i = $i")
                list.add(ItemBean())
            }
             return list
        }
    }

}