package com.ewide.test.core.domain.model.game

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: String,
    val title: String,
    val salePrice: String,
    val normalPrice: String,
    val ratingPercent: String,
    val thumbUrl: String
):Parcelable
