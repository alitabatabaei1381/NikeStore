package ir.at.nikestore.feature.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.at.nikestore.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer , LoginFragment())
        }.commit()
    }
}