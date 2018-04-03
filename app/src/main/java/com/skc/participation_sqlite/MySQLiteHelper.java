package com.skc.participation_sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "comments"; //table name
    public static final String COLUMN_ID = "_id"; //pk
    public static final String COLUMN_COMMENT = "comment"; //column name
    public static final String COLUMN_RATING = "rating"; //column name

    private static final String DATABASE_NAME = "commments.db"; //the file db is stored as
    private static final int DATABASE_VERSION = 2; //this is used to connect to the specific version

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null," + COLUMN_RATING + "text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE); //used to execute the statement
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS); //drop table is dangerous and will delete everything
        onCreate(db);
    }

}