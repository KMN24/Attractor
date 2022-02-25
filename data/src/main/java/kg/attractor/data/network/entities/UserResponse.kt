package kg.attractor.data.network.entities


import com.google.gson.annotations.SerializedName
import kg.attractor.domain.entities.Company
import kg.attractor.domain.entities.EducationType
import kg.attractor.domain.entities.User
import kg.attractor.domain.entities.UserData

data class UserResponse(
    @SerializedName("user")
    val user: UserDataResponse
){
    internal fun toUser() = User(user = user.toUserData())
}

data class UserDataResponse(
    @SerializedName("company")
    val company: List<CompanyResponse>,
    @SerializedName("education")
    val education: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("second_name")
    val secondName: String
){
    internal fun toUserData() = UserData(
        company = company.map { it.toCompany() },
        education = toEducationType(education),
        firstName = firstName,
        photo = photo,
        secondName = secondName
    )

    private fun toEducationType(education: Int) =
        when(education){
            1 -> EducationType.HIGH_SCHOOL
            2 -> EducationType.BACHELOR
            3 -> EducationType.MASTER
            4 -> EducationType.DOCTORAL
            else -> { EducationType.UNDEFINED }
        }
}

data class CompanyResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
){
    internal fun toCompany() = Company(
        name = name, position = position
    )
}

