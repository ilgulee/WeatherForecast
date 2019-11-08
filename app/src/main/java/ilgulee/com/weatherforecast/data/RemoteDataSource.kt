package ilgulee.com.weatherforecast.data

import androidx.lifecycle.LiveData
import ilgulee.com.weatherforecast.network.model.CurrentWeatherProperty

interface RemoteDataSource {
    fun getCurrentWeather(location: String): LiveData<CurrentWeatherProperty>
}