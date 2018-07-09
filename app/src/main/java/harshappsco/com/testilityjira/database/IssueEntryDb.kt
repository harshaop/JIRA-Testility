package harshappsco.com.testilityjira.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class IssueEntryDb(context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    private val SQL_CREATE_ENTRIES = "CREATE TABLE ${IssueEntry.TABLE_NAME} (" +
            "${IssueEntry.TABLE_ID} INTERGER PRIMARY KEY," +
            "${IssueEntry.ISSUE_ID_COL} TEXT UNIQUE," +
            "${IssueEntry.ISSUE_SUMMARY_COL} TEXT," +
            "${IssueEntry.ISSUE_TAB_LANE_COL} TEXT," +
            "${IssueEntry.ISSUE_TYP_IMG_URL_COL} TEXT," +
            "${IssueEntry.ISSUE_PIRO_IMG_URL_COL} TEXT," +
            "${IssueEntry.ISSUE_ASSIGNEE_IMG_URL_COL} TEXT," +
            "${IssueEntry.ISSUE_TYP_IMG_COL} BLOB," +
            "${IssueEntry.ISSUE_PRIO_IMG_COL} BLOB" +
            ")"

    private val SQL_DELETE_ENTRY = "DROP TABLE IF EXISTS ${IssueEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRY)
        onCreate(db)
    }


}