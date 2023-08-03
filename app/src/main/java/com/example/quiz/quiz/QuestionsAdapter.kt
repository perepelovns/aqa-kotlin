package com.example.quiz.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.QUIZ.R

class QuestionsAdapter(private val questions: List<Question>) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    private val answers: MutableMap<Int, Int> = mutableMapOf() // Мапа для хранения выбранных ответов
    private val selectedAnswers: MutableList<Int> = MutableList(questions.size) { -1 } // Список выбранных ответов


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions[position]


        holder.bind(question)

        holder.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            answers[position] = checkedId // Сохраняем выбранный ответ в мапе
            selectedAnswers[position] = checkedId // Обновляем список выбранных ответов
        }
    }

    fun getSelectedAnswers(): List<Int> {
        return selectedAnswers
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)

        fun bind(question: Question) {
            questionTextView.text = question.question

            // Создание и добавление радиокнопок на основе вариантов ответов в вопросе
            for (i in 0 until question.answers.size) {
                val radioButton = RadioButton(itemView.context)
                radioButton.text = question.answers[i]
                radioButton.id = i
                radioGroup.addView(radioButton)
            }

            // Установка выбранного ответа, если он уже был сохранен
            if (answers.containsKey(adapterPosition)) {
                radioGroup.check(answers[adapterPosition]!!)
            } else {
                radioGroup.clearCheck()
            }
        }
    }

}
