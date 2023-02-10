package com.example.jetpackcomposeapp.data.util

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.jetpackcomposeapp.data.util.Constants.KEY_CAR_DOORS_STATE
import com.example.jetpackcomposeapp.data.util.Constants.KEY_CAR_MILES
import com.example.jetpackcomposeapp.data.util.Constants.KEY_CAR_NAME


//create preferences keys for local datastore
object PreferenceKeys {
    val CAR_NAME = stringPreferencesKey(KEY_CAR_NAME)
    val CAR_MILES = intPreferencesKey(KEY_CAR_MILES)
    val CAR_DOORS_LOCKED = booleanPreferencesKey(KEY_CAR_DOORS_STATE)
}
