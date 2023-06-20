package com.blkxltng.to_docompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.blkxltng.to_docompose.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase:RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}