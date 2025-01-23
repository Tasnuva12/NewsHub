package com.nexdecade.newshub.util

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, body: (T) -> Unit = {}): Job? {
    return try {
        launchWithLifecycle { lifecycleOwner ->
            liveData.observe(lifecycleOwner) {
                it?.let { t ->
                    body(t)
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
fun LifecycleOwner.launchWithLifecycle(observe: suspend (LifecycleOwner) -> Unit): Job? {
    return try {
        val lifecycleOwner = if (this is Fragment && this !is DialogFragment) this.viewLifecycleOwner else this

        lifecycleOwner.lifecycleScope.launch {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                observe(lifecycleOwner)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
