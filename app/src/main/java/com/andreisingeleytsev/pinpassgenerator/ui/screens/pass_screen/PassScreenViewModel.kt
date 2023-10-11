package com.andreisingeleytsev.pinpassgenerator.ui.screens.pass_screen

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.andreisingeleytsev.pinpassgenerator.ui.utils.CharList

class PassScreenViewModel(app: Application):AndroidViewModel(app) {
    fun onEvent(event: PassScreenEvent) {
        when (event) {
            is PassScreenEvent.OnSwitchPressed -> {
                when (event.index) {
                    0 -> {
                        switchByLetters.value = !switchByLetters.value
                    }
                    1 -> {
                        switchBySymbols.value = !switchBySymbols.value
                    }
                    2 -> {
                        switchByNumbers.value = !switchByNumbers.value
                    }
                    3 -> {
                        switchByCapitals.value = !switchByCapitals.value
                    }
                }
            }
            is PassScreenEvent.OnLengthChose -> {
                _currentLength.intValue = event.length
            }
            is PassScreenEvent.OnCopyCode -> {
                val context = this.getApplication<Application>()
                val clipboard: ClipboardManager =
                    context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("", currentPass.value)
                clipboard.setPrimaryClip(clip)
            }
            is PassScreenEvent.OnGenerateCode -> {
                generatePass()
            }
        }
    }
    val switchByLetters = mutableStateOf(true)
    val switchBySymbols = mutableStateOf(true)
    val switchByNumbers = mutableStateOf(true)
    val switchByCapitals = mutableStateOf(true)
    private val _currentLength = mutableIntStateOf(4)
    val currentLength: State<Int> = _currentLength
    private val _currentPass = mutableStateOf(
        ""
    )
    val currentPass: State<String> = _currentPass

    private fun generatePass() {
        var string = ""
        val listOfSymbols = mutableListOf<String>()
        if (switchByLetters.value) listOfSymbols+=CharList.letters
        if (switchBySymbols.value) listOfSymbols+=CharList.symbols
        if (switchByNumbers.value) listOfSymbols+=CharList.numbers
        if (switchByCapitals.value) listOfSymbols+=CharList.capitals
        for (i in 1.._currentLength.intValue) {
            string+=listOfSymbols.random()
        }
        _currentPass.value = string
    }
}