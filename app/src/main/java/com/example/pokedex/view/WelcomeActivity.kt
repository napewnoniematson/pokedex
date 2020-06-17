package com.example.pokedex.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pokedex.NetworkConnection
import com.example.pokedex.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        if (NetworkConnection.isConnected(applicationContext)) {
            // download data
            clickToContinueTextView.text = getString(R.string.click_to_continue_text)
            clickToContinueTextView.setOnClickListener {
                val intent: Intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        } else {
            Toast.makeText(
                applicationContext,
                getString(R.string.no_network_connection_message_text),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}