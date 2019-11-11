package ilgulee.com.weatherforecast.provider

import ilgulee.com.weatherforecast.app.Injection
import ilgulee.com.weatherforecast.data.UnitDataSource

object PreferenceUnitDataSource : UnitDataSource {

    private val preference = Injection.provideSharedPreference()

    override fun getUnitSystemFromPreference(): UnitSystem {
        val selectedName = preference.getString("UNIT_SYSTEM", UnitSystem.METRIC.name)
        return UnitSystem.valueOf(selectedName!!)
    }


}