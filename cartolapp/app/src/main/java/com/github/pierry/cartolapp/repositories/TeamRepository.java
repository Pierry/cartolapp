package com.github.pierry.cartolapp.repositories;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.github.pierry.cartolapp.domain.Team;
import com.github.pierry.cartolapp.domain.contracts.ITeamRepository;
import java.util.Collections;
import java.util.List;
import org.androidannotations.annotations.EBean;

@EBean public class TeamRepository implements ITeamRepository {

  @Override public List<Team> get() {
    try {
      return new Select().from(Team.class).execute();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  @Override public Team getById(long id) {
    try {
      return new Select().from(Team.class).where("TeamId = ?", id).executeSingle();
    } catch (Exception e) {
      return null;
    }
  }

  @Override public long create(Team item) {
    try {
      return item.save();
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override public boolean update(Team item) {
    try {
      return item.save() > 0;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override public boolean delete(long id) {
    try {
      new Delete().from(Team.class).where("TeamId = ?", id).executeSingle();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
