package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityTemperaturaBinding
import java.util.Calendar

class TemperaturaActivity : AppCompatActivity() {
    // Criar uma instancia para view binding
    private lateinit var binding: ActivityTemperaturaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityTemperaturaBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutTempFahr.visibility = View.GONE

        binding.btnCalcTemp.setOnClickListener {
            var mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos, para ser possivel realizar o cálculo"
            } else{
                converteTemperatura()
                mensagem = "Cálculo realizado com sucesso!"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarCampoVazio() : Boolean{
        return binding.edtTempCelsius.text.isEmpty()
    }

    // Função responsável por calcular o salário
    private fun converteTemperatura() {
        val tempCelsius = binding.edtTempCelsius.text.toString().toDouble()
        var tempFahrenheit: Double = 0.0

        // Realiza o cálculo da conversão de Graus Celsius para Fahrenheit
        // A fórmula de conversão: F ← (9*C+160)/5
        tempFahrenheit = (9 * tempCelsius + 160)/5

        // Torna as informações novas visíveis para o usuário
        binding.layoutTempFahr.visibility = View.VISIBLE

        // Mostra o resultado do cálculo na tela para o usuário
        binding.txtTempFahrRes.text = tempFahrenheit.toString()+" °F"
    }
}