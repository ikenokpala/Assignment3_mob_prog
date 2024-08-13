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
import androidx.activity.enableEdgeToEdge
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.assignment1_mob_prog.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //<!--comment-->
    lateinit var msgEdt: EditText
    lateinit var passDataBtn: Button

    //<!--comment-->

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.button_click)
        buttonClick.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }

        //<!--comment-->

        passDataBtn = findViewById(R.id.idBtnPassData)
        msgEdt = findViewById(R.id.idEdtMsg)
        passDataBtn.setOnClickListener {
            val msg = msgEdt.text.toString()
            val i = Intent(this@MainActivity, NewActivity::class.java)
            i.putExtra("message", msg)
            startActivity(i)
        }

        //<!--comment-->




        // Initialization of the variables #1213488 Okpala Ikechukwu

        val button: Button = findViewById(R.id.btanswer)
        val edtxt1: EditText = findViewById(R.id.thefirst)
        val edtxt2: EditText = findViewById(R.id.thesecond)
        val resultTV: TextView = findViewById(R.id.textResult)

        var flag : String = "sum"
        // spinner items
        var spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("sum","multiply","divide","subtract","mean")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        button.setOnClickListener() {view ->
            val string_a: String = edtxt1.text.toString();
            val string_b: String = edtxt2.text.toString();

            if(string_a.length == 0 || string_b.length == 0) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var a: Int = string_a.toInt()
            var b: Int = string_b.toInt()

            if(flag == "sum")
                resultTV.text = sum(a,b).toString();
            else if (flag == "multiply")
                resultTV.text = multiply(a,b).toString()
            else if(flag == "subtract")
                resultTV.text = subtract(a,b).toString()
            else if (flag == "mean" )
                resultTV.text = mean(a,b).toString()

            when(flag)  { "divide" ->
                resultTV.text = divide(a,b).toString()
                else ->
                    println("Can't perform action")}

        }


        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
                // p2 is the index of selected item }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //     TODO("Not yet implemented")
            }
        }
        }

    public fun sum(a: Int, b: Int): Int{return a+b;}
    public fun multiply(a: Int, b: Int): Int{return a*b;}
    public fun divide(a: Int, b: Int): Int {return a/b;}
    public fun subtract(a: Int, b: Int): Int {return a-b;}
    public fun mean(a: Int, b: Int): Int {return (a+b)/2;}

}