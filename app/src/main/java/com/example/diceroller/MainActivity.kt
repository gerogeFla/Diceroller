package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //allows user to roll dice
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)


        rollButton.setOnClickListener { rollDice() }

    }
//roll dice update text
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)
        resultTextView.text = diceRoll.toString()
//change image to match dice roll
    val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    diceImage.setImageResource(drawableResource)
//have little notification show up when you rolla 4
    val luckyNumb = 4
    if (diceRoll == luckyNumb){
        val toast = Toast.makeText(this, "you win", Toast.LENGTH_SHORT)
        toast.show()
    }
    }



    private class Dice(val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}
