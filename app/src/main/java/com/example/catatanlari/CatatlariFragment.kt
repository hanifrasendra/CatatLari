package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.catatanlari.databinding.FragmentCatatlariBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CatatlariFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

data class catatLari (
    val jadwal: String,
    val jarak: String,
    val waktu: String
)
class CatatlariFragment : Fragment() {

    private lateinit var catatlariBinding: FragmentCatatlariBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        catatlariBinding = FragmentCatatlariBinding.inflate(
            inflater,
            container,
            false
        )
        return catatlariBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catatlariBinding.btnSimpan.setOnClickListener {
            val jadwal = catatlariBinding.etDate.text.toString()
            val jarak = catatlariBinding.etDistance.text.toString()
            val waktu = catatlariBinding.etTime.text.toString()

            if(jadwal.isEmpty() || jarak.isEmpty() || waktu.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            }

            val inputCatatLari = catatLari(
                jadwal = jadwal,
                jarak = jarak,
                waktu = waktu
            )


        }
    }
}