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
        val intent = Intent(this, RegisterActivity::class.java)
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
        sliderView = findViewById(R.id.slider)

        // on below line we are initializing
        // our image url array list.
        imageUrl = ArrayList()

        // on below line we are adding data to our image url array list.
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Fdsa-self-paced-thumbnail.png&w=1920&q=75") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Fdata-science-live-thumbnail.png&w=1920&q=75") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Ffull-stack-node-thumbnail.png&w=1920&q=75") as ArrayList<String>

        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = SliderAdapter( imageUrl)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        sliderView.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        sliderView.scrollTimeInSec = 3

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        sliderView.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()



    }



}