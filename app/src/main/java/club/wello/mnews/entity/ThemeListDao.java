package club.wello.mnews.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "THEME_LIST".
*/
public class ThemeListDao extends AbstractDao<ThemeList, Void> {

    public static final String TABLENAME = "THEME_LIST";

    /**
     * Properties of entity ThemeList.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property JsonString = new Property(0, String.class, "jsonString", false, "JSON_STRING");
        public final static Property CreatedTime = new Property(1, Long.class, "createdTime", false, "CREATED_TIME");
    }


    public ThemeListDao(DaoConfig config) {
        super(config);
    }
    
    public ThemeListDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"THEME_LIST\" (" + //
                "\"JSON_STRING\" TEXT," + // 0: jsonString
                "\"CREATED_TIME\" INTEGER);"); // 1: createdTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"THEME_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ThemeList entity) {
        stmt.clearBindings();
 
        String jsonString = entity.getJsonString();
        if (jsonString != null) {
            stmt.bindString(1, jsonString);
        }
 
        Long createdTime = entity.getCreatedTime();
        if (createdTime != null) {
            stmt.bindLong(2, createdTime);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ThemeList entity) {
        stmt.clearBindings();
 
        String jsonString = entity.getJsonString();
        if (jsonString != null) {
            stmt.bindString(1, jsonString);
        }
 
        Long createdTime = entity.getCreatedTime();
        if (createdTime != null) {
            stmt.bindLong(2, createdTime);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public ThemeList readEntity(Cursor cursor, int offset) {
        ThemeList entity = new ThemeList( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // jsonString
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) // createdTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ThemeList entity, int offset) {
        entity.setJsonString(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCreatedTime(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(ThemeList entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(ThemeList entity) {
        return null;
    }

    @Override
    public boolean hasKey(ThemeList entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
