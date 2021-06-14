package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvnumbers= findViewById<RecyclerView>(R.id.rvnumbers)
        rvnumbers.layoutManager=LinearLayoutManager(baseContext)

        var numberAdapter=NumberRecyclerViewAdapter((fibonacci(100)))
        rvnumbers.adapter=numberAdapter
    }
}
fun fibonacci(nums:Int):List<BigInteger>{
    var number= MutableList<BigInteger>(nums,{ BigInteger.ZERO})
    var num1=BigInteger.ZERO
    var num2=BigInteger.ONE
    number[0]=num1
    number[1]=num2
    for(a in 1..nums){
        var sum=num1+num2
        num1=num2
        num2=sum
        number[a-1]=num1
    }
    return number
}