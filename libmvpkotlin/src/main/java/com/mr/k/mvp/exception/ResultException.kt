package com.mr.k.mvp.exception

import android.text.TextUtils
import java.io.IOException

/*
 * created by Cherry on 2020-01-10
 **/
class ResultException : IOException {
     var msg: String? = null
    var source: Throwable? = null
    var code = 0

    constructor(code: Int) : super("") {
        this.code = code
    }

    constructor(message: String) : super(message) {
        msg = message
    }

    constructor(cause: Throwable?) : super(cause) {
        source = cause
    }

    override val message: String
        get() {
            msg?.run {  // 我们特殊制定了异常消息
                return this
            }

            if (source != null && source is IOException) { // 一般指网络异常
                return "网络异常"
            }
            return if (code == SERVER_ERROR) { // 服务器错误导致
                "服务器小哥遇到了点问题，请稍后再试"
            } else
                "程序出错"
            // 自己代码发生了bug
        }

    companion object {

        const val SERVER_ERROR = 0X100

        fun newServerException(): ResultException {
            return ResultException(SERVER_ERROR)
        }
    }
}