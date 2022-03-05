package by.godevelopment.secondtask.domain.model

import androidx.annotation.DrawableRes

data class ItemModel(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes
    val drawableSrc: Int
)
