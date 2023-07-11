package com.ewide.test.core.data.local.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class GameEntity (
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "salePrice")
    val salePrice: String,
    @ColumnInfo(name = "normalPrice")
    val normalPrice: String,
    @ColumnInfo(name = "thumbUrl")
    val thumbUrl: String
): Parcelable
