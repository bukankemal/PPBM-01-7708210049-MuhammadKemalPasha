package com.example.assesmen1_ppbm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.gtappdevelopers.kotlingfgproject.SliderAdapter
import com.smarteist.autoimageslider.SliderView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DevStatisticFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DevStatisticFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var imageUrl: ArrayList<String>
    private lateinit var sliderView: SliderView

    private var initialY = 0f
    private val slideThreshold = 100f // Adjust the threshold as needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val _view: View = inflater.inflate(R.layout.fragment_dev_statistic, container, false)
        var _sliderimg = _view.findViewById<SliderView>(R.id.imageSlider)

        sliderView = _view.findViewById(R.id.imageSlider)

        imageUrl = ArrayList()
        imageUrl.add("https://i.imgur.com/IZ3If74.jpg")
        imageUrl.add("https://i.imgur.com/xt2QHYd.png")
        imageUrl.add("https://i.imgur.com/6yu67Zl.png")
        sliderAdapter = SliderAdapter(imageUrl)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()

        val touchableView = _view.findViewById<ImageView>(R.id.devbgstat)



        touchableView.setOnTouchListener { _, event ->
            handleSlideTouch(event)
            true
        }

        return _view
    }

    private fun handleSlideTouch(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                initialY = event.y
            }
            MotionEvent.ACTION_UP -> {
                val deltaX = event.y - initialY
                if (deltaX > slideThreshold) {
                    // Slide complete
                    btmSheet()
                } else {
                    // Not enough slide distance, handle as needed (e.g., reset)
                }
            }
        }
    }

    private fun btmSheet(){

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DevStatisticFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DevStatisticFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}