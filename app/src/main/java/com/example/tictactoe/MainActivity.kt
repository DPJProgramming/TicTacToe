package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create variable for each button by their id
        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        var button4 = findViewById<Button>(R.id.button4)
        var button5 = findViewById<Button>(R.id.button5)
        var button6 = findViewById<Button>(R.id.button6)
        var button7 = findViewById<Button>(R.id.button7)
        var button8 = findViewById<Button>(R.id.button8)
        var button9 = findViewById<Button>(R.id.button9)

        var newGame = findViewById<Button>(R.id.newGame)

        //set onClickListeners for all buttons
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        //create a list of buttons to be passed to resetGame
        val buttonList =
            arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9 )

        //send buttons to resetGame if newGame button is clicked
        newGame.setOnClickListener(){
            resetGame(buttonList)
        }
    }

    /*
    * determines which button was clicked and sends it to setXOrO function
    */
    override fun onClick(view: View) {
        val button = view as Button
        when (button.id) {
            R.id.button1 -> setXOrO(button)
            R.id.button2 -> setXOrO(button)
            R.id.button3 -> setXOrO(button)
            R.id.button4 -> setXOrO(button)
            R.id.button5 -> setXOrO(button)
            R.id.button6 -> setXOrO(button)
            R.id.button7 -> setXOrO(button)
            R.id.button8 -> setXOrO(button)
            R.id.button9 -> setXOrO(button)

        }
    }

    /*
    *if the text inside the button is blank
    *sets the button that was clicked to x or o depending on the players turn
    */
    fun setXOrO(button: Button) {
        var directions = findViewById<TextView>(R.id.directions)

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
        var directions = findViewById<TextView>(R.id.directions)

        //set each buttons text to blank
        for(b in buttonList){
            b.text = ""
        }

        directions.text = "Player X's Turn"

    }
}
