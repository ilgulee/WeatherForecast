package ilgulee.com.weatherforecast.network

import ilgulee.com.weatherforecast.network.model.CurrentWeatherProperty
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServiceApi {
    @GET("current")
    fun getCurrentWeatherAsync(
        @Query("access_key") key: String,
        @Query("query") location: String,
        @Query("units") unit: String = "m"
    ): Deferred<CurrentWeatherProperty>
}