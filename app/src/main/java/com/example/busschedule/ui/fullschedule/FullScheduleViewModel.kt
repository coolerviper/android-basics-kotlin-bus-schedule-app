package com.example.busschedule.ui.fullschedule

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FullScheduleViewModel @Inject constructor(private val scheduleRepository: ScheduleRepository): ViewModel() {

    init {
        viewModelScope.launch {
            scheduleRepository.getFullSchedule().collect {
                schedule.value = it
            }

        }
    }

    val schedule = mutableStateOf(listOf<Schedule>())
}