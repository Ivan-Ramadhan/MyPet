package com.example.myapplication1.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.ui.fragments.ProductsFragment
import com.example.myapplication1.utils.Formatter
import com.example.myapplication1.utils.GlideLoader
import com.myshoppal.models.Product
import kotlinx.android.synthetic.main.item_list_layout.view.*
import java.util.*

open class MyProductsListAdapter(
   private val context: Context,
   private var list: ArrayList<Product>,
   private val fragment: ProductsFragment

) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_list_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is MyViewHolder) {

            GlideLoader(context).loadProductPicture(model.image, holder.itemView.iv_item_image)

            holder.itemView.tv_item_name.text = model.title

            val formattedprice = Formatter().rupiahFormatter(model.price)
            holder.itemView.tv_item_price.text = "${formattedprice}"


            holder.itemView.ib_delete_product.setOnClickListener {


                fragment.deleteProduct(model.product_id)

            }
            // END
        }
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}