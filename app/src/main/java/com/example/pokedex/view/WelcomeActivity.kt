package com.example.pokedex.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pokedex.NetworkConnection
import com.example.pokedex.R
import com.example.pokedex.view.animations.ZoomCloseFarAnimator
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlin.random.Random

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val backgroundImageId = when (Random.nextInt(3)) {
            0 -> R.drawable.welcome_background_0
            1 -> R.drawable.welcome_background_1
            2 -> R.drawable.welcome_background_2
            else -> R.drawable.welcome_background_0
        }
        welcome_layout.background = getDrawable(backgroundImageId)

        if (NetworkConnection.isConnected(applicationContext)) {
            // download data
            clickToContinueTextView.text = getString(R.string.click_to_continue_text)
            ZoomCloseFarAnimator().zoom(clickToContinueTextView)
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