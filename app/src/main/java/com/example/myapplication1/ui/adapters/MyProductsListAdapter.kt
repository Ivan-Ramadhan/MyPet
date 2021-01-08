package com.example.myapplication1.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.models.Product
import com.example.myapplication1.ui.activities.ProductDetailsActivity
import com.example.myapplication1.ui.fragments.ProductsFragment
import com.example.myapplication1.utils.Constants
import com.example.myapplication1.utils.Formatter
import com.example.myapplication1.utils.GlideLoader
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

            val formattedPrice = Formatter().rupiahFormatter(model.price)
            holder.itemView.tv_item_price.text = "${formattedPrice}"


            holder.itemView.ib_delete_product.setOnClickListener {


                fragment.deleteProduct(model.product_id)

            }

            holder.itemView.setOnClickListener{
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_PRODUCT_ID, model.product_id)
                intent.putExtra(Constants.EXTRA_PRODUCT_OWNER_ID, model.user_id)
                context.startActivity(intent)
            }

        }
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}