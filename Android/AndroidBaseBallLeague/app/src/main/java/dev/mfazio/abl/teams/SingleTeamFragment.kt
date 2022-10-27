package dev.mfazio.abl.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import dev.mfazio.abl.databinding.FragmentSingleTeamBinding

class SingleTeamFragment : Fragment() {

    //allows to send typed values between classes and to go here from another class
    private val args: SingleTeamFragmentArgs by navArgs()
    private val singleTeamViewModel by activityViewModels<SingleTeamViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSingleTeamBinding
            .inflate(inflater, container, false)
            .apply {
                vm = singleTeamViewModel.apply {

                    //teamId -  allow SingleTeamFragment to receive args from StandingsFragmen
                    setTeam(args.teamId)
                }

                lifecycleOwner = viewLifecycleOwner
            }

        return binding.root
    }
}