package com.ewide.test.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameResponseItem(

    @field:SerializedName("gameID")
    val gameID: String? = null,

    @field:SerializedName("metacriticScore")
    val metacriticScore: String? = null,

    @field:SerializedName("salePrice")
    val salePrice: String? = null,

    @field:SerializedName("releaseDate")
    val releaseDate: Int? = null,

    @field:SerializedName("thumb")
    val thumb: String? = null,

    @field:SerializedName("dealID")
    val dealID: String? = null,

    @field:SerializedName("steamRatingCount")
    val steamRatingCount: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("storeID")
    val storeID: String? = null,

    @field:SerializedName("internalName")
    val internalName: String? = null,

    @field:SerializedName("steamRatingPercent")
    val steamRatingPercent: String? = null,

    @field:SerializedName("dealRating")
    val dealRating: String? = null,

    @field:SerializedName("normalPrice")
    val normalPrice: String? = null,

    @field:SerializedName("lastChange")
    val lastChange: Int? = null,

    @field:SerializedName("savings")
    val savings: String? = null,

    @field:SerializedName("isOnSale")
    val isOnSale: String? = null,
) : Parcelable
