package com.kaza.batterymonitoring

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.FirebaseDatabase

class BatteryViewModel(application: Application) : AndroidViewModel(application) {
    private val _batteryLevel = MutableLiveData<Int>()
    val batteryLevel: LiveData<Int> = _batteryLevel

    // Function to update the battery level
    fun updateBatteryLevel(level: Int) {
        // Get the battery percentage and store it in a INT variable
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("batLevel")
        val batteryLevelString = "$level %"
        reference.setValue(batteryLevelString)

        _batteryLevel.value = level
    }
}
