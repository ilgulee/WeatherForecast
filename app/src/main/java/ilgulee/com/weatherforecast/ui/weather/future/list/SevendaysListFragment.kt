package ilgulee.com.weatherforecast.ui.weather.future.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ilgulee.com.weatherforecast.R

class SevendaysListFragment : Fragment() {

    private lateinit var sevendaysListViewModel: SevendaysListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sevendaysListViewModel =
            ViewModelProviders.of(this).get(SevendaysListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sevendays, container, false)
        val textView: TextView = root.findViewById(R.id.text_7days)
        sevendaysListViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}