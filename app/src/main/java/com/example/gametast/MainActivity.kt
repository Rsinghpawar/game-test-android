package com.example.gametast

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn_toRecycler.setOnClickListener {
           val intent = Intent(this , RecyclerActivity::class.java)
           startActivity(intent)
       }
        val ids = listOf<TextView>(
            txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9
            , txt10, txt11, txt12, txt13, txt14, txt15, txt16
        )

        var start = 0
        bnt_play.setOnClickListener {
            val playButton = Random.nextInt(1, 7)
            txt_result.text = playButton.toString()
            ids[start].setBackgroundColor(Color.WHITE)
            //   Toast.makeText(this, "start = $start playbutton = $playButton", Toast.LENGTH_SHORT).show()
            if (start + playButton <= 15) {
                start += playButton
            } else {
                var required = 15 - start
                Toast.makeText(this, "$required to win", Toast.LENGTH_SHORT).show()
            }
            ids[start].setBackgroundColor(Color.YELLOW)
            if (start == 15) {
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "You Won", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
