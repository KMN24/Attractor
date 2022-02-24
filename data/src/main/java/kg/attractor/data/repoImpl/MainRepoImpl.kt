package kg.attractor.data.repoImpl

import kg.attractor.data.network.service.MainService
import kg.attractor.domain.repository.MainRepo

class MainRepoImpl(
    private val service: MainService
): MainRepo {

}