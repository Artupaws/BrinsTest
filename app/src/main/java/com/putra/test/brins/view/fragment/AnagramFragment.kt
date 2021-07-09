package com.putra.test.brins.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.putra.test.brins.R
import com.putra.test.brins.databinding.FragmentAnagramBinding

class AnagramFragment : Fragment(), View.OnClickListener {

    private lateinit var _binding:FragmentAnagramBinding
    private val binding get() = _binding
    private var value1:String = ""
    private var value2:String = ""
    private val charRange = 256

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAnagramBinding.inflate(inflater, container, false)
        binding.btnAnagram.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etTextOne.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null){
                    if (s.isNotEmpty()){
                        value1 = s.toString()
                    } else {
                        value1 = ""
                        binding.tvResult.text = ""
                    }
                }
            }
        })

        binding.etTextTwo.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null){
                    if (s.isNotEmpty()){
                        value2 = s.toString()
                     } else {
                        value2 = ""
                        binding.tvResult.text = ""
                    }
                }
            }

        })

    }

    @SuppressLint("SetTextI18n")
    private fun checkAnagram(value1:String, value2:String){
        val str1 = value1
        val str2 = value2
        if (str1.length != str2.length) {
            binding.tvResult.text = "Strings are not Anagrams of each other"
        } else {
            val count = IntArray(charRange)
            for (i in str1.indices) {
                count[str1[i].code]++
                count[str2[i].code]--
            }
            for (i in 0 until charRange) {
                if (count[i] != 0) {
                    binding.tvResult.text = "Strings are not Anagrams of each other"
                }
            }
            binding.tvResult.text = "Strings are Anagrams of each other"
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_permutation -> {
                if (value1 != "" && value2 != ""){
                    checkAnagram(value1, value2)
                } else {
                    Toast.makeText(requireContext(), "Please fill EditText", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}