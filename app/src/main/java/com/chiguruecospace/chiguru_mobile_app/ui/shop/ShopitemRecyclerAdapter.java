package com.chiguruecospace.chiguru_mobile_app.ui.shop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.chiguruecospace.chiguru_mobile_app.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShopitemRecyclerAdapter extends RecyclerView.Adapter<ShopitemRecyclerAdapter.ViewHolder>{

    public List<ShopViewModel> shoplist;
    private Context mContext;

    public ShopitemRecyclerAdapter(Context context, List<ShopViewModel> shoplist){

        this.shoplist = shoplist;
        this.mContext = context;

    }

    @NonNull
    @Override
    public ShopitemRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_shopitem, parent, false);
        return new ShopitemRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopitemRecyclerAdapter.ViewHolder holder, int position) {

        final String descdata = shoplist.get(position).getDescription();
        final String namedata = shoplist.get(position).getName();
        final String imagedata = shoplist.get(position).getImagepath();
        final int pricedata = shoplist.get(position).getPrice();

        holder.parentlayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(mContext, ShopActivity.class);
                    intent.putExtra("descdata", descdata);
                    intent.putExtra("namedata", namedata);
                    intent.putExtra("imagedata", imagedata);
                    intent.putExtra("pricedata", pricedata);
                    mContext.startActivity(intent);
                }catch (Exception e){

                    Toast.makeText(mContext, "Error: "+e, Toast.LENGTH_SHORT).show();

                }
            }
        });

        holder.setDescText(descdata);
        holder.setNameText(namedata);
        holder.setShopImage(imagedata);
        holder.setPrice(pricedata);

    }

    @Override
    public int getItemCount() {
        return shoplist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView descview;
        private TextView heading;
        private ImageView image;
        private View mView;
        ConstraintLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
            parentlayout = itemView.findViewById(R.id.shopparentlayout);

        }

        public void setDescText(String text){

            descview = mView.findViewById(R.id.shopdesctext);
            descview.setText(text);

        }

        public void setNameText(String name){

            heading = mView.findViewById(R.id.shopheadingtext);
            heading.setText(name);

        }

        public void setPrice(int price){

            heading = mView.findViewById(R.id.shopcardprice);
            heading.setText(price);

        }

        public void setShopImage(String text){

            FirebaseStorage storage = FirebaseStorage.getInstance();
            // Create a reference to a file from a Google Cloud Storage URI
            StorageReference gsReference = storage.getReferenceFromUrl(text);

            image = (ImageView) mView.findViewById(R.id.shopimage);

            try {
                final File file = File.createTempFile("image","jpg");
                gsReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        image.setImageBitmap(bitmap);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
