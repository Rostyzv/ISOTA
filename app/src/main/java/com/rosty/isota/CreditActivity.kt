package com.rosty.isota

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val appName = intent.getStringExtra("usuario")
        val appVersion = "1"

        val textView = findViewById<TextView>(R.id.bienvenido)
        textView.text = "$appName estás usando la versión $appVersion de ISOTA"

        val contactButton = findViewById<Button>(R.id.contactButton)
        contactButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:rostiszv@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app $appName")
            }
            startActivity(emailIntent)
        }
    }
}
