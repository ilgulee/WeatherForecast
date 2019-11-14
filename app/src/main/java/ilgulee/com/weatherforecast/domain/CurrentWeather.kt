package ilgulee.com.weatherforecast.domain

data class CurrentWeather(
    val language: String,
    val unit: String,
    val location: String,
    val latitude: String,
    val longitude: String,
    val temperature: Int,
    val uvIndex: Int,
    val visibility: Int,
    val precipitation: Double,
    val feelsLike: Int,
    val windDirection: String,
    val windSpeed: Int,
    val weatherDescription: String,
    val weatherIconUrl: String
)