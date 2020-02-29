package com.mr.k.mvp.base

open interface IEntity< D>{

    fun getCode () : Int{
        return 0
    }

    fun getMessage() : String{
        return ""
    }


    fun getData() : D?{
        return null
    }

}