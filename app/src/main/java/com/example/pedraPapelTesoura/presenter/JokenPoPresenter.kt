package com.example.pedraPapelTesoura.presenter

import com.example.pedraPapelTesoura.EnumOptions
import com.example.pedraPapelTesoura.R
import com.example.pedraPapelTesoura.contract.JokenPoContract
import java.util.Random

class JokenPoPresenter(private val view: JokenPoContract.View) : JokenPoContract.Presenter {

    override fun play(optionPalyer: String) {
        val jokenpo = arrayOf(
            EnumOptions.PEDRA.toString(),
            EnumOptions.PAPEL.toString(),
            EnumOptions.TESOURA.toString()
        )
        val jogadaApp = Random().nextInt(3)
        val opcaoApp = jokenpo[jogadaApp]
        var resultado = "Empate"

        when (EnumOptions.valueOf(opcaoApp)) {
            EnumOptions.PEDRA -> view.setDrawSelected(R.drawable.pedra)
            EnumOptions.TESOURA -> view.setDrawSelected(R.drawable.tesoura)
            EnumOptions.PAPEL -> view.setDrawSelected(R.drawable.papel)
            else -> {
            }
        }

        if (optionPalyer == EnumOptions.PEDRA.toString() && opcaoApp == EnumOptions.TESOURA.toString() ||
            optionPalyer == EnumOptions.TESOURA.toString() && opcaoApp == EnumOptions.PAPEL.toString() ||
            optionPalyer == EnumOptions.PAPEL.toString() && opcaoApp == EnumOptions.PEDRA.toString()) {
            resultado = "Você ganhou"
        } else if (opcaoApp == EnumOptions.PEDRA.toString() && optionPalyer == EnumOptions.TESOURA.toString() ||
            opcaoApp == EnumOptions.TESOURA.toString() && optionPalyer == EnumOptions.PAPEL.toString() ||
            opcaoApp == EnumOptions.PAPEL.toString() && optionPalyer == EnumOptions.PEDRA.toString()) {
            resultado = "App ganhou"
        }

        view.setResult(resultado)
    }
}