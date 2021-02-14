package com.example.calculatorlearning

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.notkamui.keval.Keval
/*
todo: add memory
todo: fix leading zero
todo: fix leading operation
todo: fix trailing zero in float number

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
    private lateinit var Pi: Button

    private lateinit var equal: Button
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var multip: Button
    private lateinit var divided: Button
    private lateinit var mod: Button
    private lateinit var backSpace: Button
    private lateinit var AC: Button

    private lateinit var displayNum: TextView
    private lateinit var displayAns: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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
        Pi=findViewById(R.id.buttonPI)

        equal = findViewById(R.id.buttonEqual)
        plus = findViewById(R.id.buttonAdd)
        minus = findViewById(R.id.buttonSubtact)
        multip = findViewById(R.id.buttonMultiply)
        divided = findViewById(R.id.buttonDivide)
        mod = findViewById(R.id.buttonPercent)
        backSpace = findViewById(R.id.backSpace)
        AC = findViewById(R.id.buttonClear)

        displayAns = findViewById(R.id.textviewnAnswer)
        displayNum = findViewById(R.id.textviewNumber)

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
        Pi.setOnClickListener { displayNum.append("π") }

        //---------getOperation------------
        plus.setOnClickListener { displayNum.append("+") }
        minus.setOnClickListener { displayNum.append("-") }
        multip.setOnClickListener { displayNum.append("*") }
        divided.setOnClickListener { displayNum.append("/") }
        mod.setOnClickListener { displayNum.append("%") }
        AC.setOnClickListener { displayNum.text="" }
        backSpace.setOnClickListener {
            //TODO: backspace method

        }

        equal.setOnClickListener {
            val equation:String = displayNum.text.toString()
            val answer:String = Keval.eval(equation).toString()
            displayAns.text=answer
        }

    }

}
