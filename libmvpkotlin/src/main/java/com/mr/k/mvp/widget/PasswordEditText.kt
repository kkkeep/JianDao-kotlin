package com.mr.k.mvp.widget

import android.content.Context
import android.os.Build
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.mr.k.mvp.Utils.SystemFacade


/*
 * created by Cherry on 2020-01-03
**/
class PasswordEditText : EditText {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun onFinishInflate() {
        super.onFinishInflate()

        // 如果是华为手机，并且版本号大于9.0
        if(Build.MANUFACTURER.equals("huawei",true) &&  SystemFacade.hasP()){
            inputType = EditorInfo.TYPE_CLASS_TEXT
            transformationMethod = PasswordTransformationMethod.getInstance()

        }

    }

}