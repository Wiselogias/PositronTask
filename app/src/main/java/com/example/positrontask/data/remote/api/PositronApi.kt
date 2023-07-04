package com.example.positrontask.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PositronApi {
    @GET("products")
    suspend fun getItemsRemote(
        @Query("cat_id") cat_id: Int,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("base_id") base_id: Int,
        @Query("sort_type") sort_type: Int,
    ): Response<List<ItemApiEntity>>
}
