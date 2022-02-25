package kg.attractor.data.repoImpl

import kg.attractor.data.network.entities.CompanyResponse
import kg.attractor.data.network.entities.UserDataResponse
import kg.attractor.data.network.entities.UserResponse
import kg.attractor.data.network.service.MainService
import kg.attractor.data.utils.service
import kg.attractor.domain.entities.User
import kg.attractor.domain.entities.UserData
import kg.attractor.domain.repository.MainRepo
import kg.attractor.domain.utils.Either
import kg.attractor.domain.utils.Failure
import kg.attractor.domain.utils.map

class MainRepoImpl(
    private val service: MainService
) : MainRepo {
//    override suspend fun getUser() =
//        service {
//            service.getUser()
//        }.map { it.toUser() }

    override suspend fun getUser(): Either<Failure, User> {
        val userResponse = UserResponse(
            UserDataResponse(
                firstName = "Mederbek",
                secondName = "Kanatbekov",
                education = 2,
                photo = null,
                company = listOf(
                    CompanyResponse(
                        name = "Sunrise IT company",
                        position = "Junior Android Dev"
                    ),
                    CompanyResponse(
                        name = "Zeon IT Hub",
                        position = "Android Dev"
                    ),
                    CompanyResponse(
                        name = "Tapp startup",
                        position = "Strong Junior Android Dev"
                    )
                )
            )
        )

        return Either.Right(userResponse.toUser())
    }

}