package uk.co.purewowstudio.mvp.mvp.utils

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