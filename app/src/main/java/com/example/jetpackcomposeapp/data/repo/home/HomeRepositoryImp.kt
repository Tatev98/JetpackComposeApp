package com.example.jetpackcomposeapp.data.repo.home


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.jetpackcomposeapp.data.util.PreferenceKeys.CAR_DOORS_LOCKED
import com.example.jetpackcomposeapp.data.util.PreferenceKeys.CAR_MILES
import com.example.jetpackcomposeapp.data.util.PreferenceKeys.CAR_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject


//for getting or setting data from local datastore
class HomeRepositoryImp @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : HomeRepository {

    //get car name from local datastore if catch problem gives new empty preferences instance
    override fun carName(): Flow<String> {
        return dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map { preference ->
                preference[CAR_NAME] ?: ""
            }
    }

    //get car miles from local datastore if catch problem gives new empty preferences instance
    override fun carMiles(): Flow<Int> {
        return dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map { preference ->
                preference[CAR_MILES] ?: 120
            }
    }

    //get car doors state from local datastore if catch problem gives new empty preferences instance
    override fun carDoorsState(): Flow<Boolean> {
        return dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map { preference ->
                preference[CAR_DOORS_LOCKED] ?: true
            }
    }


    //set car name to local datastore
    override suspend fun setCarName(name: String) {
        dataStore.edit { preference ->
            preference[CAR_NAME] = name
        }
    }

    //set car miles to local datastore
    override suspend fun setCarMiles(miles: Int) {
        dataStore.edit { preference ->
            preference[CAR_MILES] = miles
        }
    }

    //set car doors' state to local datastore
    override suspend fun setCarDoorsState(locked: Boolean) {
        dataStore.edit { preference ->
            preference[CAR_DOORS_LOCKED] = locked
        }
    }
}

