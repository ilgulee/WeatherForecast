package ilgulee.com.weatherforecast.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isNetworkError", "current")
fun hideIfNetworkError(view: View, isNetWorkError: Boolean, currentWeather: Any?) {
    view.visibility = if (currentWeather != null) View.GONE else View.VISIBLE

    if (isNetWorkError) {
        view.visibility = View.GONE
    }
}