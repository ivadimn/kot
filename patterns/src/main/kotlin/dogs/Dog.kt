package dogs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("id") val id: Int,
    @SerialName("dogName") val dogName: String,
    @SerialName("breedName") val breedName: String,
    @SerialName("weight") val weight: Int
)