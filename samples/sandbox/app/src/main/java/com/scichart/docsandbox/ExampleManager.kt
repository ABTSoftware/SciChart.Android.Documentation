package com.scichart.docsandbox

import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.ExampleBaseFragment
import com.scichart.docsandbox.examples.java.ExamplesJava
import com.scichart.docsandbox.examples.javaBuilder.ExamplesJavaBuilderAPI
import com.scichart.docsandbox.examples.kotlin.ExamplesKotlin

class ExampleManager {
    companion object {
        const val EXAMPLE_ID = "ExampleId"

        const val EXAMPLE_LIST_ID = "ExampleListId"

        const val KOTLIN_EXAMPLES_ID = "Kotlin"
        const val JAVA_EXAMPLES_ID = "Java"
        const val JAVA_BUILDERS_EXAMPLES_ID = "JavaBuilders"

        private val KOTLIN_EXAMPLES = getExampleList(ExamplesKotlin)
        private val JAVA_EXAMPLES = getExampleList(ExamplesJava)
        private val JAVA_BUILDERS_EXAMPLES = getExampleList(ExamplesJavaBuilderAPI)

        private val ALL_EXAMPLES = ArrayList<Example>().apply {
            addAll(KOTLIN_EXAMPLES)
            addAll(JAVA_EXAMPLES)
            addAll(JAVA_BUILDERS_EXAMPLES)
        }

        private val examples = ALL_EXAMPLES.associateBy { it.title }

        fun getExamples(examples: String?) : List<Example> {
            return when(examples) {
                KOTLIN_EXAMPLES_ID -> KOTLIN_EXAMPLES
                JAVA_EXAMPLES_ID -> JAVA_EXAMPLES
                JAVA_BUILDERS_EXAMPLES_ID -> JAVA_BUILDERS_EXAMPLES

                else -> ALL_EXAMPLES
            }
        }

        fun createFragmentForTitle(title: String) : ExampleBaseFragment<*>? {
            return examples[title]?.fragment?.newInstance() as? ExampleBaseFragment<*>?
        }

        private fun createExampleFrom(example: Class<*>, definition: ExampleDefinition): Example {
            val title = definition.title.let {
                if(it.isEmpty())
                    example.simpleName
                else
                    it
            }

            val category = definition.category.let {
                if(it.isEmpty())
                    example.`package`?.name?.split(".")?.last() ?: it
                else
                    it
            }

            return Example(title, category, example)
        }

        private fun getExampleList(classes: List<Class<*>>) : List<Example> {
            return ArrayList<Example>().apply {
                for (example in classes) {
                    example.getAnnotation(ExampleDefinition::class.java)?.let { definition ->
                        add(createExampleFrom(example, definition))
                    }
                }
            }
        }
    }
}

data class Example(val title: String, val category: String, val fragment: Class<*>)
