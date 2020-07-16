package com.example.pedraPapelTesoura.contract

interface JokenPoContract {

    interface View {
        fun setDrawSelected(imgResouce: Int)
        fun setResult(textResult: String)
    }

    interface Presenter {
        fun play(optionPalyer: String)
    }
}