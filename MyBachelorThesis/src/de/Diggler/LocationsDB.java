package de.Diggler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocationsDB extends SQLiteOpenHelper{


	/** Database name */
	private static String DBNAME = "trip.DB";
	
	/** Version number of the database */
	private static int VERSION = 1;
		
	/** Field row id, is automatically incremented and first field of DB */
	public static final String FIELD_ROW_ID = "_id";
	
	/** Field latitude, longitude for saving the position of the marker */
    public static final String FIELD_LAT = "lat";
    public static final String FIELD_LNG = "lng";
    
    /** Field trip name for saving the name of the trip, so we know which markers belong to which trip*/
    public static final String FIELD_TRIP_NAME = "trip_name";
    
    /** Field marker type, for recognizing whether a marker is a marker, video, photo or audio */
    private static final String FIELD_MARKER_TYPE = "marker_type";
    
    /** Field marker options, for saving color, tilt ... of a marker */
    private static final String FIELD_MARKER_OPTIONS = "marker_options";
    
    /** Field date, for saving the take of setting the marker/capturing the media file*/
    private static final String FIELD_DATE = "date";
    
    /** A constant, stores the the table name */
    private static final String DATABASE_TABLE = "locations";
    
    /** An instance variable for SQLiteDatabase */
    private SQLiteDatabase mDB;  
    

    /** Constructor */
	public LocationsDB(Context context) {
		super(context, DBNAME, null, VERSION);	
		this.mDB = getWritableDatabase();
	}
	

	/** This is a callback method, invoked when the method getReadableDatabase() / getWritableDatabase() is called 
	  * provided the database does not exists 
	* */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = 	"create table " + DATABASE_TABLE + " ( " +
							FIELD_ROW_ID + " integer primary key autoincrement , " +
							FIELD_TRIP_NAME + " text " +
							FIELD_LAT + " double , " +
							FIELD_LNG + " double , " +
							FIELD_MARKER_TYPE + " text ," +
							FIELD_MARKER_OPTIONS + " text ," +
							FIELD_DATE + " date " +
						" ) ";
                				
		db.execSQL(sql);
	}
	
	/** Inserts a new location to the table locations */
	public long insert(ContentValues contentValues){
		long rowID = mDB.insert(DATABASE_TABLE, null, contentValues);
		return rowID;
		
	}	
	
	
	/** Deletes all locations from the table */
	public int del(){
		int cnt = mDB.delete(DATABASE_TABLE, null , null);		
		return cnt;
	}
	
	/** Returns all the locations from the table */
	public Cursor getAllLocations(){
        return mDB.query(DATABASE_TABLE, new String[] { FIELD_ROW_ID, FIELD_TRIP_NAME, FIELD_LAT , FIELD_LNG, FIELD_MARKER_TYPE, FIELD_MARKER_OPTIONS, FIELD_DATE } , null, null, null, null, null, null);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
