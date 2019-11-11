package ilgulee.com.weatherforecast.data

import androidx.lifecycle.LiveData
import ilgulee.com.weatherforecast.database.DatabaseCurrentWeather

interface LocalDataSource {
    fun getCurrentWeatherFromDatabase(): LiveData<DatabaseCurrentWeather>
    suspend fun saveCurrentWeatherFromNetwork(currentWeather: DatabaseCurrentWeather)
}