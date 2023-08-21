package com.example.listakotlin01

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listakotlin01.databinding.ActivityIdadeBinding
import com.example.listakotlin01.databinding.ActivityVolumeCaixaBinding
import kotlinx.coroutines.selects.select
import java.util.Calendar

class IdadeActivity : AppCompatActivity() {
    // Criar uma instancia para view binding
    private lateinit var binding: ActivityIdadeBinding
    private lateinit var calendarMax: Calendar
    private lateinit var calendarMin: Calendar
    private lateinit var selectedCalendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Iniciar o layout xml para dentro de 'binding'
        binding = ActivityIdadeBinding.inflate(layoutInflater)

        // Facilitar o acesso ao root (a toda a camada view) desse binding
        var view = binding.root

        // Setar este view para sendo o novo layout para esta classe
        setContentView(view) // binding.root

        // Torna as informações novas invisiveis para o usuario
        binding.layoutIdade.visibility = View.GONE

        // Definir uma data máxima para evitar anos futuros
        calendarMax = Calendar.getInstance()
        calendarMax.timeInMillis = System.currentTimeMillis()
        binding.dpDataNascimento.maxDate = calendarMax.timeInMillis

        // Definir uma data mínima para evitar anos anteriores a 1900
        calendarMin = Calendar.getInstance()
        calendarMin.set(1900, Calendar.JANUARY, 1)
        binding.dpDataNascimento.minDate = calendarMin.timeInMillis

        selectedCalendar = Calendar.getInstance()

        // Configurar o ouvinte de mudança de data
        binding.dpDataNascimento.init(calendarMax.get(Calendar.YEAR), calendarMax.get(Calendar.MONTH), calendarMax.get(Calendar.DAY_OF_MONTH)) { view, year, monthOfYear, dayOfMonth ->
            selectedCalendar.set(year, monthOfYear, dayOfMonth)
        }

        binding.btnCalcIdade.setOnClickListener {
            var mensagem = ""

            if (verificarData(selectedCalendar)){
                mensagem = "Informe uma data que o ano seja maior que o ano atual, ou menor que 1900"
            } else{
                calcIdadeUser()
                mensagem = "Cálculo realizado com sucesso!"
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se um campo não foi preenchido
    private fun verificarData(selectedCalendar: Calendar) : Boolean{
        // Validar a data selecionada
        // Ano seja maior que o ano atual, ou menor que 1900
       return selectedCalendar.before(calendarMin) || selectedCalendar.after(calendarMax)
    }

    private fun calcIdadeUser() {
        // Torna as informações novas visíveis para o usuário
        binding.layoutIdade.visibility = View.VISIBLE

        // Obter a data atual
        val currentDate = Calendar.getInstance()

        // Calcular a diferença entre as datas de nascimento e atual
        var years = currentDate.get(Calendar.YEAR) - selectedCalendar.get(Calendar.YEAR)
        val months = currentDate.get(Calendar.MONTH) - selectedCalendar.get(Calendar.MONTH)
        val days = currentDate.get(Calendar.DAY_OF_MONTH) - selectedCalendar.get(Calendar.DAY_OF_MONTH)

        // Ajustar a idade se o mês atual for anterior ao mês de nascimento,
        // ou se for o mesmo mês, mas o dia atual for anterior ao dia de nascimento
        if (months < 0 || (months == 0 && days < 0)) {
            years--
        }

        // Mostrar a idade calculada
        binding.txtIdadeUserRes.text = "$years anos"
    }
}