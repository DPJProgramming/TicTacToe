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
            }
            else if (directions.text == "Player O's Turn") {
                button.text = "O"
            }

           if(!winner()){
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
    *Determines if there is a winner of the game
     */
    fun winner():Boolean{
        var winner : Boolean = false
        val button1 = findViewById<Button>(R.id.button1).text
        val button2 = findViewById<Button>(R.id.button2).text
        val button3 = findViewById<Button>(R.id.button3).text
        val button4 = findViewById<Button>(R.id.button4).text
        val button5 = findViewById<Button>(R.id.button5).text
        val button6 = findViewById<Button>(R.id.button6).text
        val button7 = findViewById<Button>(R.id.button7).text
        val button8 = findViewById<Button>(R.id.button8).text
        val button9 = findViewById<Button>(R.id.button9).text

        val winnerMessage = findViewById<TextView>(R.id.directions)

        //determines if there is a tie game
        if(button1 != "" && button2 != "" && button3 != "" &&
            button4 != "" && button5 != "" && button6 != "" &&
            button7 != "" && button8 != "" && button9 != "" &&
            button1 != "" && button4 != "" && button7 != "" &&
            button2 != "" && button5 != "" && button8 != "" &&
            button3 != "" && button6 != "" && button9 != "" &&
            button1 != "" && button5 != "" && button9 != "" &&
            button3 != "" && button5 != "" && button7 != "" ){

            winnerMessage.text = "Cat's Game"
            winner = true
        }

        //determines is player x wins
        if( (button1 == "X" && button2 == "X" && button3 == "X") ||
            (button4 == "X" && button5 == "X" && button6 == "X") ||
            (button7 == "X" && button8 == "X" && button9 == "X") ||
            (button1 == "X" && button4 == "X" && button7 == "X") ||
            (button2 == "X" && button5 == "X" && button8 == "X") ||
            (button3 == "X" && button6 == "X" && button9 == "X") ||
            (button1 == "X" && button5 == "X" && button9 == "X") ||
            (button3 == "X" && button5 == "X" && button7 == "X")){

            winnerMessage.text = "Player X Wins!!!"
            winner = true
        }

        //determines if player O wins
        if( (button1 == "O" && button2 == "O" && button3 == "O") ||
            (button4 == "O" && button5 == "O" && button6 == "O") ||
            (button7 == "O" && button8 == "O" && button9 == "O") ||
            (button1 == "O" && button4 == "O" && button7 == "O") ||
            (button2 == "O" && button5 == "O" && button8 == "O") ||
            (button3 == "O" && button6 == "O" && button9 == "O") ||
            (button1 == "O" && button5 == "O" && button9 == "O") ||
            (button3 == "O" && button5 == "O" && button7 == "O")){

            winnerMessage.text = "Player O Wins!!!"
            winner = true
        }

        return winner
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
