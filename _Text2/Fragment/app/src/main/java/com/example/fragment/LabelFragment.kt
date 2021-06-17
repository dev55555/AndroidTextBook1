package com.example.fragment

//import android.app.Fragment
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LabelFragment : Fragment() {

    private var counter = 0
    private lateinit var counterLabel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counter = savedInstanceState?.getInt("counter")
            ?: arguments?.getInt("counter")
                    ?: 0
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("counter", counter)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.label_fragment, container, false)
        counterLabel = view.findViewById(R.id.textView)
        counterLabel.text = counter.toString()
        return view
    }

    fun update() {
        counter++
        counterLabel.text = counter.toString()
    }

}
fun newLabelFragment(value : Int) : LabelFragment {
    val fragment = LabelFragment()

    val args = Bundle()
    args.putInt("counter", value)

    fragment.arguments = args
    return fragment
}
