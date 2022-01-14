package com.example.amphibians.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amphibians.network.Amphibian

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    // Create properties to represent MutableLiveData and LiveData for the API status
    private val _status = MutableLiveData<AmphibianApiStatus>()
    val status: LiveData<AmphibianApiStatus> = _status

    // Create properties to represent MutableLiveData and LiveData for a list of amphibian objects
    private val _amphibianList = MutableLiveData<Amphibian>()
    val amphibianList: LiveData<Amphibian> = _amphibianList

    // TODO: Create properties to represent MutableLiveData and LiveData for a single amphibian object.
    //  This will be used to display the details of an amphibian when a list item is clicked

    // TODO: Create a function that gets a list of amphibians from the api service and sets the
    //  status via a Coroutine

    fun onAmphibianClicked(amphibian: Amphibian) {
        // TODO: Set the amphibian object
    }
}
