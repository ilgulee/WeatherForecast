package ilgulee.com.weatherforecast.network

import ilgulee.com.weatherforecast.network.model.CurrentWeatherProperty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServiceApi {
    @GET("current")
    fun getCurrentWeather(
        @Query("access_key") key: String,
        @Query("query") location: String
    ): Call<CurrentWeatherProperty>
}