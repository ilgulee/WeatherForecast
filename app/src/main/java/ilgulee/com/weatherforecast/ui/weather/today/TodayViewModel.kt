package ilgulee.com.weatherforecast.ui.weather.today

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import ilgulee.com.weatherforecast.provider.UnitSystem
import ilgulee.com.weatherforecast.repository.CurrentWeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TodayViewModel(application: Application) : AndroidViewModel(application) {
    private val currentWeatherRepository = CurrentWeatherRepository()
    val currentWeather = currentWeatherRepository.currentWeather

    private val _unitSystem = MutableLiveData(currentWeatherRepository.unitSystem)
    val isMetric = Transformations.map(_unitSystem) {
        it.unit == UnitSystem.METRIC.unit
    }
    private val location = "London"

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        refreshCurrentWeatherProperty(location, _unitSystem.value!!.unit)
    }

    private fun refreshCurrentWeatherProperty(location: String, unit: String) {
        coroutineScope.launch {
            try {
                currentWeatherRepository.refreshCurrentWeather(location, unit)
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            } catch (e: Exception) {
                if (currentWeather.value == null) {
                    _eventNetworkError.value = true
                }
            }
        }
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}