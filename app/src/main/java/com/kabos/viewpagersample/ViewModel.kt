package com.kabos.viewpagersample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class PagerViewModel(application: Application) : AndroidViewModel(application) {

    val flag = MutableLiveData<ReplacePattern>()

}
