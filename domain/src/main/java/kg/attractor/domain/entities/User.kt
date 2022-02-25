package kg.attractor.domain.entities

data class User(
    val user: UserData
)

data class UserData(
    val company: List<Company>,
    val education: EducationType,
    val firstName: String,
    val photo: String?,
    val secondName: String
)

data class Company(
    val name: String,
    val position: String
)
