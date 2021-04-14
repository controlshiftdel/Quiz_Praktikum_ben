package com.example.quiz_praktikum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonSubmit: Button
    private lateinit var etNama: EditText
    private lateinit var etNim: EditText
    private lateinit var rg_domisili: RadioGroup
    private lateinit var tvWelcome: TextView

    lateinit var prefutil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefutil = PreferenceUtil.newInstance(this)

        if (!prefutil.getBoolean("is_login")){
            val intentWelcomeActivity = Intent (this,WelcomeActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentWelcomeActivity)
        }


        etNama = findViewById(R.id.et_nama)
        etNim = findViewById(R.id.et_nim)
        rg_domisili = findViewById(R.id.rg_domisili)
        buttonSubmit = findViewById(R.id.btn_submit)
        tvWelcome = findViewById(R.id.tv_welcome)

        updateData()

        buttonSubmit.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            val gender: String = when (rg_domisili.checkedRadioButtonId) {
                R.id.rb_yk -> "Yogyakarta"
                R.id.rb_luar -> "Luar Jogja"
                else -> ""
            }

            Log.e("TAG", "onCreate() called ${rg_domisili.checkedRadioButtonId}")

            val extras = Bundle().apply {
                putString("nama", nama)
                putString("nim", nim)
                putString("domisili", gender)
            }

            val intentGotoData = Intent(this, DataActivity::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                putExtras(extras)
            }
            startActivity(intentGotoData)
        }

    }

    private fun updateData(){
        val nama = prefutil.getString("nama")
        val welcomMessage = "Selamat Datang. $nama"
        tvWelcome.text = welcomMessage
        if (nama. isNullOrEmpty()){
            tvWelcome.visibility = View.GONE
        }else {
            tvWelcome.visibility = View.VISIBLE
        }
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_submit -> run {
                val DataActivity = Intent(this@MainActivity, DataActivity::class.java)
                startActivity(DataActivity)
                Toast.makeText(this, "Silahkan", Toast.LENGTH_SHORT).show()
            }
        }
    }

}