package by.godevelopment.secondtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import by.godevelopment.secondtask.R
import by.godevelopment.secondtask.presentation.itemdetails.DetailsFragment
import by.godevelopment.secondtask.presentation.listItems.ListFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ListFragment>(R.id.fragment_container_view)
            }
        }
    }

    fun exitApp() {
        finish()
    }
}