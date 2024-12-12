package ru.mrapple100.fragments1212

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mrapple100.fragments1212.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class RVFragment : Fragment() {

    private var content = ""
    private var contentArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            content = it.getString(ARG_CONTENT) ?: ""
            contentArray = content.split(",") as MutableList<String>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_r_v_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)

                adapter = MyItemRecyclerViewAdapter(contentArray)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_CONTENT = "content"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(content: String) =
            RVFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CONTENT, content)
                }
            }
    }
}