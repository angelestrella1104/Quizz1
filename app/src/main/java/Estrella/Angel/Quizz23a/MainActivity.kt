package Estrella.Angel.Quizz23a
import Estrella.Angel.Quizz23a.databinding.ActivityMainBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {

            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {

            checkAnswer(false)}
            binding.nextButton.setOnClickListener {
                currentIndex = (currentIndex + 1) % questionBank.size
                updateQuestion()
            }
        binding.prevButton.setOnClickListener {
            currentIndex = (currentIndex - 1) % questionBank.size
            updateQuestion()
        }


            updateQuestion()
        }
        private fun updateQuestion() {
            val questionTextResId = questionBank[currentIndex].textResId
            binding.questionTextView.setText(questionTextResId)
        }

        private fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = questionBank[currentIndex].answer
            val messageResId = if (userAnswer == correctAnswer) {
                R.string.correct_toast
            } else {
                R.string.incorrect_toast
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show()
        }
    }





