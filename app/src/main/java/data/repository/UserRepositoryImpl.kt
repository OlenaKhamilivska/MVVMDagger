package data.repository

import data.storage.UserStorage
import data.storage.models.User
import domain.models.SaveUserNameParam
import domain.models.UserName
import domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared preference name"
private const val FIRST_NAME = "first name"
private const val LAST_NAME = "last name"
private const val DEFAULT_NAME = "default name"

class UserRepositoryImpl (private val userStorage: UserStorage): UserRepository {
    override fun saveData(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()

        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}

