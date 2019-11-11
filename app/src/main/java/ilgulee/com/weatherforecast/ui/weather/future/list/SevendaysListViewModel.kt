package ilgulee.com.weatherforecast.ui.weather.future.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SevendaysListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Sorry. 7 days forecast is the payment service."
    }
    val text: LiveData<String> = _text
}