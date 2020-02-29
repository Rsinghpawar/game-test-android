package com.example.gametast

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.layout_for_recycler.view.*
import kotlin.random.Random

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        supportActionBar!!.hide()

        val list = mutableListOf<Int>()
        for (i in 16 downTo 1) list.add(i)
        val adapterClassObject = AdapterForRecycler(this, list)
        activity_recycler.layoutManager = GridLayoutManager(this, 4)
        activity_recycler.adapter = adapterClassObject

        var start = list.size - 1
        btn_play.setOnClickListener {
            val random = (1..6).random()
            txt_dice.text = random.toString()
            activity_recycler!!.layoutManager!!.findViewByPosition(start)!!.txt_postion.setBackgroundColor(
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
            )
            if (start - random >= 0) {
                start -= random
            } else
                txt_required.text = "$start required to win !!"
            activity_recycler!!.layoutManager!!.findViewByPosition(start)!!.txt_postion.setBackgroundColor(
                ContextCompat.getColor(this, R.color.colorAccent)
            )

            if (start == 0) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("You Won")
                builder.setPositiveButton(
                    "Play Again"
                ) { dlg, dlg2 ->
                    finish()
                    startActivity(intent)
                }
                val alert = builder.create()
                alert.setCancelable(false)
                alert.show()
            }
        }

    }
}
