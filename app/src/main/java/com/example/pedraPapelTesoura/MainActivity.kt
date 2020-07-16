package com.example.pedraPapelTesoura

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pedraPapelTesoura.contract.JokenPoContract
import com.example.pedraPapelTesoura.presenter.JokenPoPresenter
import kotlinx.android.synthetic.main.activity_main.img_default
import kotlinx.android.synthetic.main.activity_main.img_papel
import kotlinx.android.synthetic.main.activity_main.img_pedra
import kotlinx.android.synthetic.main.activity_main.img_tesoura
import kotlinx.android.synthetic.main.activity_main.tv_resultado

class MainActivity : AppCompatActivity(), JokenPoContract.View {

    private val presenter = JokenPoPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_pedra.setOnClickListener {
            presenter.play(EnumOptions.PEDRA.toString())
        }

        img_tesoura.setOnClickListener {
            presenter.play(EnumOptions.TESOURA.toString())
        }

        img_papel.setOnClickListener {
            presenter.play(EnumOptions.PAPEL.toString())
        }
    }

    override fun setDrawSelected(imgResouce: Int) {
        img_default?.setImageResource(imgResouce)
    }

    override fun setResult(textResult: String) {
        tv_resultado?.text = textResult;
    }
}