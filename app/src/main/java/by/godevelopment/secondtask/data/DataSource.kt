package by.godevelopment.secondtask.data

import android.util.Log
import by.godevelopment.secondtask.R
import by.godevelopment.secondtask.domain.model.ItemModel
import kotlin.random.Random

object DataSource {
    val items = (0..999).map {
        val randomOfThree = Random.nextInt(3)
        ItemModel(
            id = 0,
            title = "Tittle $it",
            description = "Description $it",
            drawableSrc = when (randomOfThree) {
                0 -> R.drawable.ic_baseline_person_24
                1 -> R.drawable.outline_pets_24
                2 -> R.drawable.ic_baseline_filter_vintage_24
                else -> R.drawable.ic_baseline_filter_vintage_24
            }
        )
    }

    init {
        val vintage = items.filter {
            it.drawableSrc == R.drawable.ic_baseline_filter_vintage_24
        }.count()
        Log.i("secondtask#", "vintage: $vintage")
        val person = items.filter {
            it.drawableSrc == R.drawable.ic_baseline_person_24
        }.count()
        Log.i("secondtask#", "person: $person")
        val pets = items.count {
            it.drawableSrc == R.drawable.outline_pets_24
        }
        Log.i("secondtask#", "pets: $pets")
    }
}