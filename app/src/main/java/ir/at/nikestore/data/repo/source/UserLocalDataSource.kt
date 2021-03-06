package ir.at.nikestore.data.repo.source

import android.content.SharedPreferences
import com.sevenlearn.nikestore.data.TokenContainer
import com.sevenlearn.nikestore.data.TokenResponse
import io.reactivex.Single
import ir.at.nikestore.data.MessageResponse

class UserLocalDataSource(val sharedPreferences: SharedPreferences) : UserDataSource {
    override fun login(username: String, password: String): Single<TokenResponse> {
        TODO("Not yet implemented")
    }

    override fun signUp(username: String, password: String): Single<MessageResponse> {
        TODO("Not yet implemented")
    }

    override fun loadToken() {
        TokenContainer.update(
            sharedPreferences.getString("access_token" , null) ,
            sharedPreferences.getString("refresh_token" , null)
        )

    }

    override fun saveToken(token: String, refreshToken: String) {
        sharedPreferences.edit().apply {
            putString("access_token" , token)
            putString("refresh_token" , refreshToken)
        }.apply()
    }

    override fun saveUsername(username: String) {
        sharedPreferences.edit().apply{
            putString("username" , username)
        }.apply()
    }

    override fun getUsername(): String = sharedPreferences.getString("username" , "")?:""


    override fun signOut() = sharedPreferences.edit().apply {
        clear()
    }.apply()
}