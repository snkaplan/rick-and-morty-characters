package com.sk.rickandmortyapi.ui.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sk.rickandmortyapi.data.repository.Repository
import com.sk.rickandmortyapi.ui.ScreenState
import com.sk.rickandmortyapi.network.ApiServiceImpl
import com.sk.rickandmortyapi.data.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: Repository
                    = Repository(ApiServiceImpl.apiService)
): ViewModel() {
    private var _charactersLiveData = MutableLiveData<ScreenState<List<Character>>>()
    val characterLiveData: LiveData<ScreenState<List<Character>>>
        get() = _charactersLiveData

    init {
        fetchCharacter()
    }

    private fun fetchCharacter(){
        _charactersLiveData.postValue(ScreenState.Loading(null))
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val client = repository.getCharacters("1")
                _charactersLiveData.postValue(ScreenState.Success(client.result))
            } catch (e: Exception){
                _charactersLiveData.postValue(
                    ScreenState.Error(
                        e.message ?: "Error occured while fetching characters", null
                    )
                )
            }
        }
    }
}