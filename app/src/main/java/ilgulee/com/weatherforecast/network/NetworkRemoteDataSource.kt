package ilgulee.com.weatherforecast.network

import ilgulee.com.weatherforecast.app.Injection
import ilgulee.com.weatherforecast.data.RemoteDataSource
import ilgulee.com.weatherforecast.network.model.CurrentWeatherProperty

object NetworkRemoteDataSource : RemoteDataSource {
    private const val KEY = "0d165139f14c8c8e5502ec3e1f38f4b9"
    private val api = Injection.provideWeatherServiceApi()

    override suspend fun getCurrentWeather(location: String, unit: String): CurrentWeatherProperty {
        return api.getCurrentWeatherAsync(KEY, location, unit).await()
    }
}