package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivitySalarioBinding

class SalarioActivity : AppCompatActivity() {

    // Criar uma instancia para view binding
    private lateinit var binding: ActivitySalarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivitySalarioBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutSalarioNovo.visibility = View.GONE
        binding.layoutValorAumentado.visibility = View.GONE

        binding.btnCalcSalario.setOnClickListener {
            var mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos, para ser possivel realizar o cálculo"
            } else{
                calculaSalario()
                mensagem = "Cálculo realizado com sucesso!"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarCampoVazio() : Boolean{
        return binding.edtSalarioAtual.text.isEmpty() || binding.edtPercentagemAumento.text.isEmpty()
    }

    // Função responsável por calcular o salário
    private fun calculaSalario() {
        val salario = binding.edtSalarioAtual.text.toString().toDouble()
        val percentagemAumento = binding.edtPercentagemAumento.text.toString().toDouble()
        var salarioNovo: Double = 0.0
        var valorAumento: Double = 0.0

        // Realiza o cálculo do salário
        valorAumento = salario * (percentagemAumento / 100.0)
        salarioNovo = salario + valorAumento

        // Torna as informações novas visíveis para o usuário
        binding.layoutSalarioNovo.visibility = View.VISIBLE
        binding.layoutValorAumentado.visibility = View.VISIBLE

        // Mostra o resultado do cálculo na tela para o usuário
        binding.txtSalarioNovoRes.text = salarioNovo.toString()
        binding.txtValorAumentoRes.text = valorAumento.toString()
    }

}