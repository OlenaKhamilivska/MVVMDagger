package domain.repository

import domain.models.SaveUserNameParam
import domain.models.UserName

interface UserRepository {

    fun saveData (saveParam: SaveUserNameParam): Boolean

    fun getName (): UserName
}