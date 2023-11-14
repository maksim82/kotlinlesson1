package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var valueTextView: TextView
    private var counter = 0
    private lateinit var inputField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valueTextView = findViewById(R.id.valueTextView)
        inputField = findViewById(R.id.inputField)
        updateValueText()

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0)
            updateValueText()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }

    fun onIncrementClick(view: View) {
        val increment = inputField.text.toString().toIntOrNull() ?: 1
        counter += increment;
        updateValueText()
    }

    fun onDecrementClick(view: View) {
        val decrement = inputField.text.toString().toIntOrNull() ?: 1
        counter -= decrement;
        updateValueText()
    }

    fun onSecondButtonClick(view: View) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("counter", counter.toString())
        startActivity(intent)
    }

    private fun updateValueText() {
        valueTextView.text = counter.toString()
    }
}