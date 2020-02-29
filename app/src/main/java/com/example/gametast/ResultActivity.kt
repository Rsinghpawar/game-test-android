package com.example.gametast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar!!.hide()

        btn_playAgain.setOnClickListener {
            val prevActivity = Intent(this , RecyclerActivity::class.java)
            startActivity(prevActivity)
            finish()
        }
    }
}
