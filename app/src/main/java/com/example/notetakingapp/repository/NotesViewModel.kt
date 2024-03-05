package com.example.notetakingapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel() : ViewModel() {
    private val _titleText: MutableLiveData<String> = MutableLiveData("")
    val titleText: LiveData<String> = _titleText


    private val _contentText: MutableLiveData<String> = MutableLiveData("")
    val contentText: LiveData<String> = _contentText
    fun newContentText(contentText: String) { _contentText.value = contentText }
    fun newNote(newTitle: String) { _titleText.value = newTitle }

}