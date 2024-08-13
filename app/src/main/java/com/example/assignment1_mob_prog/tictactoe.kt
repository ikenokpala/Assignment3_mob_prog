package com.example.assignment1_mob_prog

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt
import android.content.Intent


class tictactoe : AppCompatActivity() {

    private lateinit var buttons: Array<Array<Button>>
    private var currentPlayer = 'X'
    private var board = Array(3) { CharArray(3) { ' ' } }
    private lateinit var playerTurnTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictt_byike)

        val buttonClick = findViewById<Button>(R.id.btn_goback)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        playerTurnTextView = findViewById(R.id.playerTurn)
        val resetButton: Button = findViewById(R.id.resetButton)

        buttons = Array(3) { row ->
            Array(3) { col ->
                initButton(row, col)
            }
        }

        resetButton.setOnClickListener {
            resetBoard()
        }
    }

    private fun initButton(row: Int, col: Int): Button {
        val button: Button = findViewById(resources.getIdentifier("button${row * 3 + col + 1}", "id", packageName))
        button.setOnClickListener {
            onButtonClick(button, row, col)
        }
        return button
    }

    private fun onButtonClick(button: Button, row: Int, col: Int) {
        if (board[row][col] != ' ') return

        board[row][col] = currentPlayer
        button.text = currentPlayer.toString()

        if (checkWin()) {
            playerTurnTextView.text = "Player $currentPlayer Wins!"
            disableButtons()
        } else if (isBoardFull()) {
            playerTurnTextView.text = "It's a Tie!"
        } else {
            currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
            playerTurnTextView.text = "Player $currentPlayer's Turn"
        }
    }

    private fun checkWin(): Boolean {
        for (i in 0..2) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true
        return false
    }

    private fun isBoardFull(): Boolean {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == ' ') return false
            }
        }
        return true
    }

    private fun disableButtons() {
        for (i in buttons.indices) {
            for (j in buttons[i].indices) {
                buttons[i][j].isEnabled = false
            }
        }
    }

    private fun resetBoard() {
        board = Array(3) { CharArray(3) { ' ' } }
        currentPlayer = 'X'
        playerTurnTextView.text = "Player X's Turn"
        for (i in buttons.indices) {
            for (j in buttons[i].indices) {
                buttons[i][j].text = ""
                buttons[i][j].isEnabled = true
            }
        }
    }


}
