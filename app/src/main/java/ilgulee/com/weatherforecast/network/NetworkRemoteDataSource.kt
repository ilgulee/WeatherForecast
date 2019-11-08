package ilgulee.com.weatherforecast.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ilgulee.com.weatherforecast.app.Injection
import ilgulee.com.weatherforecast.data.RemoteDataSource
import ilgulee.com.weatherforecast.network.model.CurrentWeatherProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NetworkRemoteDataSource : RemoteDataSource {
    private const val KEY = "0d165139f14c8c8e5502ec3e1f38f4b9"
    private val api = Injection.provideWeatherServiceApi()

    override fun getCurrentWeather(location: String): LiveData<CurrentWeatherProperty> {
        val liveData = MutableLiveData<CurrentWeatherProperty>()
        api.getCurrentWeather(KEY, location).enqueue(object : Callback<CurrentWeatherProperty> {
            override fun onResponse(
                call: Call<CurrentWeatherProperty>,
                response: Response<CurrentWeatherProperty>
            ) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<CurrentWeatherProperty>, t: Throwable) {

            }
        })
        return liveData
    }
}