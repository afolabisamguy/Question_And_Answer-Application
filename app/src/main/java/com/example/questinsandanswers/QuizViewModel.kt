package com.example.questinsandanswers

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_africa, false),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
        Question(R.string.question_africa1, true),
        Question(R.string.question_1, true),
        Question(R.string.question_2, false),
        Question(R.string.question_3, false),
        Question(R.string.question_4, true),
        Question(R.string.question_5, true),
        Question(R.string.question_6, true),
        Question(R.string.question_7, true),
        Question(R.string.question_8, false),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, true),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, false),
        Question(R.string.question_15, true),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, true),
        Question(R.string.question_19, true),
        Question(R.string.question_20, false),
        Question(R.string.question_21, false),
        Question(R.string.question_22, false),
        Question(R.string.question_23, true),
        Question(R.string.question_24, false),
        Question(R.string.question_25, true),
        Question(R.string.question_26, false),
        Question(R.string.question_27, true),
        Question(R.string.question_28, false),
        Question(R.string.question_29, true),
        Question(R.string.question_30, false),
        Question(R.string.question_31, true),
        Question(R.string.question_32, false),
        Question(R.string.question_33, false),
        Question(R.string.question_34, false),
        Question(R.string.question_35, false),
        Question(R.string.question_36, true),
        Question(R.string.question_37, false),
        Question(R.string.question_38, true),
        Question(R.string.question_39, false),
        Question(R.string.question_40, false),
        Question(R.string.question_41, true),
        Question(R.string.question_42, false),
        Question(R.string.question_43, false),
        Question(R.string.question_44, false),
        Question(R.string.question_45, true),
        Question(R.string.question_46, false),
        Question(R.string.question_47, true),
        Question(R.string.question_48, false),
        Question(R.string.question_49, true),
        Question(R.string.question_50, true))

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

     var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)


val currentQuestionAnswer: Boolean
    get() = questionBank[currentIndex].answer

val currentQuestionText: Int
    get() =  questionBank[currentIndex].textResId

fun movetoNext(){
    currentIndex = currentIndex + 1
}

fun movetoPrevious(){
    currentIndex = currentIndex - 1
}
var questionSize: Int = questionBank.size

var currentIndexter: Int = currentIndex
}