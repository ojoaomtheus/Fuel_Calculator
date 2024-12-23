package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

const val EXTRA_CONSUMO_KEY = "extra_cosumo"

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val preco = intent.getFloatExtra("extra_preco", 0f)
        val consumo = intent.getFloatExtra("extra_consumo", 0F)

        val imtDistancia = findViewById<TextView>(R.id.edt_distancia)
        val btnDistancia = findViewById<Button>(R.id.button_Distancia)

        val toolbar = findViewById<Toolbar>(R.id.btn_voltar_distancia)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnDistancia.setOnClickListener {
            val distanciaStr: String = imtDistancia.text.toString()

            if (distanciaStr == "") {

                Snackbar.make(
                    imtDistancia, "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val distancia = distanciaStr.toFloat()
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("extra_distancia", distancia)
                intent.putExtra("extra_preco", preco)
                intent.putExtra("extra_consumo", consumo)
                startActivity(intent)
            }


        }


    }
}