package com.example.selectorcolor

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.String

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sbR =  findViewById(R.id.sb_rojo) as SeekBar;
        val sbV =  findViewById(R.id.sb_verde)as SeekBar;
        val sbA =  findViewById(R.id.sb_azul)as SeekBar;

        val tvR =  findViewById(R.id.tv_rojo) as TextView;
        val tvV =  findViewById(R.id.tv_verde)as TextView;
        val tvA =  findViewById(R.id.tv_azul)as TextView;

        val selector = findViewById(R.id.vw_cambiante) as View;

        val hexColor = findViewById(R.id.tv_color) as TextView;

        sbR.max=255
        sbV.max=255
        sbA.max=255

        sbR.setProgress(255)
        sbV.setProgress(255)
        sbA.setProgress(255)

        var numR= sbR.progress
        var numV= sbV.progress
        var numA= sbA.progress

        sbR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                numR = progress
                selector.setBackgroundColor(Color.rgb(numR, numV, numA))
                tvR.setText("Rojo: ${numR}")
                val hex = String.format("#%02X%02X%02X", numR, numV, numA)
                hexColor.setText("Color: ${hex}")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        }
        )

        sbV.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                numV = progress
                selector.setBackgroundColor(Color.rgb(numR, numV, numA))
                tvV.setText("Verde: ${numV}")
                val hex = String.format("#%02X%02X%02X", numR, numV, numA)
                hexColor.setText("Color: ${hex}")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        }
        )

        sbA.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                numA = progress
                selector.setBackgroundColor(Color.rgb(numR, numV, numA))
                tvA.setText("Azul: ${numA}")
                val hex = String.format("#%02X%02X%02X", numR, numV, numA)
                hexColor.setText("Color: ${hex}")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        }
        )

    }
}