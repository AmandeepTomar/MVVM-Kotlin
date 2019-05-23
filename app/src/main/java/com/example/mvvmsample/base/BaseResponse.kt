package com.example.mvvmsample.base

class  BaseResponse<D : BaseDataModel?, M : String?> {
    var d: D? = null
    var m: M? = null

    fun getData():D?{
        return d
    }

    fun getMessage():M?{
        return m
    }

}