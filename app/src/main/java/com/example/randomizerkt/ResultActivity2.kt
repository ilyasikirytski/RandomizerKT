package com.example.randomizerkt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.randomizerkt.databinding.ActivityResult2Binding

class ResultActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityResult2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResult2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val textResult = binding.textView
        val result = "Random result: ${intent.getStringExtra(TOTAL_COUNT)}"
        textResult.text = result
    }

    companion object {
        const val TOTAL_COUNT = "total_count"
    }
}