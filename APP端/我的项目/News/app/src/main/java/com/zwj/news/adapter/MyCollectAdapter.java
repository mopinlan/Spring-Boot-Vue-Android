package com.zwj.news.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zwj.news.R;
import com.zwj.news.activity.MyCollectActivity;
import com.zwj.news.entity.CommentEntity;
import com.zwj.news.entity.NewsEntity;
import com.zwj.news.listener.OnItemChildClickListener;
import com.zwj.news.listener.OnItemClickListener;
import com.zwj.news.view.CircleTransform;

import java.io.Serializable;
import java.util.List;


public class MyCollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<CommentEntity> datas;

    public void setDatas(List<CommentEntity> datas) {
        this.datas = datas;
    }

    private OnItemChildClickListener mOnItemChildClickListener;

    private OnItemClickListener mOnItemClickListener;


    public MyCollectAdapter(Context context) {
        this.mContext = context;
    }

    public MyCollectAdapter(Context context, List<CommentEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mycollect_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ViewHolder vh = (ViewHolder) holder;
        CommentEntity commentEntity = datas.get(position);
        vh.tvTitle.setText(commentEntity.getNews().getTitle());
        vh.tvAuthor.setText(commentEntity.getUser().getNickname());
        Picasso.with(mContext)
                .load(commentEntity.getUser().getAvatarUrl())
                .transform(new CircleTransform())
                .into(vh.imgHeader);

        Picasso.with(mContext)
                .load(commentEntity.getNews().getCoverimg())
                .into(vh.mThumb);
        vh.mPosition = position;
    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        } else {
            return 0;
        }
    }

    public void setOnItemChildClickListener(MyCollectActivity myCollectActivity) {
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle;
        private TextView tvAuthor;
        private ImageView imgHeader;
        public ImageView mThumb;
        public int mPosition;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvAuthor = view.findViewById(R.id.author);
            imgHeader = view.findViewById(R.id.img_header);
            mThumb=view.findViewById(R.id.img_cover);
            view.setTag(this);

        }

        @Override
        public void onClick(View v) {

                if (mOnItemChildClickListener != null) {
                    mOnItemChildClickListener.onItemChildClick(mPosition);
                }

                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(mPosition);
                }
            }


    }
    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

}
