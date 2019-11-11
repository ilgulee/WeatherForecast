package ilgulee.com.weatherforecast.network.model


import com.squareup.moshi.Json
import ilgulee.com.weatherforecast.database.DatabaseCurrentWeather

data class CurrentWeatherProperty(
    @Json(name = "current")
    val current: Current,
    @Json(name = "location")
    val location: Location,
    @Json(name = "request")
    val request: Request
)

fun CurrentWeatherProperty.asDatabaseCurrentWeatherModel(): DatabaseCurrentWeather {
    return DatabaseCurrentWeather(
        language = this.request.language,
        unit = this.request.unit,
        location = this.location.name,
        lat = this.location.lat,
        lon = this.location.lon,
        temperature = this.current.temperature,
        uvIndex = this.current.uvIndex,
        visibility = this.current.visibility,
        precip = this.current.precip,
        feelslike = this.current.feelslike,
        windDir = this.current.windDir,
        windSpeed = this.current.windSpeed,
        weatherDescription = this.current.weatherDescriptions[0],
        weatherIcon = this.current.weatherIcons[0]
    )
}