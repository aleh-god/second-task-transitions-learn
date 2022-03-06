package by.godevelopment.secondtask.data

import android.util.Log
import by.godevelopment.secondtask.R
import by.godevelopment.secondtask.domain.model.ItemModel
import by.godevelopment.secondtask.presentation.TAG
import kotlin.random.Random

object DataSource {
    val items = (0..999).map {
        val randomOfThree = Random.nextInt(3)
        ItemModel(
            id = it,
            title = "Tittle $it",
            description = "Description $it",
            drawableSrc = when (randomOfThree) {
                0 -> R.drawable.circular_vintage
                1 -> R.drawable.circular_image_person
                2 -> R.drawable.circular_image_pet
                else -> R.drawable.ic_launcher_background
            }
        )
    }

    init {
        val vintage = items.filter {
            it.drawableSrc == R.drawable.circular_vintage
        }.count()
        Log.i(TAG, "vintage: $vintage")
        val person = items.filter {
            it.drawableSrc == R.drawable.circular_image_person
        }.count()
        Log.i(TAG, "person: $person")
        val pets = items.count {
            it.drawableSrc == R.drawable.circular_image_pet
        }
        Log.i(TAG, "pets: $pets")
    }
}