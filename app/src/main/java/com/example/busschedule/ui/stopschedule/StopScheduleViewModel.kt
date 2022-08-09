package com.example.busschedule.ui.stopschedule

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StopScheduleViewModel
@Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    savedStateHandle: SavedStateHandle
    ): ViewModel() {

    init {
        val stopName = savedStateHandle.get<String>("stop_name")?: ""
        viewModelScope.launch {
            scheduleRepository.getStopByName(stopName).collect {
                schedule.value = it
            }

        }
    }

    val schedule = mutableStateOf(listOf<Schedule>())
}