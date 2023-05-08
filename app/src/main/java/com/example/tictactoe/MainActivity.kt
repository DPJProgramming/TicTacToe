package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create variable for each button by their id
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val newGame = findViewById<Button>(R.id.newGame)

        //create a list of buttons to be passed to resetGame
        val buttonList =
            arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9 )

        //send buttons to resetGame if newGame button is clicked
        newGame.setOnClickListener(){
            resetGame(buttonList)
        }
    }

    /*
    *if the text inside the button is blank
    *sets the button that was clicked to x or o depending on the players turn
    */
    fun setXOrO(view: View) {
        val button = view as Button
        val directions = findViewById<TextView>(R.id.directions)

        if(button.text == "") {
            if (directions.text == "Player X's Turn") {
                button.text = "X"
                changePlayer(directions)
            }
            else if (directions.text == "Player O's Turn") {
                button.text = "O"
                changePlayer(directions)
            }
        }
    }

    /*
    * changes the text in the directions textView determined by
    * which player just had their turn
    */
    fun changePlayer(directions: TextView) {
        if (directions.text == "Player X's Turn") {
            directions.text = "Player O's Turn"
        } else if (directions.text == "Player O's Turn") {
            directions.text = "Player X's Turn"
        }
    }

    /*
    * resets all text on the screen
     */
    fun resetGame(buttonList: Array<Button>) {
        val directions = findViewById<TextView>(R.id.directions)

        //set each buttons text to blank
        for(b in buttonList){
            b.text = ""
        }
        directions.text = "Player X's Turn"
    }
}
