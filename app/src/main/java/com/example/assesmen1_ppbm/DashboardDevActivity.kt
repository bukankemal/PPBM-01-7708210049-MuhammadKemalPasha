package com.example.assesmen1_ppbm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import com.gtappdevelopers.kotlingfgproject.SliderAdapter
import com.ncorti.slidetoact.SlideToActView
import com.smarteist.autoimageslider.SliderView



import java.util.*

class DashboardDevActivity : AppCompatActivity() {
    lateinit var stav : SlideToActView.OnSlideCompleteListener
    // on below line we are creating a variable
    // for our array list for storing our images.
    lateinit var imageUrl: ArrayList<String>

    // on below line we are creating
    // a variable for our slider view.
    lateinit var sliderView: SliderView

    // on below line we are creating
    // a variable for our slider adapter.
    lateinit var sliderAdapter: SliderAdapter

    private fun setupEventCallbacks() {
        stav.onSlideComplete(SlideToActView(this))

        // ... (other existing code)
    }

    private var initialX: Float = 0f
    private var slideThreshold: Float = 300f

    private fun moveToAnotherActivity() {
        val intent = Intent(this, DevActivity::class.java)
        startActivity(intent)
    }

    private fun handleSlideTouch(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                initialX = event.x
            }
            MotionEvent.ACTION_UP -> {
                val deltaX = event.x - initialX
                if (deltaX > slideThreshold) {
                    // Slide complete
                    moveToAnotherActivity()
                } else {
                    // Not enough slide distance, handle as needed (e.g., reset)
                }
            }
        }
    }

    // ... (other existing code)



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_dev)

        val btnNextPage = findViewById<SlideToActView>(R.id.example)
        //btnNextPage.onSlideCompleteListener?.onSlideComplete(SlideToActView(this))


            val slideToActView = findViewById<SlideToActView>(R.id.example)

            slideToActView.setOnTouchListener { _, event ->
                handleSlideTouch(event)
                true
            }

        // on below line we are initializing our slier view.




    }



}