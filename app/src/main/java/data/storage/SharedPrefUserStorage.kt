package data.storage

import android.content.Context
import androidx.core.content.contentValuesOf
import data.storage.models.User


private const val SHARED_PREFS_NAME = "shared preference name"
private const val FIRST_NAME = "first name"
private const val LAST_NAME = "last name"
private const val DEFAULT_FIRST_NAME = "default first name"
private const val DEFAULT_LAST_NAME = "default last name"

class SharedPrefUserStorage(context: Context): UserStorage {//this class so save data in Shared Preference

    private val sharedPref = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPref.edit().putString(FIRST_NAME, user.firstName).apply()
        sharedPref.edit().putString(LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPref.getString(FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPref.getString(LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}