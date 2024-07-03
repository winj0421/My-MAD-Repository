package com.example.chatchat;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
    private DatabaseHelper databaseHelper;

    public UserDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public boolean addUser(String username, String password) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password); // 实际开发中密码应该加密存储

        long result = db.insert(DatabaseHelper.TABLE_USERS, null, values);
        db.close(); // 确保在插入后关闭数据库
        return result != -1;
    }
}