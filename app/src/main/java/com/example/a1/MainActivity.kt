package com.example.a1



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            btn_0.setOnCkickListener {setTextFields("0")}
            btn_1.setOnCkickListener {setTextFields("1")}
            btn_2.setOnCkickListener {setTextFields("2")}
            btn_3.setOnCkickListener {setTextFields("3")}
            btn_4.setOnCkickListener {setTextFields("4")}
            btn_5.setOnCkickListener {setTextFields("5")}
            btn_6.setOnCkickListener {setTextFields("6")}
            btn_7.setOnCkickListener {setTextFields("7")}
            btn_8.setOnCkickListener {setTextFields("8")}
            btn_9.setOnCkickListener {setTextFields("9")}

            minus_btn.setOnCkickListener {setTextFields("-")}
            plus_btn.setOnCkickListener {setTextFields("+")}
            umn_btn.setOnCkickListener {setTextFields("*")}
            delen_btn.setOnCkickListener {setTextFields("/")}
            left_btn.setOnCkickListener {setTextFields("(")}
            right_btn.setOnCkickListener {setTextFields(")")}

            delete_btn.setOnClickListener{
                math_operation.text=""
                rezult_text.text=""
            }
            btn_back.setOnClickListener{
                val str = math_operation.text.toString()
                if (str.isNotEmpty())
                    math_operation.text = str.subsrting(0, str.lenght -1)

                rezult_text.text=""


            }

            btn_ravno.setOnCkickListener{
                try {
                    val ex =ExpressionBuilder(math_operation.text.toSting()).build()
                    val result = ex.evaluate()

                    val longRes = result.toLong()
                    if (result==longRes.toDouble())
                        result_text.text = longRes.toString()
                    else
                        result_text.text = result.toString()


                } catch (e:Exception){
                    Log.d("Ошибка","Сообщение: ${e.message}")
                }
            }

            }
    fun setTextFields(str: String){
        if (result_text.text !=""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }
}