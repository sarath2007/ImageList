package com.zapcom.interview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zapcom.interview.models.ImageListObject

class ImageGalleryAdapter(private val context: Context?, var itemList: List<ImageListObject>) : RecyclerView.Adapter<ImageGalleryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_item_tittle)
        val hsv_imagelist:RecyclerView = view.findViewById(R.id.hsv_imagelist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.jklistitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = itemList[position].sectionType
        val imageGalleryAdapter1 = ImageGalleryAdapter2(context,itemList[position].items,itemList[position].sectionType)
        holder.hsv_imagelist.apply {
            layoutManager =
                LinearLayoutManager(
                    context, LinearLayoutManager.HORIZONTAL, false
                )
        //    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL ) )

        }
        holder.hsv_imagelist.adapter = imageGalleryAdapter1

    }

    override fun getItemCount() = itemList.size
}
