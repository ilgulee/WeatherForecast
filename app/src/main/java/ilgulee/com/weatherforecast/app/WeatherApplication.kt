package ilgulee.com.weatherforecast.app

import android.app.Application
import android.content.Context

class WeatherApplication : Application() {
    companion object {
        private lateinit var instance: WeatherApplication

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}