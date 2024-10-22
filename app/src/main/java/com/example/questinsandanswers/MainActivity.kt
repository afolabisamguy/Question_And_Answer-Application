package com.example.questinsandanswers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.questinsandanswers.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

    //He sure for me by phynofino

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()
    private var percentage = 0;
    private val cheatLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        //Handle the result
        if(result.resultCode == Activity.RESULT_OK) {
            quizViewModel.isCheater =
                result.data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")

      binding.trueButton.setOnClickListener {view: View ->
            checkAnswer(true)

      }

        binding.falseButton.setOnClickListener {view: View ->
           checkAnswer(false)

        }
        binding.questionTextView.setOnClickListener {view: View ->
            quizViewModel.movetoNext()
            updateQuestion();
        }

        binding.nextButton.setOnClickListener {view: View ->
            var temp = quizViewModel.currentIndex
            val temp2 = quizViewModel.questionSize - 2

            if(temp > temp2) {
                binding.nextButton.isEnabled = false
                result()
            } else {
                quizViewModel.movetoNext()
                updateQuestion()
                binding.trueButton.isEnabled = true
                binding.falseButton.isEnabled = true
            }
            binding.prevButton.isEnabled = true;

        }

        binding.prevButton.setOnClickListener {view: View ->
            var temp = quizViewModel.currentIndex
            if(temp <= 0){
                binding.prevButton.isEnabled = false
            }else{
                quizViewModel.movetoPrevious()
                updateQuestion()
                binding.trueButton.isEnabled = true
                binding.falseButton.isEnabled = true

            }
                binding.nextButton.isEnabled = true
            }

        binding.cheatButton.setOnClickListener {
            //start CheatActivity
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)
            cheatLauncher.launch(intent)
        }
            updateQuestion()
    }


    private fun updateQuestion() {

        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = when{
            quizViewModel.isCheater -> R.string.judgement_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }

        if(userAnswer == correctAnswer) {
            percentage += 1
        }
        val rootView = findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, messageResId, Snackbar.LENGTH_SHORT).show();
        binding.trueButton.isEnabled = false;
        binding.falseButton.isEnabled = false;

    }

    private fun result() {

            var temp = quizViewModel.questionSize -1
            percentage = percentage * 100
            percentage = Math.abs(percentage / temp)

            if (percentage > 50) {
                val rootView = findViewById<View>(android.R.id.content)
                Snackbar.make(rootView, R.string.passed, Snackbar.LENGTH_SHORT).show()
            } else {
                val rootView = findViewById<View>(android.R.id.content)
                Snackbar.make(rootView, R.string.failed, Snackbar.LENGTH_SHORT).show()

        }
    }
}