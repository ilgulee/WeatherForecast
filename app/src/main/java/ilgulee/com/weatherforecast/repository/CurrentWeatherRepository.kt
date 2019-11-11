package ilgulee.com.weatherforecast.repository

import androidx.lifecycle.Transformations
import ilgulee.com.weatherforecast.app.Injection
import ilgulee.com.weatherforecast.database.asCurrentWeatherDomainModel
import ilgulee.com.weatherforecast.network.model.asDatabaseCurrentWeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentWeatherRepository {
    private val remoteDataSource = Injection.provideNetworkRemoteDataSource()
    private val localDataSource = Injection.provideRoomLocalDataSource()
    val currentWeather = Transformations.map(localDataSource.getCurrentWeatherFromDatabase()) {
        it?.asCurrentWeatherDomainModel()
    }

    suspend fun refreshCurrentWeather(location: String) {
        withContext(Dispatchers.IO) {
            val currentWeatherProperty = remoteDataSource.getCurrentWeather(location)
            localDataSource.saveCurrentWeatherFromNetwork(currentWeatherProperty.asDatabaseCurrentWeatherModel())
        }
    }
}