package com.example.listakotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityMediaAlunoBinding

class MediaAlunoActivity : AppCompatActivity() {
    // Criar uma instancia para view binding
    private lateinit var binding: ActivityMediaAlunoBinding
    private lateinit var mensagem: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityMediaAlunoBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutMediaFinal.visibility = View.GONE

        binding.btnCalcMedia.setOnClickListener {
            mensagem = ""

            if (verificarCampoVazio()){
                mensagem = "Preencha todos os campos, para ser possivel realizar o cálculo"
            } else{
                calculaMediaFinal()
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarCampoVazio() : Boolean{
        return binding.edtNota1.text.isEmpty() || binding.edtNota2.text.isEmpty() || binding.edtNota3.text.isEmpty() || binding.edtNota4.text.isEmpty()
    }

    // Função responsável por calcular o salário
    private fun calculaMediaFinal() {
        val nota1 = binding.edtNota1.text.toString().toDouble()
        val nota2 = binding.edtNota2.text.toString().toDouble()
        val nota3 = binding.edtNota3.text.toString().toDouble()
        val nota4 = binding.edtNota4.text.toString().toDouble()
        var mediaFinal: Double = 0.0

        // Validação das notas informadas pelo usuário
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 ||
            nota3 < 0 || nota3 > 10 || nota4 < 0 || nota4 > 10) {
            //Toast.makeText(this, "Notas devem estar entre 0 e 10.", Toast.LENGTH_SHORT).show()
            mensagem = "Notas devem estar entre 0 e 10."
            return
        }

        // Realiza o cálculo da média final do aluno
        mediaFinal = (nota1 + nota2 + nota3 + nota4)/4

        // Torna as informações novas visíveis para o usuário
        binding.layoutMediaFinal.visibility = View.VISIBLE

        // Mostra o resultado do cálculo na tela para o usuário
        binding.txtMediaFinalRes.text = mediaFinal.toString()

        mensagem = "Cálculo realizado com sucesso!"
    }
}