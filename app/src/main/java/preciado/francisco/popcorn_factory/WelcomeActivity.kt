package preciado.franncisco.popcorn_factory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*
import preciado.francisco.popcorn_factory.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btnStart.setOnClickListener {
            var intent = Intent(this, CatalogActivity::class.java)
            startActivity(intent)
        }
    }
}