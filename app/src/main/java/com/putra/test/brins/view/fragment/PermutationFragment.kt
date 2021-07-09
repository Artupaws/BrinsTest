package com.putra.test.brins.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.putra.test.brins.R
import com.putra.test.brins.databinding.FragmentPermutationBinding

class PermutationFragment : Fragment(), View.OnClickListener {

    private lateinit var binding:FragmentPermutationBinding
    private var value:Int = 0
    private var max:Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPermutationBinding.inflate(layoutInflater)
        binding.btnPermutation.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etTextOne.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null){
                    if (s.isNotEmpty()){
                        value = s.toString().toInt()
                    } else {
                        value = 0
                        binding.tvResult.text = ""
                    }
                }
            }

        })

        binding.etTextTwo.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null){
                    if (s.isNotEmpty()){
                        max = s.toString().toInt()
                    } else {
                        max = 0
                        binding.tvResult.text = ""
                    }
                }
            }

        })

    }

    private fun inputData(value:Int, max:Int){
        val a: MutableList<String> = ArrayList()
        for (i in 0 until value) {
            a.add((i + 1).toString())
        }
        permutation(a, "", max)
    }

    private fun permutation(a: List<String>, result: String, l: Int) {
        if (result.length == l) {
            return
        }
        for (i in 0 until a.size) {
            val nr = result + a[i]
            permutation(a, nr, l)
            binding.tvResult.append("${nr}-")
            Toast.makeText(requireActivity(), nr, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_permutation -> {
                if (value != 0 && max != 0){
                    inputData(value, max)
                } else {
                    Toast.makeText(requireContext(), "Please fill EditText", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}