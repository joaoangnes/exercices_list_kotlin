package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Criar uma instancia para view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Função que irá verificar os cliques nos botões
        setButtonClickListeners()
    }

    private fun setButtonClickListeners() {
        val buttons = listOf(
            binding.btnCalcSalario,
            binding.btnCalcVolCx,
            binding.btnCalcIdade,
            binding.btnCalcConsumo,
            binding.btnCalcNota,
            binding.btnCalcTemp,
            binding.btnCalcVolOleo
        )

        for (button in buttons) {
            button.setOnClickListener {
                handleButtonClick(button.id)
            }
        }
    }

    private fun handleButtonClick(buttonId: Int) {
        var mensagem = ""

        when (buttonId) {
            binding.btnCalcSalario.id -> {
                // Ação para o Botão 1
                mensagem = "CACA EU TE AMOOOO"
            }
            binding.btnCalcVolCx.id -> {
                // Ação para o Botão 2
                mensagem = "MAIS QUE TUDO NO MUNDO"
            }
            binding.btnCalcIdade.id -> {
                // Ação para o Botão 3
                mensagem = "VOCE É TUDO PARA MIM"
            }
            binding.btnCalcConsumo.id -> {
                // Ação para o Botão 4
                mensagem = "MESMO ME ODIANDO"
            }
            binding.btnCalcNota.id -> {
                // Ação para o Botão 5
                mensagem = "EU SOU COMPLETAMENTE APAIXONADO POR VOCE"
            }
            binding.btnCalcTemp.id -> {
                // Ação para o Botão 6
                mensagem = "NÃO TENHO VERGONHA E VOU TE LEVAR PARA O MUNDO INTEIRO COMIGO PARA O MUNDO INTEIRO"
            }
            binding.btnCalcVolOleo.id -> {
                // Ação para o Botão 7
                mensagem = "PARA TODA ETERNIDADE, EU TE AMOOO"
            }
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}