package com.github.pierry.cartolapp.repositories;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.github.pierry.cartolapp.domain.Player;
import com.github.pierry.cartolapp.domain.contracts.IPlayerRepository;
import java.util.Collections;
import java.util.List;
import org.androidannotations.annotations.EBean;

@EBean public class PlayerRepository implements IPlayerRepository {

  @Override public List<Player> get() {
    try {
      return new Select().from(Player.class).execute();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  @Override public Player getById(long id) {
    try {
      return new Select().from(Player.class).where("PlayerId = ?", id).executeSingle();
    } catch (Exception e) {
      return null;
    }
  }

  @Override public long create(Player item) {
    try {
      return item.save();
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override public boolean update(Player item) {
    try {
      return item.save() > 0;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override public boolean delete(long id) {
    try {
      new Delete().from(Player.class).where("PlayerId = ?", id).executeSingle();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
