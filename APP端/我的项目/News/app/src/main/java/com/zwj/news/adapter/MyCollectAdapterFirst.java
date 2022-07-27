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


public class MyCollectAdapterFirst extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<CommentEntity> datas;

    public void setDatas(List<CommentEntity> datas) {
        this.datas = datas;
    }

    private OnItemChildClickListener mOnItemChildClickListener;

    private OnItemClickListener mOnItemClickListener;


    public MyCollectAdapterFirst(Context context) {
        this.mContext = context;
    }

    public MyCollectAdapterFirst(Context context, List<CommentEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mycollect2_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ViewHolder vh = (ViewHolder) holder;
      //  CommentEntity newsEntity = datas.get(position);
        CommentEntity commentEntity = datas.get(position);

        vh.tvAuthor.setText(commentEntity.getNews().getTitle());
        vh.tvTitle.setText(commentEntity.getContent());
        Picasso.with(mContext)
                .load(commentEntity.getUser().getAvatarUrl())
                .placeholder(R.mipmap.header)
                .error(R.mipmap.header)
                .transform(new CircleTransform())
                .into(vh.imgHeader);
        Picasso.with(mContext)
                .load(commentEntity.getNews().getCoverimg())
                .placeholder(R.mipmap.load)
                .error(R.mipmap.bad)

                .into(vh.imageCover);
       vh.commentEntity=commentEntity;

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

    public void setOnItemClickListener(NewsAdapter.OnItemClickListener onItemClickListener) {
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView tvTitle;
        private TextView tvAuthor;
        private ImageView imgHeader;
        private ImageView imageCover;
        private CommentEntity commentEntity;
        public int mPosition;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvAuthor = view.findViewById(R.id.author);
            imgHeader = view.findViewById(R.id.img_header);
            imageCover=view.findViewById(R.id.img_cover);
            view.setTag(this);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(commentEntity);
                }
            });
        }
        }


    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }
}
