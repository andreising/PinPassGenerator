package com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.andreisingeleytsev.pinpassgenerator.ui.utils.CharList


class PinScreenViewModel(application: Application) : AndroidViewModel(application) {
    fun onEvent(event: PinScreenEvent) {
        when (event) {
            is PinScreenEvent.OnCopyCode -> {
                val context = this.getApplication<Application>()
                val clipboard: ClipboardManager =
                    context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("", currentPin.value)
                clipboard.setPrimaryClip(clip)
            }

            is PinScreenEvent.OnGenerateCode -> {
                generatePin()
            }

            is PinScreenEvent.OnPinChose -> {
                isFirstScreen.value = false
                currentIndex = event.index
                generatePin()
            }
        }
    }

    val isFirstScreen = mutableStateOf(
        true
    )
    private var currentIndex: Indexes = Indexes.Light
    private val _currentPin = mutableStateOf(
        ""
    )
    val currentPin: State<String> = _currentPin

    private fun generatePin() {
        var string = ""
        for (i in 1..currentIndex.index) {
            string += CharList.numbers.random()
        }
        _currentPin.value = string
    }
}


sealed class Indexes(val index: Int) {
    object Light : Indexes(index = 4)
    object Medium : Indexes(index = 6)
    object Hard : Indexes(index = 8)
}