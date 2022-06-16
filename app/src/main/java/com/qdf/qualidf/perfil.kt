package com.qdf.qualidf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val name_textview = findViewById(R.id.name_textview) as TextView
        name_textview.text = intent.getStringExtra("Name_usuario")

    }
}