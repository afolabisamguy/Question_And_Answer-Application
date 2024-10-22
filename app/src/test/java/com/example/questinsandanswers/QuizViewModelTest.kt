package com.example.questinsandanswers

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test

class QuizViewModelTest{
    @Test
    fun providesExpectedQuestionText(){
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }

//    @Test
//    fun doesNotWrapAroundQuestionBank(){
//        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 6))
//        val quizViewModel = QuizViewModel(savedStateHandle)
//        assertEquals(R.string.question_africa1, quizViewModel.currentQuestionText)
//        quizViewModel.movetoNext()
//        assertEquals(R.string.question_africa1, quizViewModel.currentQuestionText)
    }
