package com.example.intern;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDao_Impl implements MyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Country> __insertionAdapterOfCountry;

  private final EntityDeletionOrUpdateAdapter<Country> __deletionAdapterOfCountry;

  private final EntityDeletionOrUpdateAdapter<Country> __updateAdapterOfCountry;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public MyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCountry = new EntityInsertionAdapter<Country>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `country` (`name`,`capital`,`flag`,`region`,`subregion`,`population`,`borders`,`languages`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Country value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getCapital() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCapital());
        }
        if (value.getFlag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFlag());
        }
        if (value.getRegion() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRegion());
        }
        if (value.getSubregion() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSubregion());
        }
        if (value.getPopulation() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPopulation());
        }
        if (value.getBorders() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBorders());
        }
        if (value.getLanguages() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLanguages());
        }
      }
    };
    this.__deletionAdapterOfCountry = new EntityDeletionOrUpdateAdapter<Country>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `country` WHERE `name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Country value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
      }
    };
    this.__updateAdapterOfCountry = new EntityDeletionOrUpdateAdapter<Country>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `country` SET `name` = ?,`capital` = ?,`flag` = ?,`region` = ?,`subregion` = ?,`population` = ?,`borders` = ?,`languages` = ? WHERE `name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Country value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getCapital() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCapital());
        }
        if (value.getFlag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFlag());
        }
        if (value.getRegion() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRegion());
        }
        if (value.getSubregion() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSubregion());
        }
        if (value.getPopulation() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPopulation());
        }
        if (value.getBorders() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBorders());
        }
        if (value.getLanguages() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLanguages());
        }
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM country";
        return _query;
      }
    };
  }

  @Override
  public void addUser(final Country country) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCountry.insert(country);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(final Country country) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCountry.handle(country);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(final Country country) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCountry.handle(country);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public List<Country> getUsers() {
    final String _sql = "select * from Country";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCapital = CursorUtil.getColumnIndexOrThrow(_cursor, "capital");
      final int _cursorIndexOfFlag = CursorUtil.getColumnIndexOrThrow(_cursor, "flag");
      final int _cursorIndexOfRegion = CursorUtil.getColumnIndexOrThrow(_cursor, "region");
      final int _cursorIndexOfSubregion = CursorUtil.getColumnIndexOrThrow(_cursor, "subregion");
      final int _cursorIndexOfPopulation = CursorUtil.getColumnIndexOrThrow(_cursor, "population");
      final int _cursorIndexOfBorders = CursorUtil.getColumnIndexOrThrow(_cursor, "borders");
      final int _cursorIndexOfLanguages = CursorUtil.getColumnIndexOrThrow(_cursor, "languages");
      final List<Country> _result = new ArrayList<Country>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Country _item;
        _item = new Country();
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpCapital;
        _tmpCapital = _cursor.getString(_cursorIndexOfCapital);
        _item.setCapital(_tmpCapital);
        final String _tmpFlag;
        _tmpFlag = _cursor.getString(_cursorIndexOfFlag);
        _item.setFlag(_tmpFlag);
        final String _tmpRegion;
        _tmpRegion = _cursor.getString(_cursorIndexOfRegion);
        _item.setRegion(_tmpRegion);
        final String _tmpSubregion;
        _tmpSubregion = _cursor.getString(_cursorIndexOfSubregion);
        _item.setSubregion(_tmpSubregion);
        final String _tmpPopulation;
        _tmpPopulation = _cursor.getString(_cursorIndexOfPopulation);
        _item.setPopulation(_tmpPopulation);
        final String _tmpBorders;
        _tmpBorders = _cursor.getString(_cursorIndexOfBorders);
        _item.setBorders(_tmpBorders);
        final String _tmpLanguages;
        _tmpLanguages = _cursor.getString(_cursorIndexOfLanguages);
        _item.setLanguages(_tmpLanguages);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
