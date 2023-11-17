package com.example.ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ud06_3_guessgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    val gameModel: GameViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_game, container, false)
        _binding = FragmentGameBinding.inflate(inflater, container,false)
        val view = binding.root

        binding.buttonNext.setOnClickListener {
//            gameModel.secretWord = "Plabra de prueba"
//
            if (binding.txtGuess.text.length>0){
                gameModel.game(binding.txtGuess.text.toString()[0])
//                updateScreen()
                if (gameModel.win()||gameModel.lost())
                    view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }else{
                Toast.makeText(context,"Introduce una letra",Toast.LENGTH_LONG).show()
            }
        }
        gameModel.lives.observe(
            viewLifecycleOwner, Observer {
                newValue -> binding.txtLives.text = "Te quedan ${newValue} vidas"
            }
        )
        gameModel.secretWordDisplay.observe(
            viewLifecycleOwner, Observer {
                it -> binding.txtWord.text = it
            }
        )
        return view
    }

//    fun updateScreen(){
//        binding.txtWord.text = gameModel.secretWordDisplay.value
//        binding.txtLives.text = "Te quedan ${gameModel.lives} vidas"
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}