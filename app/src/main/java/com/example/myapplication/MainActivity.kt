package com.example.myapplication

import android.app.VoiceInteractor
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.O)
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            vibrator()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
     fun vibrator(){
        val mVibratePattern = longArrayOf(0, 300, 800, 300, 800, 300, 800, 300)
        val mAmplitudes      = intArrayOf(0, 255, 0, 255, 0, 255, 0, 255)
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator.hasVibrator()){
            vibrator.vibrate(VibrationEffect.createWaveform(mVibratePattern,mAmplitudes,-1))
        }else{
            Toast.makeText(this@MainActivity,"Cihaz Titreşim Desteklemiyor",Toast.LENGTH_SHORT).show()
        }
    }
}
