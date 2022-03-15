package com.scichart.docsandbox.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.composethemeadapter.MdcTheme
import com.scichart.docsandbox.Example
import com.scichart.docsandbox.ExampleActivity
import com.scichart.docsandbox.ExampleManager
import com.scichart.docsandbox.R

class ExampleListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val examples = createExampleList(arguments)

        return ComposeView(inflater.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MdcTheme { // or AppCompatTheme
                    ScreenContent(examples)
                }
            }
        }
    }

    private fun createExampleList(bundle: Bundle?): Map<String, List<Example>> {
        val id = bundle?.getString(ExampleManager.EXAMPLE_LIST_ID)

        val appName = getString(R.string.app_name)
        requireActivity().title = if(id != null) "$appName - $id" else appName

        return ExampleManager.getExamples(id).groupBy { it.category }
    }

    @Composable
    private fun ScreenContent(exampleMap: Map<String, List<Example>>) {
        Column(modifier = Modifier.
            verticalScroll(rememberScrollState())
        ) {
            for ((header, examples) in exampleMap) {
                CategoryHeader(header)

                Divider(modifier = Modifier.padding(start = 16.dp))

                for (example in examples) {
                    ExampleItem(example)
                }

                Divider(modifier = Modifier.padding(start = 16.dp))
            }
        }
    }

    @Composable
    private fun CategoryHeader(title: String) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(16.dp, 8.dp)
        )
    }

    @Composable
    private fun ExampleItem(example: Example) {
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .clickable(onClick = { startExample(example, context) })
                .fillMaxWidth()
                .padding(16.dp, 8.dp)
        ) {
            Text(
                text = example.title,
                style = MaterialTheme.typography.button
            )
        }
    }

    private fun startExample(example: Example, context: Context) {
        val exampleActivity = Intent(context, ExampleActivity::class.java)

        exampleActivity.putExtra(ExampleManager.EXAMPLE_ID, example.title)

        ContextCompat.startActivity(context, exampleActivity, null)
    }
}
