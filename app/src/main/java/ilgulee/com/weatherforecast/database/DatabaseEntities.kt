package ilgulee.com.weatherforecast.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import ilgulee.com.weatherforecast.domain.CurrentWeather

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather_table")
data class DatabaseCurrentWeather constructor(
    val language: String,
    val unit: String,
    val location: String,
    val lat: String,
    val lon: String,
    val temperature: Int,
    val uvIndex: Int,
    val visibility: Int,
    val precip: Double,
    val feelslike: Int,
    val windDir: String,
    val windSpeed: Int,
    val weatherDescription: String,
    val weatherIcon: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}

fun DatabaseCurrentWeather.asCurrentWeatherDomainModel(): CurrentWeather {
    return CurrentWeather(
        language = this.language,
        unit = this.unit,
        location = this.location,
        latitude = this.lat,
        longitude = this.location,
        temperature = this.temperature,
        uvIndex = this.uvIndex,
        visibility = this.visibility,
        precipitation = this.precip,
        feelsLike = this.feelslike,
        windDirection = this.windDir,
        windSpeed = this.windSpeed,
        weatherDescription = this.weatherDescription,
        weatherIconUrl = this.weatherIcon
    )
}