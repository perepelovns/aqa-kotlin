package com.example.quiz.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.QUIZ.R
import com.example.quiz.quiz.QuestionsAdapter
import com.example.quiz.quiz.QuizStorage

class HomeFragment: Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val quiz = QuizStorage.getQuiz(QuizStorage.Locale.Ru) // Язык (Ru или En)
        val adapter = QuestionsAdapter(quiz.questions)
        recyclerView.adapter = adapter

        val buttonBack = view.findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            // Обработка нажатия на кнопку "Назад"
            findNavController().popBackStack()
        }

            // Обработка нажатия на кнопку "Отправить"
        val buttonSubmit = view.findViewById<Button>(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            // ответы на вопросы
            val answers = adapter.getSelectedAnswers()

            // результаты опросника
            val result = QuizStorage.answer(quiz, answers)

            // Bundle для передачи результата на результирующий экран
            val bundle = Bundle()
            bundle.putString("result", result)

            // переход на результирующий экран с передачей Bundle
            findNavController().navigate(R.id.resultsFragment, bundle)
        }
    }
}


