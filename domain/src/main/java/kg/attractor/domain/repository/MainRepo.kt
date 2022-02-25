package kg.attractor.domain.repository

import kg.attractor.domain.entities.User
import kg.attractor.domain.utils.Either
import kg.attractor.domain.utils.Failure

interface MainRepo {
    suspend fun getUser(): Either<Failure, User>
}