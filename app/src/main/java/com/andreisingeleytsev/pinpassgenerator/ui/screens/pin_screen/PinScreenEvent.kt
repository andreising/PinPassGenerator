package com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen

sealed class PinScreenEvent{
    object OnCopyCode: PinScreenEvent()
    object OnGenerateCode: PinScreenEvent()
    data class OnPinChose(val index: Indexes): PinScreenEvent()
}
