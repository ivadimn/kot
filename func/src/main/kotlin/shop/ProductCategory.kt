package shop

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProductCategory {
    @SerialName("Electronics")
    ELECTRONICS,
    @SerialName("Home Goods")
    HOME_GOODS,
    @SerialName("Sports")
    SPORTS,
    @SerialName("Beauty")
    BEAUTY,
    @SerialName("Clothing")
    CLOTHING
}