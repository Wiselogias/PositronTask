package com.example.positrontask.data.remote.api

import com.google.gson.annotations.SerializedName

data class ItemApiEntity(
    @SerializedName("gcode")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("img_preview")
    val imageRef: String
)