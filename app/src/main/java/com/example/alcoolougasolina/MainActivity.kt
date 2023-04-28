package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState?.let {
            percentual = it.getDouble("percentual")
        }
        val btCalc = findViewById<Button>(R.id.btCalcular)
        val swiftPercentual = findViewById<Switch>(R.id.swPercentual)
        btCalc.setOnClickListener { compararValores(it) }
        swiftPercentual.setOnCheckedChangeListener { _, isChecked ->
            percentual = if (isChecked) 0.75 else 0.7
            swiftPercentual.text=percentual.toString()
        }
        Log.d("PDM23", "No onCreate, $percentual")
    }

    fun compararValores(v: View) {
        val vGasolina = findViewById<EditText>(R.id.etGasolina)
        val vAlcool = findViewById<EditText>(R.id.etAlcool)
        val vComparado = vGasolina.text.toString().toDouble() * percentual
        val melhorCombustivel = if (vComparado < vAlcool.text.toString().toDouble()) {
            "g"
        } else {
            "a"
        }
        val textResultado = findViewById<TextView>(R.id.tResultado)
        Log.d("PDM23", "$melhorCombustivel, Resultado: R$ ${String.format("%.2f", vComparado)}")
        if (melhorCombustivel == "a") {
            textResultado.setText(String.format("Melhor o Álcool"))
            textResultado.setTextColor(getColor(R.color.alcool))
        } else {
            textResultado.setText(String.format("Melhor a Gasolina"))
            textResultado.setTextColor(getColor(R.color.gas))
        }
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("percentual", percentual)
    }
}