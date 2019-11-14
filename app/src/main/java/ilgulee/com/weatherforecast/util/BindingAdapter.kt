package ilgulee.com.weatherforecast.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import ilgulee.com.weatherforecast.domain.CurrentWeather

@BindingAdapter("isNetworkError", "current")
fun hideIfNetworkError(view: View, isNetWorkError: Boolean, currentWeather: Any?) {
    view.visibility = if (currentWeather != null) View.GONE else View.VISIBLE

    if (isNetWorkError) {
        view.visibility = View.GONE
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let { Glide.with(imageView.context).load(url).into(imageView) }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("isMetric", "temperature")
fun setTemperatureAccordingToUnits(textView: TextView, isMetric: Boolean, temperature: Int) {
    if (isMetric) {
        textView.text = "$temperature °C"
    } else {
        textView.text = "$temperature °F"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("isMetric", "feeksLike")
fun setFeelsLikeAccordingToUnits(textView: TextView, isMetric: Boolean, feelsLike: Int) {
    if (isMetric) {
        textView.text = "Feels like $feelsLike °C"
    } else {
        textView.text = "Feels like $feelsLike °F"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("isMetric", "wind")
fun setWindAccordingToUnits(
    textView: TextView,
    isMetric: Boolean,
    currentWeather: CurrentWeather?
) {
    currentWeather?.let {
        if (isMetric) {
            textView.text = "Wind: ${currentWeather.windDirection}, ${currentWeather.windSpeed} kph"
        } else {
            textView.text = "Wind: ${currentWeather.windDirection}, ${currentWeather.windSpeed} mph"
        }
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("isMetric", "precipitation")
fun setPrecipitationAccordingToUnits(
    textView: TextView,
    isMetric: Boolean,
    currentWeather: CurrentWeather?
) {
    currentWeather?.let {
        if (isMetric) {
            textView.text = "Precipitation: ${currentWeather.precipitation} mm"
        } else {
            textView.text = "Precipitation: ${currentWeather.precipitation} in"
        }
    }
}