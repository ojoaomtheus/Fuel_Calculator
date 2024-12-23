package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text


class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val preco = intent.getFloatExtra("extra_preco", 0f)
        val consumo = intent.getFloatExtra("extra_consumo", 0f)
        val  distancia = intent.getFloatExtra("extra_distancia", 0f)

        val gastoTotal = if (consumo != 0f) {
            (distancia / consumo) * preco
        } else { 0f }

        val tvResultado = findViewById<TextView>(R.id.resultado)
        val tvPreco = findViewById<TextView>(R.id.preco_resultado)
        val tvConsumo = findViewById<TextView>(R.id.consumo_resultado)
        val tvDistancia = findViewById<TextView>(R.id.Km_resultado)
        val tvRevisao = findViewById<TextView>(R.id.revisao_dados)

        val resultadoFormatado = String.format ("R$ %.2f", gastoTotal)
        val precoFormatado = String.format("R$ %2f", preco)

        tvResultado.text = resultadoFormatado
        tvPreco.text = precoFormatado
        tvConsumo.text = consumo.toString()
        tvDistancia.text = distancia.toString()
        tvRevisao.text = "Revisão dos dados inseridos"

        val btnNovoCalculo = findViewById<Button>(R.id.btn_novo_calculo)
        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}