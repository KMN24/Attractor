package kg.attractor.domain.use_cases

import kg.attractor.domain.entities.User
import kg.attractor.domain.repository.MainRepo
import kg.attractor.domain.utils.BaseUseCase
import kg.attractor.domain.utils.Either
import kg.attractor.domain.utils.Failure

class GetUserUC(private val repo: MainRepo): BaseUseCase<User, BaseUseCase.None>() {
    override suspend fun run(params: None): Either<Failure, User> {
        return repo.getUser()
    }
}