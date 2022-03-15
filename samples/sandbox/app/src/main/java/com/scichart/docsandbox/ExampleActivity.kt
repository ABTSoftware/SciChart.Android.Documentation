package com.scichart.docsandbox

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.scichart.docsandbox.databinding.ActivityExampleBinding
import com.scichart.docsandbox.examples.base.ExampleBaseFragment
import com.scichart.extensions.builders.SciChartBuilder
import com.scichart.extensions3d.builders.SciChart3DBuilder

class ExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SciChartBuilder.init(this)
        SciChart3DBuilder.init(this)

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar

        // hideSystemBars()

        val binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpExample(savedInstanceState)
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return

        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

    override fun onDestroy() {
        super.onDestroy()

        SciChartBuilder.dispose()
        SciChart3DBuilder.dispose()
    }

    private fun setUpExample(savedInstanceState: Bundle?) {
        val exampleId = intent.getStringExtra(ExampleManager.EXAMPLE_ID) ?: return
        title = exampleId

        val fragmentManager = supportFragmentManager

        val exampleFragment = if (savedInstanceState != null)
            fragmentManager.findFragmentByTag(FRAGMENT_TAG) as ExampleBaseFragment<*>?
        else
            ExampleManager.createFragmentForTitle(exampleId)

        if (exampleFragment != null && !exampleFragment.isInLayout) {
            fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, exampleFragment, FRAGMENT_TAG)
                .commit()

            supportFragmentManager.executePendingTransactions()
        }
    }

    companion object {
        private const val FRAGMENT_TAG = "FragmentTag";
    }
}
