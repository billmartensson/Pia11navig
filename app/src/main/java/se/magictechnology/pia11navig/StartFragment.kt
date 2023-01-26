package se.magictechnology.pia11navig

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.gootherButton).setOnClickListener {
            //findNavController().navigate(R.id.action_startFragment_to_otherFragment)

            val startnameET = view.findViewById<EditText>(R.id.startNameET)
            val startname = startnameET.text.toString()

            if(startname == "") {
                // FEL, inget namn
                Snackbar.make(view, "Du måste ange namn", Snackbar.LENGTH_INDEFINITE).setAction("Bartil") {
                    view.findViewById<EditText>(R.id.startNameET).setText("Bartil")
                }.setAnchorView(startnameET).show()

            } else {
                val action = StartFragmentDirections.actionStartFragmentToOtherFragment(startname, 4, null)
                findNavController().navigate(action)
            }


        }

        view.findViewById<Button>(R.id.gofancyButton).setOnClickListener {

            val action = StartFragmentDirections.actionStartFragmentToFancyFragment()
            findNavController().navigate(action)

        }

    }

}