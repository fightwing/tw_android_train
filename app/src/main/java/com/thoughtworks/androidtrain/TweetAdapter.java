package com.thoughtworks.androidtrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.thoughtworks.androidtrain.data.model.Tweet;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {

  private static final String TAG = "TweetAdapter";

  private final Context context;

  private List<Tweet> tweets = new ArrayList<>();

  public TweetAdapter(Context context) {
    this.context = context;
  }

  public void setData(List<Tweet> tweets) {
    this.tweets.clear();
    this.tweets.addAll(tweets);
    notifyDataSetChanged();
  }

  @NonNull
  @NotNull
  @Override
  public TweetViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    return new TweetViewHolder(inflater.inflate(R.layout.item_tweet, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull @NotNull TweetAdapter.TweetViewHolder holder, int position) {
    Tweet tweet = tweets.get(position);

    holder.tvName.setText("");
    holder.tvContent.setText("");

    if (tweet.getSender() == null) {
      return;
    }

    holder.tvName.setText(tweet.getSender().getNick());
    holder.tvContent.setText(tweet.getContent());
  }

  @Override
  public int getItemCount() {
    return this.tweets.size();
  }

  public static class TweetViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imAvatar;
    private final TextView tvName;
    private final TextView tvContent;

    public TweetViewHolder(@NonNull @NotNull View itemView) {
      super(itemView);
      imAvatar = itemView.findViewById(R.id.avatar);
      tvName = itemView.findViewById(R.id.name);
      tvContent = itemView.findViewById(R.id.content);
    }
  }
}

