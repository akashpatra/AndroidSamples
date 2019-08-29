package `in`.co.trapps.droid_dive.components.activities

import `in`.co.trapps.droid_dive.R
import `in`.co.trapps.droid_dive.views.recyclerview.multipletype.MultipleTypeAdapter
import `in`.co.trapps.droid_dive.views.recyclerview.multipletype.model.BaseModel
import `in`.co.trapps.droid_dive.views.recyclerview.multipletype.model.Movie
import `in`.co.trapps.droid_dive.views.recyclerview.multipletype.model.Music
import `in`.co.trapps.droid_dive.views.recyclerview.multipletype.model.PodCast
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_rv_multi_type.*

class RVMultiTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_multi_type)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val adapter = MultipleTypeAdapter(getStubData(), applicationContext)
        rvMultiType.adapter = adapter
        rvMultiType.layoutManager = LinearLayoutManager(
            applicationContext, RecyclerView.VERTICAL, false
        )
    }

    private fun getStubData(): List<BaseModel> {
        return mutableListOf<BaseModel>().apply {
            add(Movie("Robert Downey Jr.", "Avengers: End Game"))
            add(Music("AR Rehman", "Dil Se"))
            add(PodCast("Jake Wharton", "ButterKnife"))

            add(Music("Cold Play", "Paradise"))
            add(PodCast("Chet Hase", "Bitmaps"))
            add(Movie("Leonardo", "Revenant"))

            add(PodCast("Nick Butcher", "Animations"))
            add(Movie("Sharukh", "Swades"))
            add(Music("Adele", "Set Fire to the Rain"))

            add(Movie("Aamir", "Pk"))
            add(Music("Imagine Dragons", "Birds"))
            add(PodCast("Venkat", "Programming Paradigms"))

            add(Music("Charlie Puth", "How Long"))
            add(PodCast("Amit Sekhar", "Android Main Thread"))
            add(Movie("Amitabh Bachan", "Sholay"))
        }
    }
}
