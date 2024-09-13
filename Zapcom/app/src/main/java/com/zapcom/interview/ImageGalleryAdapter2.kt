package com.zapcom.interview


import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zapcom.interview.models.ImageListObjectItem


class ImageGalleryAdapter2(private val context: Context?, val itemList: List<ImageListObjectItem?>, val displayType: String?) : RecyclerView.Adapter<ImageGalleryAdapter2.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val baseView = view
        val iv_item_view: ImageView = view.findViewById(R.id.iv_item_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.jklistitemimage, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val totalImageWidth = context?.getResources()?.getDisplayMetrics()?.widthPixels!! - TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            32.0f,
            context?.getResources()?.getDisplayMetrics()
        )
        var ht_px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            240.0f,
            context?.getResources()?.getDisplayMetrics()
        )
        var wt_px = totalImageWidth
        if(displayType?.lowercase().equals("splitbanner")) {
            wt_px = totalImageWidth / 2
        }else if(displayType?.lowercase().equals("horizontalfreescroll")) {
           // wt_px = (totalImageWidth / 3.3).toFloat()
            wt_px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                124.0f,
                context?.getResources()?.getDisplayMetrics()
            )
            ht_px = wt_px;
        }

        Glide.with(holder.iv_item_view)
            .load(itemList[position]?.image)
            .into(holder.iv_item_view)
        (holder.iv_item_view.getLayoutParams() as LinearLayout.LayoutParams).width = wt_px.toInt()
        (holder.iv_item_view.getLayoutParams() as LinearLayout.LayoutParams).height = ht_px.toInt()

    }

    override fun getItemCount() = itemList.size
}
