package com.example.randomizerkt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.randomizerkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstNumber = binding.editTextTextFirstNumber.text
        val secondNumber = binding.editTextTextSecondNumber.text

        fun random(first: Int, second: Int): String {
            val array = arrayListOf<Int>()
            for (i in first..second)
                array.add(i)
            return array.random().toString()
        }


        val myIntent = Intent(this, ResultActivity2::class.java)

        binding.button.setOnClickListener {
            if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                if (firstNumber.toString().toInt() < secondNumber.toString().toInt()) {
                    val first = firstNumber.toString().toInt()
                    val second = secondNumber.toString().toInt()
                    val count = random(first, second)
                    myIntent.putExtra(ResultActivity2.TOTAL_COUNT, count)
                    startActivity(myIntent)
                } else Toast.makeText(this, "The first number must be less than the second!", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "Enter value!", Toast.LENGTH_SHORT).show()
        }
    }
}