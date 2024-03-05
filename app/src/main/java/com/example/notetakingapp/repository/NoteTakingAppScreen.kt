package com.example.notetakingapp.repository

import androidx.annotation.StringRes
import com.example.notetakingapp.R

enum class NoteTakingAppScreen(@StringRes val text : Int) {
        Main(R.string.home),
        Notes(R.string.notes)

}
