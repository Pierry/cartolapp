package com.github.pierry.cartolapp.repositories;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.github.pierry.cartolapp.domain.Club;
import com.github.pierry.cartolapp.domain.contracts.IClubRepository;
import java.util.Collections;
import java.util.List;
import org.androidannotations.annotations.EBean;

@EBean public class ClubRepository implements IClubRepository {

  @Override public List<Club> get() {
    try {
      return new Select().from(Club.class).execute();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }

  @Override public Club getById(long id) {
    try {
      return new Select().from(Club.class).where("ClubId = ?", id).executeSingle();
    } catch (Exception e) {
      return null;
    }
  }

  @Override public long create(Club item) {
    try {
      return item.save();
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override public boolean update(Club item) {
    try {
      return item.save() > 0;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override public boolean delete(long id) {
    try {
      new Delete().from(Club.class).where("ClubId = ?", id).executeSingle();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
