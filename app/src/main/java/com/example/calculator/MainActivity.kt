package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        buttonLeftBracket.setOnClickListener {
            input.text = addToInputText(buttonValue = "(")
        }

        buttonRightBracket.setOnClickListener {
            input.text = addToInputText(buttonValue = ")")
        }

        button_0.setOnClickListener {
            input.text = addToInputText(buttonValue = "0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText(buttonValue = "1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText(buttonValue = "2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText(buttonValue = "3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText(buttonValue = "4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText(buttonValue = "5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText(buttonValue = "6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText(buttonValue = "7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText(buttonValue = "8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText(buttonValue = "9")
        }
        buttonPoint.setOnClickListener {
            input.text = addToInputText(buttonValue = ".")
        }
        buttonDivision.setOnClickListener {
            input.text = addToInputText(buttonValue = "÷")
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText(buttonValue = "×")
        }
        buttonMinus.setOnClickListener {
            input.text = addToInputText(buttonValue = "-")
        }
        buttonPlus.setOnClickListener {
            input.text = addToInputText(buttonValue = "+")
        }
        buttonEqual.setOnClickListener {
            showResult()

        }



    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"

    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                //Error Message
                output.text = "Pizdes"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                //Result
                output.text = DecimalFormat ("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception){
                //Error
            output.text = "Pizdes"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}