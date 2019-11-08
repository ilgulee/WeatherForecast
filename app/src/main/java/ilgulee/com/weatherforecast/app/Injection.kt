package ilgulee.com.weatherforecast.app

import ilgulee.com.weatherforecast.BuildConfig
import ilgulee.com.weatherforecast.data.RemoteDataSource
import ilgulee.com.weatherforecast.network.NetworkRemoteDataSource
import ilgulee.com.weatherforecast.network.WeatherServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object Injection {

    fun provideNetworkRemoteDataSource(): RemoteDataSource = NetworkRemoteDataSource

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(provideLoggingInterceptor())
        return httpClient.build()
    }

    fun provideWeatherServiceApi(): WeatherServiceApi {
        return provideRetrofit().create(WeatherServiceApi::class.java)
    }
}