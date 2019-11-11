package ilgulee.com.weatherforecast.data

import ilgulee.com.weatherforecast.provider.UnitSystem

interface UnitDataSource {
    fun getUnitSystemFromPreference(): UnitSystem
}