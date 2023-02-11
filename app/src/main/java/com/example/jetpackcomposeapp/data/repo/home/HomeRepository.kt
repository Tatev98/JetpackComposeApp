package com.example.jetpackcomposeapp.data.repo.home


import kotlinx.coroutines.flow.Flow

//for getting or setting data from local datastore
interface HomeRepository {
    fun carName(): Flow<String> //to get car name
    fun carMiles(): Flow<Int> //to get car miles
    fun carDoorsState(): Flow<Boolean> //to get car doors' state
    suspend fun setCarName(name: String) //to set car name
    suspend fun setCarMiles(miles: Int) //to set car miles
    suspend fun setCarDoorsState(locked: Boolean) //to change doors state
}
