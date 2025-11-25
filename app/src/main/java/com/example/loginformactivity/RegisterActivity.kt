package com.example.loginformactivity

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fullNameEditText: EditText = findViewById(R.id.fullNameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val confirmPasswordEditText: EditText = findViewById(R.id.confirmPasswordEditText)
        val registerButton: Button = findViewById(R.id.registerButton)
        val backToLoginText: TextView = findViewById(R.id.backToLoginText)

        registerButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val pass = passwordEditText.text.toString()
            val confirm = confirmPasswordEditText.text.toString()

            val emailValid = email.contains("@") && email.contains(".")
            val error = when {
                fullName.isEmpty() -> "Full name is required"
                !emailValid -> "Enter a valid email"
                pass.length < 6 -> "Password must be at least 6 characters"
                pass != confirm -> "Passwords do not match"
                else -> null
            }

            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registered! Returning to login.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        backToLoginText.setOnClickListener { finish() }
    }
}
