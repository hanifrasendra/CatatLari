package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.catatanlari.databinding.FragmentRegistrasiBinding
import com.example.catatanlari.databinding.FragmentWelcomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [RegistrasiFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 *
 */

data class RegisterUser (
    val namaLengkap: String,
    val gender: String,
    val email: String,
    val password: String
)
class RegistrasiFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentBinding = FragmentRegistrasiBinding.inflate(
            inflater,
            container,
            false
        )

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding.btnRegister.setOnClickListener {
            val namaLengkap = fragmentBinding.etName.text.toString()
            val gender = fragmentBinding.etGender.text.toString()
            val email = fragmentBinding.etEmailRegister.text.toString()
            val password = fragmentBinding.etPasswordRegister.text.toString()

            //validasi inputan
            if (namaLengkap.isEmpty() || gender.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
            }

            val register = RegisterUser(
                namaLengkap = namaLengkap,
                gender = gender,
                email = email,
                password = password
            )


        }

        fragmentBinding.btnLogin.setOnClickListener {
            findNavController().navigate(
                RegistrasiFragmentDirections.actionRegistrasiFragmentToBerandaFragment()
            )
        }

    }



}