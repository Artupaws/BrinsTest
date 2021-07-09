package com.putra.test.brins.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.putra.test.brins.R
import com.putra.test.brins.databinding.FragmentFibonacciBinding

class FibonacciFragment : Fragment(),View.OnClickListener {

    private lateinit var _binding: FragmentFibonacciBinding
    private val binding get() = _binding
    private var value:Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFibonacciBinding.inflate(inflater, container, false)
        binding.btnFibonacci.setOnClickListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etNumber.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                false
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if(s.isNotEmpty()){
                        value = s.toString().toInt()
                    }
                } else {
                    binding.etNumber.text.clear()
                }
            }
        })
    }

    private fun checkFibonacci(number:Int){
        var value1 = 0
        var value2 = 1

        for (i in 1..number) {
            binding.tvResult.append("$value1 +")
            Toast.makeText(requireContext(), "$value1 +", Toast.LENGTH_SHORT).show()
            val sum = value1 + value2
            value1 = value2
            value2 = sum
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_fibonacci -> {
                checkFibonacci(value)
            }
        }
    }
}