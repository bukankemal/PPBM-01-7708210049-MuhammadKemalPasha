package com.example.assesmen1_ppbm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.assesmen1_ppbm.databinding.FragmentLibraryBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LibraryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LibraryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listData: ListData
    private lateinit var listAdapter: ListAdapter
    private var _binding: FragmentLibraryBinding? = null;
    private val binding get() = _binding!!;

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
        //val _binding = FragmentLibraryBinding.inflate(inflater,container,false);
        //val _view = binding.root
        val _view: View = inflater!!.inflate(R.layout.fragment_library, container, false)
        val listview: ListView = _view.findViewById(R.id.listview)



        var dataArrayList = ArrayList<ListData?>()
        val imageList = intArrayOf(
            R.drawable.acloudy1,
            R.drawable.acloudy2,
            R.drawable.acloudy3,
            R.drawable.nomak1,
            R.drawable.taishi1
        )
        val artistList = arrayOf(
            "acloudyskye",
            "acloudyskye",
            "acloudyskye",
            "Nomak",
            "Taishi"
        )
        val titleList = arrayOf(
            "Heliov",
            "Curses",
            "Drowning Cry",
            "A_REASON_TO_PRAY",
            "White Flame"
        )

        val descList = arrayOf(
            R.string.acloudyDesc1,
            R.string.acloudyDesc2,
            R.string.acloudyDesc3,
            R.string.NomakDesc1,
            R.string.TaishiDesc1,
        )

        for (i in imageList.indices) {
            listData = ListData(
                artistList[i],
                titleList[i], imageList[i],descList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(requireContext(),dataArrayList)
        listview.adapter = listAdapter
        listview.isClickable = true
        // Inflate the layout for this fragment

        listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, _view, i, l ->
            val transaction = Intent(requireActivity(),ListItemDetailActivity::class.java)
            //val transaction2 = activity?.supportFragmentManager?.beginTransaction()
            transaction.putExtra("artist", artistList[i])
            transaction.putExtra("title", titleList[i])
            transaction.putExtra("desc", descList[i])
            transaction.putExtra("image", imageList[i])
            startActivity(transaction)

            //transaction2?.replace(R.id.fragment_container, ListItemDetailedFragment())
            //?.disallowAddToBackStack()
            //transaction2?.commit()
        }




        return _view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LibraryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LibraryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}