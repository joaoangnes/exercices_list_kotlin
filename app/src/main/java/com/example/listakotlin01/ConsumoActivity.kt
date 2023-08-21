package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityConsumoBinding
import com.example.listakotlin01.databinding.ActivitySalarioBinding

class ConsumoActivity : AppCompatActivity() {
    // Criar uma instancia para view binding
    private lateinit var binding: ActivityConsumoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityConsumoBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutConsumoVeiculo.visibility = View.GONE

        binding.btnCalcConsumo.setOnClickListener {
            var mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos, para ser possivel realizar o cálculo"
            } else{
                calculaConsumo()
                mensagem = "Cálculo realizado com sucesso!"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarCampoVazio() : Boolean{
        return binding.edtKmPercorrido.text.isEmpty() || binding.edtQntLitrosAbastecido.text.isEmpty()
    }

    // Função responsável por calcular o salário
    private fun calculaConsumo() {
        val kmPercorrido = binding.edtKmPercorrido.text.toString().toDouble()
        val qntAbastecido = binding.edtQntLitrosAbastecido.text.toString().toDouble()
        var consumoVeiculo: Double = 0.0

        // Realiza o cálculo do consumo
        consumoVeiculo = kmPercorrido / qntAbastecido

        // Torna as informações novas visíveis para o usuário
        binding.layoutConsumoVeiculo.visibility = View.VISIBLE

        // Mostra o resultado do cálculo na tela para o usuário
        binding.txtConsumoVeiculoRes.text = consumoVeiculo.toString()+" km/l"
    }
}