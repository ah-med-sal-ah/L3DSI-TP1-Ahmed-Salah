package com.example.compter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Variable entière initialisée à 0
    private var compteur = 0
    private lateinit var textViewCompteur: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Récupérer les composants grâce à leurs identifiants
        textViewCompteur = findViewById(R.id.textViewCompteur)
        val buttonIncrementer = findViewById<Button>(R.id.buttonIncrementer)
        val buttonDecrementer = findViewById<Button>(R.id.buttonDecrementer)
        val buttonReinitialiser = findViewById<Button>(R.id.buttonReinitialiser)

        // Programmer le clic sur chaque bouton
        buttonIncrementer.setOnClickListener {
            compteur++
            afficherCompteur()
        }
        buttonDecrementer.setOnClickListener {
            compteur--
            afficherCompteur()
        }
        buttonReinitialiser.setOnClickListener {
            compteur = 0
            afficherCompteur()
        }

        afficherCompteur()
    }

    // Actualiser le TextView après chaque modification
    private fun afficherCompteur() {
        textViewCompteur.text = compteur.toString()
    }
}