package ilgulee.com.weatherforecast.database

import androidx.lifecycle.LiveData
import ilgulee.com.weatherforecast.app.Injection
import ilgulee.com.weatherforecast.data.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RoomLocalDataSource : LocalDataSource {
    private val database = Injection.provideDatabase()

    override fun getCurrentWeatherFromDatabase(): LiveData<DatabaseCurrentWeather> {
        return database.weatherDao.getCurrentWeather()
    }

    override suspend fun saveCurrentWeatherFromNetwork(currentWeather: DatabaseCurrentWeather) {
        withContext(Dispatchers.IO) {
            database.weatherDao.insertCurrentWeather(currentWeather)
        }
    }
}