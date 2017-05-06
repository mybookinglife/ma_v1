package com.mybooking.mybookingmobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kharc on 29.04.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABESE_NAME = "mybookingDb";

    public static final String TABLE_BOOKINGS = "bookings";
    public static final String TABLE_USERS = "users";
    public static final String TABLE_COMPANIES = "companies";
    public static final String TABLE_EXPERTS = "experts";
    public static final String TABLE_SERVICES = "services";

    // BOOKINGS

   public static final String KEY_BOOKINGS_ID = "_id";
   public static final String KEY_BOOKINGS_DATETIME = "date_time";
   public static final String KEY_BOOKINGS_DATE = "date";
   public static final String KEY_BOOKINGS_TIME = "time";
   public static final String KEY_BOOKINGS_NOTE = "note";
   public static final String KEY_BOOKINGS_COMMENT = "comment";
   public static final String KEY_BOOKINGS_IS_NEW = "is_new";
   public static final String KEY_BOOKINGS_IS_CANSEL = "is_cansel";
   public static final String KEY_BOOKINGS_IS_FINISHED = "is_finished";
   public static final String KEY_BOOKINGS_CLIENT_ID = "client_id";
   public static final String KEY_BOOKINGS_COMPANY_ID = "company_id";
   public static final String KEY_BOOKINGS_EXPERT_ID = "expert_id";
   public static final String KEY_BOOKINGS_SERVICE_ID = "service_id";

    // USERS

   public static final String KEY_USERS_ID = "_id";
   public static final String KEY_USERS_PASSWORD = "password";
   public static final String KEY_USERS_USERNAME = "username";
   public static final String KEY_USERS_FIRSTNAME = "first_name";
   public static final String KEY_USERS_LASTNAME = "last_name";
   public static final String KEY_USERS_MIDDLENAME = "middle_name";
   public static final String KEY_USERS_DATEOFBIRTH = "date_of_birth";

    // COMPANIES

    public static final String KEY_COMPANIES_ID = "_id";
    public static final String KEY_COMPANIES_NAME = "name";
    public static final String KEY_COMPANIES_LEGAL_NAME = "legal_name";
    public static final String KEY_COMPANIES_ITN = "itn";
    public static final String KEY_COMPANIES_PHONE = "phone";
    public static final String KEY_COMPANIES_LEGAL_ADDRESS = "legal_address";
    public static final String KEY_COMPANIES_ACTUAL_ADDRESS = "actual_address";
    public static final String KEY_COMPANIES_DESCRIPTION = "description";
    public static final String KEY_COMPANIES_FULL_DESCRIPTION = "full_description";
    public static final String KEY_COMPANIES_SCHEDULE = "schedule";
    public static final String KEY_COMPANIES_TIME_ZONE = "time_zone";

    // EXPERTS

    public static final String KEY_EXPERTS_ID = "_id";
    public static final String KEY_EXPERTS_NAME = "name";
    public static final String KEY_EXPERTS_PHONE = "phone";
    public static final String KEY_EXPERTS_DESCRIPTION = "description";
    public static final String KEY_EXPERTS_SHORT_DESCRIPTION = "short_description";

    // SERVICES

    public static final String KEY_SERVICES_ID = "_id";
    public static final String KEY_SERVICES_NAME = "name";
    public static final String KEY_SERVICES_PRISE = "prise";
    public static final String KEY_SERVICES_DURATION = "duration";

    public DBHelper(Context context) {
        super(context, DATABESE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BOOKINGS + "(" +
                        KEY_BOOKINGS_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                        KEY_BOOKINGS_DATETIME + " datetime NOT NULL, " +
                        KEY_BOOKINGS_DATE + " date NOT NULL, " +
                        KEY_BOOKINGS_TIME + " time NOT NULL, " +
                        KEY_BOOKINGS_NOTE + " text NOT NULL, " +
                        KEY_BOOKINGS_COMMENT + " text NOT NULL, " +
                        KEY_BOOKINGS_IS_NEW + " bool NOT NULL, " +
                        KEY_BOOKINGS_IS_CANSEL + " bool NOT NULL, " +
                        KEY_BOOKINGS_IS_FINISHED + " bool NOT NULL, " +
                        KEY_BOOKINGS_CLIENT_ID + " integer NOT NULL REFERENCES " + TABLE_USERS + " (" + KEY_USERS_ID + "), " +
                        KEY_BOOKINGS_COMPANY_ID + " integer NOT NULL REFERENCES " + TABLE_COMPANIES + " (" + KEY_COMPANIES_ID + "), " +
                        KEY_BOOKINGS_EXPERT_ID + " integer NOT NULL REFERENCES " + TABLE_EXPERTS + " (" + KEY_EXPERTS_ID + "), " +
                        KEY_BOOKINGS_SERVICE_ID + " integer NOT NULL REFERENCES " + TABLE_SERVICES + " (" + KEY_SERVICES_ID + "))");

        db.execSQL("CREATE TABLE " + TABLE_USERS + " (" +
                        KEY_USERS_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        KEY_USERS_PASSWORD + " varchar(128) NOT NULL, " +
                        KEY_USERS_USERNAME + " varchar(75) NOT NULL UNIQUE, " +
                        KEY_USERS_FIRSTNAME + " varchar(40) NULL, " +
                        KEY_USERS_LASTNAME + " varchar(40) NULL, " +
                        KEY_USERS_MIDDLENAME + " varchar(40) NULL, " +
                        KEY_USERS_DATEOFBIRTH + " date NULL)");

        db.execSQL("CREATE TABLE " + TABLE_COMPANIES + " (" +
                        KEY_COMPANIES_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                        KEY_COMPANIES_NAME + " varchar(255) NULL, " +
                        KEY_COMPANIES_LEGAL_NAME + " varchar(255) NULL, " +
                        KEY_COMPANIES_ITN + " varchar(12) NOT NULL, " +
                        KEY_COMPANIES_PHONE + " varchar(13) NOT NULL, " +
                        KEY_COMPANIES_LEGAL_ADDRESS + " varchar(255) NULL, " +
                        KEY_COMPANIES_ACTUAL_ADDRESS + " varchar(255) NULL, " +
                        KEY_COMPANIES_DESCRIPTION + " varchar(255) NULL, " +
                        KEY_COMPANIES_FULL_DESCRIPTION + " text NULL, " +
                        KEY_COMPANIES_SCHEDULE + " bool NOT NULL, " +
                        KEY_COMPANIES_TIME_ZONE + " varchar(128) NULL) ");

        db.execSQL("CREATE TABLE " + TABLE_EXPERTS + " (" +
                        KEY_EXPERTS_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                        KEY_EXPERTS_NAME + " varchar(128) NULL, " +
                        KEY_EXPERTS_PHONE + " varchar(13) NOT NULL, " +
                        KEY_EXPERTS_SHORT_DESCRIPTION + " varchar(255) NOT NULL, " +
                        KEY_EXPERTS_DESCRIPTION + " text NOT NULL) " );

        db.execSQL("CREATE TABLE " + TABLE_SERVICES + " (" +
                        KEY_SERVICES_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                        KEY_SERVICES_NAME + " varchar(128) NOT NULL, " +
                        KEY_SERVICES_PRISE + " real NOT NULL, " +
                        KEY_SERVICES_DURATION + " integer NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
