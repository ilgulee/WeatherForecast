package ilgulee.com.weatherforecast.app

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ilgulee.com.weatherforecast.BuildConfig
import ilgulee.com.weatherforecast.data.RemoteDataSource
import ilgulee.com.weatherforecast.network.NetworkRemoteDataSource
import ilgulee.com.weatherforecast.network.WeatherServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Injection {

    fun provideNetworkRemoteDataSource(): RemoteDataSource = NetworkRemoteDataSource

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
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