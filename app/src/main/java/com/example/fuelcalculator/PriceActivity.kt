package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPreco = findViewById<TextView>(R.id.edt_preco)
        val btnBotao = findViewById<Button>(R.id.button_preco)

        val toolbar = findViewById<Toolbar>(R.id.btn_voltar_price)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btnBotao.setOnClickListener {
            val precoStr: String = edtPreco.text.toString()

        if (precoStr == "") {

            Snackbar.make(
                edtPreco, "Preencha todos os campos",
                Snackbar.LENGTH_LONG
            ).show()

        } else {
            val preco = precoStr.toFloat()
            val intent = Intent(this, ConsumoActivity::class.java)
            intent.putExtra("extra_preco", preco)
            startActivity(intent)
        }

        }
    }
}