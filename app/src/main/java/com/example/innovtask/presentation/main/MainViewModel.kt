package com.example.innovtask.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ResultOf
import com.example.innovtask.domain.repository.IRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(val repo: IRepository) : ViewModel() {

    private val _coachState = MutableStateFlow("")
    val coachState = _coachState as StateFlow<String>
    fun getCoachName() {
        val result = viewModelScope.async {
            repo.getCoach()
        }
        viewModelScope.launch {
            when (val data = result.await()) {
                is ResultOf.Error -> {}
                is ResultOf.Success -> {
                    _coachState.value = data.data.coach?.name ?: ""
                }
            }
        }
    }
}