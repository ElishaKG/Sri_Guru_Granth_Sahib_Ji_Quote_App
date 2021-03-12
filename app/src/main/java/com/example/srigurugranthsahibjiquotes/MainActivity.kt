package com.example.srigurugranthsahibjiquotes

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.srigurugranthsahibjiquotes.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private val topicList = mutableListOf("One Universal Creator God. The Name Is Truth. Creative Being Personified. No Fear. No Hatred. Image Of The Undying, Beyond Birth, Self-Existent. By Guru's Grace. - Guru Nanak Dev Ji, 1, Japji Sahib", "Chant And Meditate. - Guru Nanak Dev Ji, 1, Japji Sahib", "True In The Primal Beginning. True Throughout The Ages. - Guru Nanak Dev Ji, 1, Japji Sahib", "True Here And Now. O Nanak, Forever And Ever True. - Guru Nanak Dev Ji, 1, Japji Sahib", "By thinking, He cannot be reduced to thought, even by thinking hundreds of thousands of times. - Guru Nanak Dev Ji, 1, Japji Sahib", "By remaining silent, inner silence is not obtained, even by remaining lovingly absorbed deep within. - Guru Nanak Dev Ji, 1, Japji Sahib", "The hunger of the hungry is not appeased, even by piling up loads of worldly goods. - Guru Nanak Dev Ji, 1, Japji Sahib")

    //do{
    //  File input using scanner
    //  scanner reads line until delimiter = (////)
    //  var quote  = what scanner read
    //  add(quote) to topicList
    // }
    //while(scanner is not at end of word document)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        generateTopic()
        pages()
    }

    private fun generateTopic() {
        val rollButton = findViewById<Button>(R.id.button7)
        val resultsTextView = findViewById<TextView>(R.id.Quote)

        rollButton.setOnClickListener {
            val random = (0 until (topicList.size)).random()
            resultsTextView.text = topicList[random]
        }

    }

    private fun pages() {
        val button = findViewById<Button>(R.id.button4)
        button.setOnClickListener {
            val intent = Intent(this, ardaas::class.java)
            startActivity(intent)

            val button = findViewById<Button>(R.id.button3)
            button.setOnClickListener {
                val intent = Intent(this, hukamnama::class.java)
                startActivity(intent)

                val button = findViewById<Button>(R.id.button5)
                button.setOnClickListener {
                    val intent = Intent(this, Nitnem::class.java)
                    startActivity(intent)

                    val button = findViewById<Button>(R.id.button8)
                    button.setOnClickListener {
                        val intent = Intent(this, calendar::class.java)
                        startActivity(intent)

                        val button = findViewById<Button>(R.id.button)
                        button.setOnClickListener {
                            val intent = Intent(this, Settings::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }
}