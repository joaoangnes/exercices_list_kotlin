package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityVolumeCaixaBinding

class VolumeCaixaActivity : AppCompatActivity() {
    // Criar uma instancia para view binding
    private lateinit var binding: ActivityVolumeCaixaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityVolumeCaixaBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutVolumeCaixa.visibility = View.GONE

        binding.btnCalcVolume.setOnClickListener {
            var mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos, para ser possivel realizar o cálculo"
            } else{
                calculaVolumeCaixa()
                mensagem = "Cálculo realizado com sucesso!"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarCampoVazio() : Boolean{
        return binding.edtAlturaCaixa.text.isEmpty() || binding.edtLarguraCaixa.text.isEmpty() || binding.edtComprimentoCaixa.text.isEmpty()
    }

    // Função responsável por calcular o voluma da caixa
    private fun calculaVolumeCaixa() {
        val altura = binding.edtAlturaCaixa.text.toString().toDouble()
        val largura = binding.edtLarguraCaixa.text.toString().toDouble()
        val comprimento = binding.edtComprimentoCaixa.text.toString().toDouble()
        var volumeCaixa: Double = 0.0

        // Realiza o cálculo do volume da caixa
        volumeCaixa = (altura * largura * comprimento)

        // Torna as informações novas visíveis para o usuário
        binding.layoutVolumeCaixa.visibility = View.VISIBLE

        // Mostra o resultado do cálculo na tela para o usuário
        binding.txtVolumeCaixaRes.text = volumeCaixa.toString()+" cm3"
    }
}