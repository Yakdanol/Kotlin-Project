package org.yakdanol

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id: Long,
    val title: String,
    val place: String?,
    val description: String?,
    val siteUrl: String,
    val favoritesCount: Int,
    val commentsCount: Int
) {
    val rating: Double by lazy {
        calculateRating(favoritesCount, commentsCount)
    }

    private fun calculateRating(favoritesCount: Int, commentsCount: Int): Double {
        return 1.0 / (1 + kotlin.math.exp(-(favoritesCount.toDouble() / (commentsCount + 1))))
    }
}