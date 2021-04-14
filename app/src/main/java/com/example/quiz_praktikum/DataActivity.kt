package com.example.quiz_praktikum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DataActivity : AppCompatActivity() {
    lateinit var tvNama: TextView
    lateinit var tvNim: TextView
    lateinit var tvDomisili: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val bundle: Bundle? = intent.extras
        val nama = bundle?.getString("nama")
        val nim = bundle?.getString("nim")
        val domisili = bundle?.getString("domisili")

        tvNama = findViewById(R.id.tv_nama)
        tvNim = findViewById(R.id.tv_nim)
        tvDomisili = findViewById(R.id.tv_domisili)

        tvNama.text = nama
        tvNim.text = nim
        tvDomisili.text = domisili

    }
}