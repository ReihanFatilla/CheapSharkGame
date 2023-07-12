package com.ewide.test.core.data.local.room.entity

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
    @ColumnInfo(name = "sale_price")
    val salePrice: String,
    @ColumnInfo(name = "normal_price")
    val normalPrice: String,
    @ColumnInfo(name = "rating_percent")
    val ratingPercent: String,
    @ColumnInfo(name = "thumb_url")
    val thumbUrl: String
): Parcelable
