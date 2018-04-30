package uk.co.purewowstudio.mvp.mvp.utils

import android.arch.lifecycle.*
import android.support.v4.app.FragmentActivity
import android.util.Log
import uk.co.purewowstudio.mvp.mvp.utils.Constants.Companion.DEBUG

fun logDebug(tag: String, message: String) {
    if (DEBUG) Log.v(tag, message)
}

fun logError(tag: String, message: String) {
    if (DEBUG) Log.e(tag, message)
}

fun logWarn(tag: String, message: String) {
    if (DEBUG) Log.w(tag, message)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}