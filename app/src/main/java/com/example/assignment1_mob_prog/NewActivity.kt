package com.example.assignment1_mob_prog

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt
import android.content.Intent
import android.widget.Toast


class NewActivity : AppCompatActivity() {
    //<!--comment-->
    lateinit var msgTV: TextView


    //<!--comment-->

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_activity)

        //<!--comment-->

        msgTV = findViewById(R.id.idTVMsg)
        msgTV.text = intent.extras?.getString("message")  ?: "No message found"



        //<!--comment-->

        val buttonClick = findViewById<Button>(R.id.button_return)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.button_act3)
        button.setOnClickListener {
            val intent = Intent(this, tictactoe::class.java)
            startActivity(intent)
        }




    }
}