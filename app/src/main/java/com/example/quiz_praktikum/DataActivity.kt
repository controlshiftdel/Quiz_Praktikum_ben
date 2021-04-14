package com.example.quiz_praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class DataActivity : AppCompatActivity() {
    lateinit var tvNama: TextView
    lateinit var tvNim: TextView
    lateinit var tvDomisili: TextView
    lateinit var bt_koreksi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val bundle: Bundle? = intent.extras
        val nama = bundle?.getString("nama")
        val nim = bundle?.getString("nim")
        val domisili = bundle?.getString("domisili")

        val fragmentKoreksi = KoreksiFragment()
        val fragment : Fragment? =  supportFragmentManager.findFragmentByTag(KoreksiFragment::class.java.simpleName)


        tvNama = findViewById(R.id.tv_nama)
        tvNim = findViewById(R.id.tv_nim)
        tvDomisili = findViewById(R.id.tv_domisili)

        tvNama.text = nama
        tvNim.text = nim
        tvDomisili.text = domisili

        bt_koreksi = findViewById(R.id.bt_koreksi)

        bt_koreksi?.setOnClickListener {
            Toast.makeText( this, "Terkoreksi", Toast.LENGTH_LONG).show()
        }


    }

}