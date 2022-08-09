package com.example.busschedule.database.schedule

import javax.inject.Inject

class ScheduleRepository @Inject constructor(private val scheduleDao: ScheduleDao) {

    fun getFullSchedule() = scheduleDao.getAll()

    fun getStopByName(name: String) = scheduleDao.getByStopName(name)

}