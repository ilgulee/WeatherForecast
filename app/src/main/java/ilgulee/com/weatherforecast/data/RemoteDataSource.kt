package ilgulee.com.weatherforecast.data

import androidx.lifecycle.LiveData

interface RemoteDataSource {
    fun getCurrentWeather(location: String): LiveData<String>
}