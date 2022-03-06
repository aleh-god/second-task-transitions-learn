package by.godevelopment.secondtask.presentation.listItems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import by.godevelopment.secondtask.R
import by.godevelopment.secondtask.data.DataSource
import by.godevelopment.secondtask.databinding.FragmentListBinding
import by.godevelopment.secondtask.presentation.MainActivity
import by.godevelopment.secondtask.presentation.TAG_BUNDLE
import by.godevelopment.secondtask.presentation.itemdetails.DetailsFragment
import by.godevelopment.secondtask.presentation.listItems.adapter.ListItemsAdapter

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        _binding = FragmentListBinding.inflate(inflater, container, false)
        setupUi((activity as MainActivity).onClick)
        return binding.root
    }

    private fun setupUi(onClickItem: (Int) -> Unit) {
        binding.rv.adapter = ListItemsAdapter(onClickItem).apply {
            list = DataSource.items
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}