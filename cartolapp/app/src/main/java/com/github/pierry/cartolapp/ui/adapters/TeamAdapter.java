package com.github.pierry.cartolapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.domain.Team;
import com.koushikdutta.ion.Ion;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {

  private List<Team> teams;
  private Context context;

  public class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView photo;
    public TextView name;
    public TextView owner;
    public TextView points;

    public TeamHolder(View view) {
      super(view);
      photo = (ImageView) view.findViewById(R.id.photo);
      name = (TextView) view.findViewById(R.id.name);
      owner = (TextView) view.findViewById(R.id.owner);
      points = (TextView) view.findViewById(R.id.points);
    }

    @Override public void onClick(View v) {
      switch (v.getId()) {
        default:
          break;
      }
    }
  }

  public TeamAdapter(Context context, List<Team> teams) {
    this.context = context;
    this.teams = teams;
  }

  @Override public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_team, parent, false);
    return new TeamHolder(itemView);
  }

  @Override public void onBindViewHolder(TeamHolder holder, int position) {
    Team team = teams.get(position);
    holder.name.setText(team.getName());
    holder.owner.setText(team.getOwner());
    holder.points.setText("200");
    Ion.with(context)
        .load(team.getImage())
        .withBitmap()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        //.animateLoad(spinAnimation)
        //.animateIn(fadeInAnimation)
        .intoImageView(holder.photo);
  }

  @Override public int getItemCount() {
    return teams.size();
  }
}
