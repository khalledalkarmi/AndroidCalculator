package com.example.calculatorlearning

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.notkamui.keval.Keval

/*
todo: add memoryView
todo: fix double float point in equation
 */
class MainActivity2 : AppCompatActivity() {
    //----------Numbers-------------
    private lateinit var num0: Button
    private lateinit var num1: Button
    private lateinit var num2: Button
    private lateinit var num3: Button
    private lateinit var num4: Button
    private lateinit var num5: Button
    private lateinit var num6: Button
    private lateinit var num7: Button
    private lateinit var num8: Button
    private lateinit var num9: Button
    private lateinit var dot: Button
    private lateinit var piButton: Button
    private lateinit var equal: Button
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var multip: Button
    private lateinit var divided: Button
    private lateinit var mod: Button
    private lateinit var backSpace: Button
    private lateinit var clearButton: Button

    private lateinit var displayNum: TextView
    private lateinit var displayAns: TextView
    //-----------memoryList---------------
    private lateinit var memoryEquationList: ArrayList<String>
    private lateinit var memoryAnswerList: ArrayList<String>
    private lateinit var operationList: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        operationList = arrayListOf("+", "-", "-", "*", "/", ".")

        memoryEquationList = ArrayList()
        memoryAnswerList = ArrayList()

        num0 = findViewById(R.id.button0)
        num1 = findViewById(R.id.button1)
        num2 = findViewById(R.id.button2)
        num3 = findViewById(R.id.button3)
        num4 = findViewById(R.id.button4)
        num5 = findViewById(R.id.button5)
        num6 = findViewById(R.id.button6)
        num7 = findViewById(R.id.button7)
        num8 = findViewById(R.id.button8)
        num9 = findViewById(R.id.button9)
        dot = findViewById(R.id.buttonDot)
        piButton = findViewById(R.id.buttonPI)

        equal = findViewById(R.id.buttonEqual)
        plus = findViewById(R.id.buttonAdd)
        minus = findViewById(R.id.buttonSubtact)
        multip = findViewById(R.id.buttonMultiply)
        divided = findViewById(R.id.buttonDivide)
        mod = findViewById(R.id.buttonPercent)
        backSpace = findViewById(R.id.backSpace)
        clearButton = findViewById(R.id.buttonClear)

        displayAns = findViewById(R.id.textViewAnswer)
        displayNum = findViewById(R.id.textViewNumber)

        //--------getNum----------

        num0.setOnClickListener { displayNum.append("0") }
        num1.setOnClickListener { displayNum.append("1") }
        num2.setOnClickListener { displayNum.append("2") }
        num3.setOnClickListener { displayNum.append("3") }
        num4.setOnClickListener { displayNum.append("4") }
        num5.setOnClickListener { displayNum.append("5") }
        num6.setOnClickListener { displayNum.append("6") }
        num7.setOnClickListener { displayNum.append("7") }
        num8.setOnClickListener { displayNum.append("8") }
        num9.setOnClickListener { displayNum.append("9") }
        dot.setOnClickListener { displayNum.append(".") }
        piButton.setOnClickListener { displayNum.append("π") }

        //---------getOperation------------
        plus.setOnClickListener {
            if (!leadingOperation(displayNum.text.toString()))
                displayNum.append("+")
        }
        minus.setOnClickListener {
            if (!leadingOperation(displayNum.text.toString()))
                displayNum.append("-")
        }
        multip.setOnClickListener {
            if (!leadingOperation(displayNum.text.toString()))
                displayNum.append("*")
        }
        divided.setOnClickListener {
            if (!leadingOperation(displayNum.text.toString()))
                displayNum.append("/")
        }
        mod.setOnClickListener {
            if (!leadingOperation(displayNum.text.toString()))
                displayNum.append("%")
        }

        clearButton.setOnClickListener {
            if (displayAns.text.isNotBlank()) {
                memoryAnswerList.add(displayAns.text.toString())
            }
            displayAns.text = ""
            displayNum.text = ""

        }

        backSpace.setOnClickListener {
            backSpace(displayNum.text.toString())
        }

        equal.setOnClickListener {
            var equation: String = havePi(displayNum.text.toString())
            if (leadingOperation(equation)){
                equation=equation.substring(0,equation.length-1)
            }
            memoryEquationList.add(equation)
            val answer: String = Keval.eval(equation).toString()
            memoryAnswerList.add(answer)
            displayAns.text = answer
        }
    }

    private fun backSpace(equation: String) {
        if (equation.isNotBlank()) {
            var newEquation: String = equation
            newEquation = newEquation.substring(0, newEquation.length - 1)
            if (memoryEquationList.isNotEmpty()) {
                memoryEquationList.removeLast()
            }
            memoryEquationList.add(newEquation)
            displayNum.text = newEquation
        }
    }

    private fun leadingOperation(equation: String): Boolean {
        return if (equation.isNotBlank()) {
            val lastChar: String = equation.last().toString()
            operationList.contains(lastChar)
        }else{
            true
        }

    }

    private fun havePi(equation: String):String {
        var newEquation=equation
        for (char in equation){
            if (char == 'π'){
                newEquation=equation.replace("π",Math.PI.toString())
            }
        }
        return newEquation
    }

}
