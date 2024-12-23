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


class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val preco = intent.getFloatExtra("extra_preco", 0f)

        val edtConsumo = findViewById<TextView>(R.id.edt_consumo)
        val btnBotao = findViewById<Button>(R.id.button_Consumo)

        val toolbar = findViewById<Toolbar>(R.id.btn_voltar_consumo)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnBotao.setOnClickListener {
            val consumoStr: String = edtConsumo.text.toString()

            if (consumoStr == "") {

                Snackbar.make(
                    edtConsumo, "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val consumo = consumoStr.toFloat()
                val intent = Intent(this, DistanciaActivity::class.java)
            intent.putExtra("extra_preco", preco)
            intent.putExtra("extra_consumo", consumo)
            startActivity(intent) }
        }

    }
}
