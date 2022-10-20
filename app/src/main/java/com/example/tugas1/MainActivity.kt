package com.example.tugas1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnenter : Button
    lateinit var roti : Button
    lateinit var susu : Button
    lateinit var keju : Button
    lateinit var etName : EditText
    var harga = 0
    var hasil = 0
    var pilihan = String()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnenter = findViewById(R.id.btnenter)
        etName = findViewById(R.id.et_name)
        roti = findViewById(R.id.btnroti)
        susu = findViewById(R.id.btnsusu)
        keju = findViewById(R.id.btnkeju)

            roti.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(
                        applicationContext,
                        "Anda Memilih Roti",
                        Toast.LENGTH_SHORT
                    ).show()
                    harga = 10
                    pilihan = when(harga){
                        10 -> "roti"
                        12 -> "susu"
                        else -> "keju"
                    }
                }
            })
            susu.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(
                        applicationContext,
                        "Anda Memilih Susu",
                        Toast.LENGTH_SHORT
                    ).show()
                    harga = 12
                    pilihan = when(harga){
                        10 -> "roti"
                        12 -> "susu"
                        else -> "keju"
                    }
                }
            })
            keju.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(
                        applicationContext,
                        "Anda Memilih Keju",
                        Toast.LENGTH_SHORT
                    ).show()
                    harga = 14
                    pilihan = when(harga){
                        10 -> "roti"
                        12 -> "susu"
                        else -> "keju"
                    }
                }
            })

            btnenter.setOnClickListener {
            if (etName.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Silahkan masukan jumlah produk",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                hasil = etName.text.toString().trim().toInt() * harga
                Toast.makeText(
                    applicationContext,
                    "Anda memilih "+ etName.text +" " + pilihan +
                            ", total yang harus anda bayar adalah :" +" Rp. "+ hasil + ".000",
                    Toast.LENGTH_SHORT
                ).show()
                etName.text = null
            }
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("pilihan", etName.text.toString())
                startActivity(intent)
        }
    }

}





