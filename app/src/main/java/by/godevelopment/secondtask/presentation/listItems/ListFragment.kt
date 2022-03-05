package by.godevelopment.secondtask.presentation.listItems

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.godevelopment.secondtask.data.DataSource
import by.godevelopment.secondtask.databinding.FragmentListBinding
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
        setupUi()
        return binding.root
    }

    private fun setupUi() {
        binding.rv.adapter = ListItemsAdapter().apply {
            list = DataSource.items
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}