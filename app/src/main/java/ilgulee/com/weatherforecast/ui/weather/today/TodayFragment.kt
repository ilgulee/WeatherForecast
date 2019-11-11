package ilgulee.com.weatherforecast.ui.weather.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ilgulee.com.weatherforecast.R
import ilgulee.com.weatherforecast.databinding.FragmentTodayBinding

class TodayFragment : Fragment() {
    private lateinit var todayViewModel: TodayViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTodayBinding>(
            inflater,
            R.layout.fragment_today,
            container,
            false
        )
        todayViewModel = ViewModelProviders.of(this).get(TodayViewModel::class.java)
        binding.viewModel = todayViewModel
        binding.lifecycleOwner = this

        todayViewModel.eventNetworkError.observe(this, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })

        return binding.root
    }

    private fun onNetworkError() {
        if (!todayViewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            todayViewModel.onNetworkErrorShown()
        }
    }
}