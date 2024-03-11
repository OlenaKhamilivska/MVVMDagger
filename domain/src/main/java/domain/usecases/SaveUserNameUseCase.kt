package domain.usecases

import domain.models.SaveUserNameParam
import domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldName = userRepository.getName()
        if (oldName.firstName == param.name)
            return true

       val result: Boolean = userRepository.saveData(saveParam = param)
        return result
    }
}
