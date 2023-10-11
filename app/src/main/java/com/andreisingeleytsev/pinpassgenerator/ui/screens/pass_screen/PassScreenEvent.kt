package com.andreisingeleytsev.pinpassgenerator.ui.screens.pass_screen

import com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen.PinScreenEvent

sealed class PassScreenEvent{
    data class OnSwitchPressed(val index: Int): PassScreenEvent()
    data class OnLengthChose(val length: Int): PassScreenEvent()
    object OnCopyCode: PassScreenEvent()
    object OnGenerateCode: PassScreenEvent()
}
