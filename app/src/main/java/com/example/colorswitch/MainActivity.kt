package com.example.colorswitch

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openDialogButton: Button = findViewById(R.id.openDialogButton)
        val colorView: View = findViewById(R.id.colorView)

        openDialogButton.setOnClickListener {
            showColorPickerDialog(colorView)
        }
    }

    private fun showColorPickerDialog(colorView: View) {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val editTextR = dialogView.findViewById<EditText>(R.id.editTextR)
        val editTextG = dialogView.findViewById<EditText>(R.id.editTextG)
        val editTextB = dialogView.findViewById<EditText>(R.id.editTextB)

        val seekBarR = dialogView.findViewById<SeekBar>(R.id.seekBarR)
        val seekBarG = dialogView.findViewById<SeekBar>(R.id.seekBarG)
        val seekBarB = dialogView.findViewById<SeekBar>(R.id.seekBarB)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val updateColorView = {
            val r = seekBarR.progress
            val g = seekBarG.progress
            val b = seekBarB.progress
            val color = Color.rgb(r, g, b)
            colorView.setBackgroundColor(color)
        }

        seekBarR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                editTextR.setText(progress.toString())
                updateColorView()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                editTextG.setText(progress.toString())
                updateColorView()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                editTextB.setText(progress.toString())
                updateColorView()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val confirmButton = dialogView.findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
