package edu.msudenver.cs3013.colorfragments

import android.content.Context
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
 * Use the [ChoiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChoiceFragment : Fragment() {

    interface ChoiceListener {
        fun onSelected(choice: Int)
    }

    private var choiceListener: ChoiceListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        } else {
            throw RuntimeException("$context must implement ChoiceListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blueT = view.findViewById<TextView>(R.id.blueText)
        val redT = view.findViewById<TextView>(R.id.redText)

        blueT.setOnClickListener {
            choiceListener?.onSelected(1) // 1 for BLUE
        }

        redT.setOnClickListener {
            choiceListener?.onSelected(2) // 2 for RED
        }
    }

    override fun onDetach() {
        super.onDetach()
        choiceListener = null
    }
}

