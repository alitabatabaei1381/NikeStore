package ir.at.nikestore.data.repo.source

import com.google.gson.JsonObject
import com.sevenlearn.nikestore.data.TokenResponse
import io.reactivex.Single
import ir.at.nikestore.data.MessageResponse
import ir.at.nikestore.sevices.http.ApiService

const val CLIENT_ID = 2
const val CLIENT_SECRET = "kyj1c9sVcksqGU4scMX7nLDalkjp2WoqQEf8PKAC"

class UserRemoteDataSource(val apiService: ApiService) : UserDataSource {
    override fun login(username: String, password: String): Single<TokenResponse> {
        return apiService.login(JsonObject().apply {
            addProperty("username" , username)
            addProperty("password" , password)
            addProperty("grant_type" , "password")
            addProperty("client_id" , CLIENT_ID)
            addProperty("client_secret" , CLIENT_SECRET)
        })
    }

    override fun signUp(username: String, password: String): Single<MessageResponse> {
        return apiService.signUp(JsonObject().apply {
            addProperty("email" , username)
            addProperty("password" , password)
        })
    }

    override fun loadToken() {
        TODO("Not yet implemented")
    }

    override fun saveToken(token: String, refreshToken: String) {
        TODO("Not yet implemented")
    }
}