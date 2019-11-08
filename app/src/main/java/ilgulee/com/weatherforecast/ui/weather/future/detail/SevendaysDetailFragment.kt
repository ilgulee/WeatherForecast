package ilgulee.com.weatherforecast.ui.weather.future.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ilgulee.com.weatherforecast.R

class SevendaysDetailFragment : Fragment() {

    companion object {
        fun newInstance() = SevendaysDetailFragment()
    }

    private lateinit var viewModel: SevendaysDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sevendays_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SevendaysDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
