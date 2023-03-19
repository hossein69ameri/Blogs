package com.example.smilinno_ameri.util

import android.view.View

//visibility
fun View.isVisible(isShow : Boolean,container : View){
     if (isShow){
         this.visibility = View.VISIBLE
         container.visibility = View.GONE
     }else{
         this.visibility = View.GONE
         container.visibility = View.VISIBLE
     }
 }