package ilgulee.com.weatherforecast.data

import ilgulee.com.weatherforecast.network.model.CurrentWeatherProperty

interface RemoteDataSource {
    suspend fun getCurrentWeather(location: String): CurrentWeatherProperty
}