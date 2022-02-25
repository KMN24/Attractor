package kg.attractor.data.network.service

import kg.attractor.data.network.entities.UserResponse
import retrofit2.Response
import retrofit2.http.GET


interface MainService {
    @GET("user/")
    suspend fun getUser(): Response<UserResponse>
}