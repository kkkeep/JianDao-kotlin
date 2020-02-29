package com.mr.k.mvp.base

 interface IEntity< D>{

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