package com.scichart.docsandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.scichart.docsandbox.core.ExampleListFragment
import com.scichart.docsandbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        onSelectedIdChanged(binding.navigationView.selectedItemId)

        binding.navigationView.setOnItemSelectedListener {
            onSelectedIdChanged(it.itemId)

            true
        }

        setContentView(binding.root)
    }

    private fun onSelectedIdChanged(id: Int) {
        when(id) {
            R.id.kotlin -> switchExamples(ExampleManager.KOTLIN_EXAMPLES_ID)
            R.id.java -> switchExamples(ExampleManager.JAVA_EXAMPLES_ID)
            R.id.javaBuilders -> switchExamples(ExampleManager.JAVA_BUILDERS_EXAMPLES_ID)

            else -> {}
        }
    }

    private fun switchExamples(examples: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)

            val bundle = Bundle().apply {
                putString(ExampleManager.EXAMPLE_LIST_ID, examples)
            }

            replace(R.id.fragment_container, ExampleListFragment::class.java, bundle)
        }
    }
}
