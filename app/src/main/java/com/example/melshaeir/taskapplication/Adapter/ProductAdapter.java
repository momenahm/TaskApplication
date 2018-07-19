package com.example.melshaeir.taskapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.melshaeir.taskapplication.Model.Product;
import com.example.melshaeir.taskapplication.R;
import com.example.melshaeir.taskapplication.ui.ImageActivity.ImageActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecAdapterViewHolder> {

    Context context;
    List<Product>list;

    public ProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public RecAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout,parent,false);
        return new RecAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecAdapterViewHolder holder, int position) {
        holder.txtPrice.setText("$ "+String.valueOf(list.get(position).getPrice()));
        holder.imgProduct.getLayoutParams().height = list.get(position).getImage().getHeight();
        holder.imgProduct.getLayoutParams().width = list.get(position).getImage().getWidth();
        Picasso.with(context).load(list.get(position).getImage().getUrl()).into(holder.imgProduct);
        holder.txtDescription.setText(list.get(position).getProductDescription());
        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean islongClick) {

                Intent intent =new Intent(context, ImageActivity.class);
                    intent.putExtra("image_ID", String.valueOf(list.get(position).getImage().getUrl()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class RecAdapterViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener
{

    ItemClickListner itemClickListner;
    TextView txtPrice,txtDescription;
    ImageView imgProduct;

    public RecAdapterViewHolder(View itemView) {
        super(itemView);
        txtPrice       = (TextView)itemView.findViewById(R.id.price);
        txtDescription = (TextView)itemView.findViewById(R.id.description);
        imgProduct     = (ImageView)itemView.findViewById(R.id.productImage);
        itemView.setOnClickListener(this);

    }
    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition(),false);
    }
}