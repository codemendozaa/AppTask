package com.codemen.games.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 ** create by ErixJavier on  2/05/20.
 */
@Entity(tableName = "daily _task_registre_table")
data class TaskRegister (
    @PrimaryKey(autoGenerate = true)
    var taskId:Long = 0L,

    @ColumnInfo(name = "start_time_milli")
    val startTimeMilli : Long = System.currentTimeMillis(),

    @ColumnInfo(name = "end_time_milli")
    var endTimeMilli: Long = startTimeMilli,

    @ColumnInfo(name = "quality_rating")
    var sleepQuality: Int = -1
)