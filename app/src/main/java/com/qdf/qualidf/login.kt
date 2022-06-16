package com.qdf.qualidf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isInvisible
import java.io.File
import java.io.InputStream










class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val status_login = findViewById(R.id.status_login) as TextView
        val entrar_but = findViewById(R.id.ENVIAR_BT) as Button
        val cpftext = findViewById(R.id.CPF_L) as EditText
        val passwordtxt = findViewById(R.id.SENHA_L) as EditText

        entrar_but.setOnClickListener {

            val valuecpf = cpftext.text
            val valuepassword = passwordtxt.text


            val inputStream: InputStream = File("src/main/res/login.txt").inputStream()
            val lineList = mutableListOf<String>()
            inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
            lineList.forEach{

                val line = it
                val data_line = line.split(":")

                val cpf = data_line[0]
                val password = data_line[1]
                if ((cpf=valuecpf) && (password=valuepassword)){

                    val intent = Intent(this, perfil::class.java)
                    intent.putExtra("Name_usuario", data_line[2])
                    startActivity(intent)


                } else {
                    status_login.text = "CPF OU SENHA INCORRETO, POR FAVOR VERIFICAR AS INFOMARÇÕES E TENTE NOVAMENTE"
                    status_login.visibility = View.VISIBLE

                }

            }





            startActivity(Intent(this, ::class.java))
        }

    }
}