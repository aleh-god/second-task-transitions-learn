package by.godevelopment.secondtask.presentation.listItems.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.godevelopment.secondtask.databinding.ItemListBinding
import by.godevelopment.secondtask.domain.model.ItemModel
import by.godevelopment.secondtask.presentation.TAG

class ListItemsAdapter(
    private val onClickItem: (Int) -> Unit
): RecyclerView.Adapter<ListItemsAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemModel: ItemModel) {
            binding.apply {
                tittleItem.text = itemModel.title
                descriptionItem.text = itemModel.description
                getDrawable(binding.root.context, itemModel.drawableSrc)?.let {
                    drawable.setImageDrawable(it)
                }
                root.setOnClickListener {
                    Log.i(TAG, "ListItemsAdapter: onClick id = ${itemModel.id}")
                    onClickItem.invoke(itemModel.id)
                }
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var list: List<ItemModel>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemsAdapter.ItemViewHolder {
        return ItemViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListItemsAdapter.ItemViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}