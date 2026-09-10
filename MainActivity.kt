package com.example.eventomensagem

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var resultado: TextView
    private lateinit var nome: TextInputLayout
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Vincular xml
        nome = findViewById(R.id.txtNome)
        botao = findViewById(R.id.btnClique)
        resultado = findViewById(R.id.txtResultado)

        // Configurar o evento de clique do botão
        botao.setOnClickListener {
            exibirMensagem()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun exibirMensagem() {
        val nomeDigitado = nome.editText?.text?.toString()?.trim() ?: ""

        if (nomeDigitado.isEmpty()) {
            resultado.text = "Campo Vazio"
        } else {
            resultado.text = "Olá $nomeDigitado"
        }
    }
}
