package com.example.mynews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.zip.Inflater;
public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewHolder>  {
  public static final String EXTRA_URL="NewUrl";
    private Context mCtx;
    private List<News> newsList;

    public NewAdapter(Context mCtx, List<News> newsList) {
        this.mCtx = mCtx;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.layout_news,null,true);
        return new NewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, int position) {
        News news=newsList.get(position);
        Glide.with(mCtx).load(news.getNewUrlImage()).into(holder.imageViewUrl);
        holder.textViewTitle.setText(news.getTitle());
        holder.textViewContent.setText(news.getNewContent());
        holder.textViewAuthor.setText(news.getAuthor());
        holder.btn_newUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mCtx,NewViewPage.class);
                intent.putExtra(EXTRA_URL,news.getNewUrl());
                mCtx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewHolder  extends RecyclerView.ViewHolder {
     TextView textViewTitle,textViewContent,textViewAuthor,textViewUrlNew;
     ImageView imageViewUrl;
     Button btn_newUrl;
    public NewHolder(@NonNull View itemView) {
        super(itemView);
            textViewTitle=itemView.findViewById(R.id.textView_title);
            textViewAuthor=itemView.findViewById(R.id.textView_author);
            textViewContent=itemView.findViewById(R.id.textView_Content);
            imageViewUrl=itemView.findViewById(R.id.image_url);
            btn_newUrl=itemView.findViewById(R.id.news_url);
       //    button_click=itemView.findViewById(R.id.btnNewsUrl);
    }
}
}
