package com.mesutemre.androidjetpackroom.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1TO2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE UserEntity ADD COLUMN isActive INTEGER NOT NULL DEFAULT 1")
    }
}