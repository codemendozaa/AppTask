package com.codemen.games.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 ** create by ErixJavier on  2/05/20.
 */
@Dao
interface TaskDatabaseDao {
    @Insert
    fun insert(task: TaskRegister)

    @Update
    fun update(task: TaskRegister)

    @Query("SELECT * from `daily _task_registre_table` WHERE taskId = :key")
    fun get(key:Long):TaskRegister?

    @Query("DELETE FROM `daily _task_registre_table`")
    fun clear()

    @Query("SELECT * FROM `daily _task_registre_table` ORDER BY taskId DESC LIMIT 1")
    fun getTotask(): TaskRegister?

    @Query("SELECT * FROM `daily _task_registre_table` ORDER BY taskId DESC")
    fun getAllTasks(): LiveData<List<TaskRegister>>
}