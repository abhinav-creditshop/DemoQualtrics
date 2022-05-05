package com.example.demoqualtrics

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.qualtrics.digital.Qualtrics

class MainActivity : AppCompatActivity() {

    private var button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button?.setOnClickListener {
            openPopupsForQualtrics()
        }
    }

    private fun openPopupsForQualtrics() {
        Qualtrics.instance().evaluateProject { targetingResults ->
            for (result in targetingResults.entries) if (result.value.passed()) {
                Qualtrics.instance().displayIntercept(applicationContext, result.key)
            }
        }
    }
}