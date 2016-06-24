package com.github.pierry.cartolapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.domain.Club;
import com.github.pierry.cartolapp.domain.Player;
import com.github.pierry.cartolapp.domain.contracts.IClubRepository;
import com.koushikdutta.ion.Ion;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerHolder> {

  private List<Player> players;
  private Context context;
  private IClubRepository clubRepository;

  public class PlayerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView photo;
    public TextView nickname;
    public TextView club;
    public TextView price;
    public TextView points;

    public PlayerHolder(View view) {
      super(view);
      photo = (ImageView) view.findViewById(R.id.photo);
      nickname = (TextView) view.findViewById(R.id.nickname);
      club = (TextView) view.findViewById(R.id.club);
      price = (TextView) view.findViewById(R.id.price);
      points = (TextView) view.findViewById(R.id.points);
    }

    @Override public void onClick(View v) {
      switch (v.getId()) {
        default:
          break;
      }
    }
  }

  public PlayerAdapter(Context context, List<Player> players, IClubRepository clubRepository) {
    this.context = context;
    this.players = players;
    this.clubRepository = clubRepository;
  }

  @Override public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_team, parent, false);
    return new PlayerHolder(itemView);
  }

  @Override public void onBindViewHolder(PlayerHolder holder, int position) {
    Player player = players.get(position);
    holder.nickname.setText(player.getName());
    Club club = clubRepository.getById(player.getClubId());
    holder.points.setText(String.valueOf(player.getPoints()));
    Ion.with(context)
        .load(player.getPhoto())
        .withBitmap()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        //.animateLoad(spinAnimation)
        //.animateIn(fadeInAnimation)
        .intoImageView(holder.photo);
    if (club == null) {
      return;
    }
    holder.club.setText(club.getName());
  }

  @Override public int getItemCount() {
    return players.size();
  }
}
