package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = R.drawable.dice_6
        diceImage.setImageResource(drawableResource)

        rollButton.setOnClickListener { rollDice() }

    }

    private fun rollDice() {
        val edtNum: EditText = findViewById(R.id.edtNum)
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val valor = edtNum.text.toString().toInt()
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()
        val toast: Toast

        if (diceRoll == valor){
            toast = Toast.makeText(this, "Você ganhou", Toast.LENGTH_SHORT)
        }
        else{
             toast = Toast.makeText(this, "Você perdeu", Toast.LENGTH_SHORT)
        }
        toast.show()
     }
   }
        class Dice(private val numSides: Int) {

            fun roll(): Int {
                return (1..numSides).random()
            }

    }