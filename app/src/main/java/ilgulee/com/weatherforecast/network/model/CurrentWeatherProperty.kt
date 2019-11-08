package ilgulee.com.weatherforecast.network.model


import com.squareup.moshi.Json

data class CurrentWeatherProperty(
    @Json(name = "current")
    val current: Current,
    @Json(name = "location")
    val location: Location,
    @Json(name = "request")
    val request: Request
)