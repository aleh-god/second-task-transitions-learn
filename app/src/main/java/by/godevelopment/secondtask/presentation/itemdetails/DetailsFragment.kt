package by.godevelopment.secondtask.presentation.itemdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import by.godevelopment.secondtask.data.DataSource
import by.godevelopment.secondtask.databinding.FragmentDetailsBinding
import by.godevelopment.secondtask.presentation.MainActivity
import by.godevelopment.secondtask.presentation.TAG
import by.godevelopment.secondtask.presentation.TAG_BUNDLE

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val id = requireArguments().getInt(TAG_BUNDLE)
        Log.i(TAG, "DetailsFragment: requireArguments() id = $id")
        setupUi(id)
        return binding.root
    }

    private fun setupUi(id: Int) {
        val itemModel = DataSource.items.first {
            it.id == id
        }
        binding.apply {
            tittleItem.text = itemModel.title
            descriptionItem.text = itemModel.description
            AppCompatResources.getDrawable(binding.root.context, itemModel.drawableSrc)?.let {
                drawable.setImageDrawable(it)
            }
            btnExit.setOnClickListener {
                (activity as MainActivity).exitApp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}