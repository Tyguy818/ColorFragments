package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {

    private var myIndex: Int = 0

    companion object {
        var fragmentCount: Int = 0

        fun newInstance(choice: Int) = ColorFragment().apply {
            arguments = Bundle().apply {
                putInt("COLOR CHOICE", choice)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            myIndex = ++fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0
        val chosenColorTV = view.findViewById<TextView>(R.id.mycolor)

        if (choiceId == 1) { // BLUE
            chosenColorTV.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
            chosenColorTV.setBackgroundColor(Color.rgb(150, 150, 255))
        } else if (choiceId == 2) { // RED
            chosenColorTV.text = "GENERIC RED FRAGMENT - UID $myIndex"
            chosenColorTV.setBackgroundColor(Color.rgb(255, 150, 150))
        }
    }
}
