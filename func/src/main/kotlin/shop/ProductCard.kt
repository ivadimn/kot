package shop

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductCard(
    @SerialName("id") val id: Int,
    @SerialName("product_name") val name: String,
    @SerialName("product_category") val category: ProductCategory,
    @SerialName("product_price") val price: Double,
    @SerialName("product_description") val description: String,
    @SerialName("product_brand") val brand: String,
    @SerialName("product_rating") val rating: Float,
    @SerialName("product_availability") val availability : Boolean
)
