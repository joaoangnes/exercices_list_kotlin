package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityVolumeLataOleoBinding
import kotlin.math.pow

class VolumeLataOleo : AppCompatActivity() {

    // Criar uma instancia para view binding
    private lateinit var binding: ActivityVolumeLataOleoBinding

    // Setando um valor constante para PI
    val const_pi = 3.1415926

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityVolumeLataOleoBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutVolumeLata.visibility = View.GONE

        binding.btnCalcVolLata.setOnClickListener {
            var mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos, para ser possivel realizar o cálculo"
            } else{
                calculaVolumeLata()
                mensagem = "Cálculo realizado com sucesso!"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarCampoVazio() : Boolean{
        return binding.edtAlturaLata.text.isEmpty() || binding.edtRaioBaseLata.text.isEmpty()
    }

    // Função responsável por calcular o salário
    private fun calculaVolumeLata() {
        val raioBaseLata = binding.edtRaioBaseLata.text.toString().toDouble()
        val alturaLata = binding.edtAlturaLata.text.toString().toDouble()
        var volumeLata: Double = 0.0

        // Realiza o cálculo do volume da lata de oleo cilindrica
        // A fórmula: pi * raio² * altura.
        volumeLata = const_pi * raioBaseLata.pow(2) * alturaLata

        // Torna as informações novas visíveis para o usuário
        binding.layoutVolumeLata.visibility = View.VISIBLE

        // Mostra o resultado do cálculo na tela para o usuário
        binding.txtVolumeLataRes.text = String.format("%.2f", volumeLata)+" cm³"
    }
}