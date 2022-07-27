package com.zwj.news.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zwj.news.R;
import com.zwj.news.entity.NewsEntity;
import com.zwj.news.listener.OnItemChildClickListener;
import com.zwj.news.listener.OnItemClickListener;
import com.zwj.news.view.CircleTransform;

import java.io.Serializable;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private List<NewsEntity> datas;
    private static OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    public NewsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDatas(List<NewsEntity> datas) {
        this.datas = datas;
    }

    public NewsAdapter(Context context, List<NewsEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    //根据view的类型去创建不同item的viewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    //给控件赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        NewsEntity newsEntity = datas.get(position);
        vh.tvTitle.setText(newsEntity.getTitle());
        vh.tvAuthor.setText(newsEntity.getUser().getNickname());

        vh.newsEntity=newsEntity;

      Picasso.with(mContext).load(newsEntity.getCoverimg()).placeholder(R.mipmap.load).error(R.mipmap.bad).into(vh.imageViewCover);
        Picasso.with(mContext).load(newsEntity.getUser().getAvatarUrl()).transform(new CircleTransform()).placeholder(R.mipmap.header).error(R.mipmap.header).into(vh.imageViewHeard);
    }

        @Override
        public int getItemCount () {
            if (datas != null && datas.size() > 0) {
                return datas.size();
            } else {
                return 0;
            }
        }

    public Context getmContext() {
        return mContext;
    }

    public List<NewsEntity> getDatas() {
        return datas;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvTitle;
            private TextView tvAuthor;
            private TextView tvDz;
            private TextView tvComment;
            private TextView tvCollect;
            private ImageView imageViewCover;
            private ImageView imageViewHeard;
            private NewsEntity newsEntity;
            private ImageView imgCollect;
            private ImageView imageDZ;

            public ViewHolder(@NonNull View view) {
                super(view);
                tvTitle = view.findViewById(R.id.title);
                tvAuthor = view.findViewById(R.id.author);

                imageViewCover=view.findViewById(R.id.img_cover);
                imageViewHeard=view.findViewById(R.id.img_header);
                imgCollect=view.findViewById(R.id.img_collect);

                //通过tag将ViewHolder和itemView绑定
                view.setTag(this);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnItemClickListener.onItemClick(newsEntity);
                    }
                });
            }


        }

    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }

}
