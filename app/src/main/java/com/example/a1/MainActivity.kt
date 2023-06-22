package com.example.a1


import kotlinx.android.synthetic.main.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btn_0
import kotlinx.android.synthetic.main.activity_main.btn_1
import kotlinx.android.synthetic.main.activity_main.btn_2
import kotlinx.android.synthetic.main.activity_main.btn_3
import kotlinx.android.synthetic.main.activity_main.btn_4
import kotlinx.android.synthetic.main.activity_main.btn_5
import kotlinx.android.synthetic.main.activity_main.btn_6
import kotlinx.android.synthetic.main.activity_main.btn_7
import kotlinx.android.synthetic.main.activity_main.btn_8
import kotlinx.android.synthetic.main.activity_main.btn_9
import kotlinx.android.synthetic.main.activity_main.btn_back
import kotlinx.android.synthetic.main.activity_main.btn_ravno
import kotlinx.android.synthetic.main.activity_main.delen_btn
import kotlinx.android.synthetic.main.activity_main.delete_btn
import kotlinx.android.synthetic.main.activity_main.left_btn
import kotlinx.android.synthetic.main.activity_main.math_operation
import kotlinx.android.synthetic.main.activity_main.minus_btn
import kotlinx.android.synthetic.main.activity_main.plus_btn
import kotlinx.android.synthetic.main.activity_main.rezult_text
import kotlinx.android.synthetic.main.activity_main.right_btn
import kotlinx.android.synthetic.main.activity_main.umn_btn
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            btn_0.setOnClickListener {setTextFields("0")}
            btn_1.setOnClickListener {setTextFields("1")}
            btn_2.setOnClickListener {setTextFields("2")}
            btn_3.setOnClickListener {setTextFields("3")}
            btn_4.setOnClickListener {setTextFields("4")}
            btn_5.setOnClickListener {setTextFields("5")}
            btn_6.setOnClickListener {setTextFields("6")}
            btn_7.setOnClickListener {setTextFields("7")}
            btn_8.setOnClickListener {setTextFields("8")}
            btn_9.setOnClickListener {setTextFields("9")}

            minus_btn.setOnClickListener {setTextFields("-")}
            plus_btn.setOnClickListener {setTextFields("+")}
            umn_btn.setOnClickListener {setTextFields("*")}
            delen_btn.setOnClickListener {setTextFields("/")}
            left_btn.setOnClickListener {setTextFields("(")}
            right_btn.setOnClickListener {setTextFields(")")}

            delete_btn.setOnClickListener{
                math_operation.text=""
                rezult_text.text=""
            }
            btn_back.setOnClickListener{
                val str = math_operation.text.toString()
                if (str.isNotEmpty())
                    math_operation.text = str.substring(0, str.length -1)

                rezult_text.text=""


            }

            btn_ravno.setOnClickListener{
                try {
                    val ex =ExpressionBuilder(math_operation.text.toString()).build()
                    val result = ex.evaluate()

                    val longRes = result.toLong()
                    if (result==longRes.toDouble())
                        rezult_text.text = longRes.toString()
                    else
                        rezult_text.text = result.toString()


                } catch (e:Exception){
                    Log.d("Ошибка","Сообщение: ${e.message}")
                }
            }

            }
    fun setTextFields(str: String){
        if (rezult_text.text !=""){
            math_operation.text = rezult_text.text
            rezult_text.text = ""
        }
        math_operation.append(str)
    }
}
