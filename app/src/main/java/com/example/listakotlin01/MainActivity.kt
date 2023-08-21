package com.example.listakotlin01

import android.content.Intent
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

    // Função que irá realizar as ações dos botões
    private fun handleButtonClick(buttonId: Int) {
        when (buttonId) {
            binding.btnCalcSalario.id -> {
                // Ação para o Botão de Salário
                // Criar intent para acessar outra activity
                var intent = Intent(this, SalarioActivity::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
            binding.btnCalcVolCx.id -> {
                // Ação para o Botão de Volume da Caixa
                // Criar intent para acessar outra activity
                var intent = Intent(this, VolumeCaixaActivity::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
            binding.btnCalcIdade.id -> {
                // Ação para o Botão de Idade
                // Criar intent para acessar outra activity
                var intent = Intent(this, IdadeActivity::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
            binding.btnCalcConsumo.id -> {
                // Ação para o Botão de Consumo do veiculo
                // Criar intent para acessar outra activity
                var intent = Intent(this, ConsumoActivity::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
            binding.btnCalcNota.id -> {
                // Ação para o Botão Média final do aluno
                // Criar intent para acessar outra activity
                var intent = Intent(this, MediaAlunoActivity::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
            binding.btnCalcTemp.id -> {
                // Ação para o Botão de temperatura
                // Criar intent para acessar outra activity
                var intent = Intent(this, TemperaturaActivity::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
            binding.btnCalcVolOleo.id -> {
                // Ação para o Botão volume lata de oleo
                // Criar intent para acessar outra activity
                var intent = Intent(this, VolumeLataOleo::class.java)
                // Iniciar activity de acordo com dados da intent
                startActivity(intent)
            }
        }
    }
}