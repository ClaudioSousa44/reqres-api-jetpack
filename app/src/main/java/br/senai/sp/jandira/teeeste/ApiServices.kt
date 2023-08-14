package br.senai.sp.jandira.teeeste

import br.senai.sp.jandira.teeeste.model.BaseResponse
import br.senai.sp.jandira.teeeste.service.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("api/users/{id}")
    suspend fun getUserByID(@Path("id") id: String): Response<BaseResponse<UserResponse>>
}
