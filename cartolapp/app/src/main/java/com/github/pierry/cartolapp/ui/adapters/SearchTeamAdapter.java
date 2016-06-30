package com.github.pierry.cartolapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.domain.Team;
import com.github.pierry.cartolapp.domain.contracts.ITeamRepository;
import com.koushikdutta.ion.Ion;
import java.util.List;

public class SearchTeamAdapter extends RecyclerView.Adapter<SearchTeamAdapter.TeamHolder> {

  private List<Team> teams;
  private Context context;
  private ITeamRepository teamRepository;

  public class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView photo;
    public TextView name;
    public TextView owner;
    public Button add;

    public TeamHolder(View view) {
      super(view);
      photo = (ImageView) view.findViewById(R.id.photo);
      name = (TextView) view.findViewById(R.id.name);
      owner = (TextView) view.findViewById(R.id.owner);
      add = (Button) view.findViewById(R.id.add);
      add.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
      switch (v.getId()) {
        case R.id.add:
          Team team = teams.get(getAdapterPosition());
          Team saved = teamRepository.getById(team.getTeamId());
          if (saved == null) {
            teamRepository.create(team);
          } else {
            saved.setOwner(team.getOwner());
            saved.setName(team.getName());
            saved.setImage(team.getImage());
            teamRepository.update(saved);
          }
          Toast.makeText(context, context.getString(R.string.saved), Toast.LENGTH_SHORT).show();
          add.setBackgroundResource(android.R.color.transparent);
          add.setText("Ok");
          add.setTextColor(context.getResources().getColor(R.color.accent));
          break;
        default:
          break;
      }
    }
  }

  public SearchTeamAdapter(Context context, List<Team> teams, ITeamRepository teamRepository) {
    this.context = context;
    this.teams = teams;
    this.teamRepository = teamRepository;
  }

  @Override public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.adapter_team_search, parent, false);
    return new TeamHolder(itemView);
  }

  @Override public void onBindViewHolder(TeamHolder holder, int position) {
    Team team = teams.get(position);
    holder.name.setText(team.getName());
    holder.owner.setText(team.getOwner());
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
