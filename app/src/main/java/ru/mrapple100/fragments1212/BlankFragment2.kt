package ru.mrapple100.fragments1212

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import ru.mrapple100.fragments1212.databinding.FragmentBlank2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var subject: String? = null
    private var mark: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            subject = it.getString("Subject")
            mark = it.getInt("Mark")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : FragmentBlank2Binding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_blank2,container,false)

        binding.Switch.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            if(b){
                binding.Switch.text = subject ?: "Sasha"
            }else{
                binding.Switch.text = mark?.toString() ?: "22"

            }

        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString("Subject", param1)
                    putInt("Mark", param2)
                }
            }
    }
}