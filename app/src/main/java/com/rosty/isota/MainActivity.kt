package com.rosty.isota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuarioEditText: EditText = findViewById(R.id.usuario)
        val continuarButton: Button = findViewById(R.id.continuar)

        continuarButton.setOnClickListener {
            val intent = Intent(this, CreditActivity::class.java).apply {
                putExtra("usuario", usuarioEditText.text.toString())
            }
            startActivity(intent)
        }
    }
}