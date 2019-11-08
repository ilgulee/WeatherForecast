package ilgulee.com.weatherforecast.ui.weather.today

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ilgulee.com.weatherforecast.app.Injection

class TodayViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Injection.provideNetworkRemoteDataSource()
    val currentWeather = repository.getCurrentWeather("New York")

}