package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catatanlari.databinding.FragmentCatatlariBinding

data class catatLari (
    val jadwal: String,
    val jarak: String,
    val waktu: String
)

class CatatlariFragment : Fragment() {

    private lateinit var catatlariBinding: FragmentCatatlariBinding
    private lateinit var adapter: CatatLariAdapter
    private val dataList = mutableListOf<catatLari>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        catatlariBinding = FragmentCatatlariBinding.inflate(inflater, container, false)
        return catatlariBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        adapter = CatatLariAdapter(dataList)
        catatlariBinding.rvCatatLari.layoutManager = LinearLayoutManager(requireContext())
        catatlariBinding.rvCatatLari.adapter = adapter

        catatlariBinding.btnSimpan.setOnClickListener {
            val jadwal = catatlariBinding.etDate.text.toString()
            val jarak = catatlariBinding.etDistance.text.toString()
            val waktu = catatlariBinding.etTime.text.toString()

            if(jadwal.isEmpty() || jarak.isEmpty() || waktu.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val inputCatatLari = catatLari(
                    jadwal = jadwal,
                    jarak = jarak,
                    waktu = waktu
                )
                adapter.addData(inputCatatLari)
                
                // Clear inputs
                catatlariBinding.etDate.text?.clear()
                catatlariBinding.etDistance.text?.clear()
                catatlariBinding.etTime.text?.clear()
                
                Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}