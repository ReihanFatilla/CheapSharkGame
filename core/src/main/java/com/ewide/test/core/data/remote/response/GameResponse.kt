package com.ewide.test.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameResponse(
	@field:SerializedName("GameResponse")
	val gameResponse: List<GameResponseItem?>? = null
) : Parcelable
