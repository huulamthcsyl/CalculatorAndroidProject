package com.example.calculator

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var textResult: TextView
    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textResult = findViewById(R.id.text_result)

        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)
        findViewById<Button>(R.id.btnDot).setOnClickListener(this)
        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
        findViewById<Button>(R.id.btnSub).setOnClickListener(this)
        findViewById<Button>(R.id.btnMul).setOnClickListener(this)
        findViewById<Button>(R.id.btnDiv).setOnClickListener(this)
        findViewById<Button>(R.id.btnEqual).setOnClickListener(this)
        findViewById<Button>(R.id.btnC).setOnClickListener(this)
        findViewById<Button>(R.id.btnCE).setOnClickListener(this)
        findViewById<Button>(R.id.btnBackspace).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id;
        when (id) {
            R.id.btn0 -> {
                addDigit(0)
            }
            R.id.btn1 -> {
                addDigit(1)
            }
            R.id.btn2 -> {
                addDigit(2)
            }
            R.id.btn3 -> {
                addDigit(3)
            }
            R.id.btn4 -> {
                addDigit(4)
            }
            R.id.btn5 -> {
                addDigit(5)
            }
            R.id.btn6 -> {
                addDigit(6)
            }
            R.id.btn7 -> {
                addDigit(7)
            }
            R.id.btn8 -> {
                addDigit(8)
            }
            R.id.btn9 -> {
                addDigit(9)
            }
            R.id.btnDot -> {
                // TODO
            }
            R.id.btnAdd -> {
                op = 1
                state = 2
            }
            R.id.btnSub -> {
                op = 2
                state = 2
            }
            R.id.btnMul -> {
                op = 3
                state = 2
            }
            R.id.btnDiv -> {
                op = 4
                state = 2
            }
            R.id.btnEqual -> {
                when (op) {
                    1 -> {
                        op1 += op2
                    }
                    2 -> {
                        op1 -= op2
                    }
                    3 -> {
                        op1 *= op2
                    }
                    4 -> {
                        op1 /= op2
                    }
                }
                textResult.text = op1.toString()
                op2 = 0
                state = 1
            }
            R.id.btnC -> {
                op1 = 0
                op2 = 0
                state = 1
                textResult.text = "0"
            }
            R.id.btnCE -> {
                if (state == 1) {
                    op1 = 0
                } else {
                    op2 = 0
                }
                textResult.text = "0"
            }
            R.id.btnBackspace -> {
                if (state == 1) {
                    op1 /= 10
                    textResult.text = op1.toString()
                } else {
                    op2 /= 10
                    textResult.text = op2.toString()
                }
            }
        }
    }

    fun addDigit(digit: Int) {
        if (state == 1) {
            op1 = op1 * 10 + digit
            textResult.text = op1.toString()
        } else {
            op2 = op2 * 10 + digit
            textResult.text = op2.toString()
        }
    }
}