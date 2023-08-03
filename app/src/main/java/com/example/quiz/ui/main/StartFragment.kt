package com.example.quiz.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.QUIZ.R

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonContinue = view.findViewById<Button>(R.id.buttonContinue)
        buttonContinue.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
        }
    }
}
