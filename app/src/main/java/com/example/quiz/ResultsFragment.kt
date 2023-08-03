package com.example.QUIZ

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.quiz.quiz.QuestionsAdapter
import androidx.activity.addCallback

class ResultsFragment : Fragment() {

    private lateinit var resultTextView: TextView
    private lateinit var restartButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        resultTextView = view.findViewById(R.id.resultTextView)
        restartButton = view.findViewById(R.id.restartButton)

        // чтобы при нажатии кнопки "Back" возвращаться на startFragment
        val callback = requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.startFragment)
        }
        callback.isEnabled = true

        // Получаем переданный результат из аргументов
        val result = arguments?.getString("result")
        resultTextView.text = result

        restartButton.setOnClickListener {
            // Обработка нажатия на кнопку "Начать заново"
            findNavController().popBackStack()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultsFragment()
    }
}
