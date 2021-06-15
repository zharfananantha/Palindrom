package com.example.palindrom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var listAllkata: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listAllkata = arrayListOf()

        addKataBtn.setOnClickListener {
            listAllkata.add(inputKata.text.toString())
            Toast.makeText(this, "Word Added", Toast.LENGTH_SHORT).show()
            inputKata.text?.clear()
        }

        showAllKataBtn.setOnClickListener {
            var tampungShowAll = ""
            for (element in listAllkata) {
                tampungShowAll = tampungShowAll + element + "\n"
            }
            showAllKataText.text = tampungShowAll
        }

        showPalindromKataBtn.setOnClickListener {
            var palindromWords = ""
            for (element in listAllkata) {
                var polTemp = ""
                for (i in element.length downTo 1) {
                    var temp = element.substring(i-1, i)
                    polTemp+=temp
                }
                Log.d("CEK", polTemp)
                if (polTemp.equals(element))
                    palindromWords = palindromWords + element + "\n"
            }

            Log.d("CEK", "Palindrom words $palindromWords")
            if (palindromWords.isEmpty())
                showAllPalindromKataText.text = "Tidak ada palindrom"
            else
                showAllPalindromKataText.text = palindromWords
        }
    }
}