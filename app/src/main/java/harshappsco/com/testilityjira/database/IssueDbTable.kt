package harshappsco.com.testilityjira.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import harshappsco.com.testilityjira.Fields
import harshappsco.com.testilityjira.Issue
import harshappsco.com.testilityjira.IssueDataList
import java.io.ByteArrayOutputStream

class IssueDbTable(context: Context) {
    private val TAG = IssueDbTable::class.java.simpleName

    private val dbHelper = IssueEntryDb(context)
    fun storeData(issue: Issue, fields: Fields): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put(IssueEntry.ISSUE_ID_COL, issue.key)
        values.put(IssueEntry.ISSUE_SUMMARY_COL, fields.summary)
    //    values.put(IssueEntry.ISSUE_TYP_IMG_COL,)
        val id = db.transaction {
            insert(IssueEntry.TABLE_NAME, null, values)
        }
        Log.d(TAG, "Stored new database table ${IssueEntry.TABLE_NAME}")
        return id
    }

    fun readData(): List<IssueDataList> {
        val issues = mutableListOf<IssueDataList>()
        val colums = arrayOf(IssueEntry.TABLE_ID, IssueEntry.ISSUE_ID_COL, IssueEntry.ISSUE_SUMMARY_COL, IssueEntry.ISSUE_TYP_IMG_COL, IssueEntry.ISSUE_PRIO_IMG_COL)
        val order = "${IssueEntry.TABLE_ID} ASC"
        val db = dbHelper.readableDatabase
        val cursor = db.query(IssueEntry.TABLE_NAME, colums, null, null, null, null, order)

        while (cursor.moveToNext()) {

            val issueID = cursor.getString(IssueEntry.ISSUE_ID_COL)
            val issueSummary = cursor.getString(IssueEntry.ISSUE_SUMMARY_COL)

            val typeBitmap = cursor.getBitmap(IssueEntry.ISSUE_TYP_IMG_COL)
            val prioBitmap = cursor.getBitmap(IssueEntry.ISSUE_PRIO_IMG_COL)

            issues.add(IssueDataList(issueID, issueSummary, typeBitmap, prioBitmap))
        }
        cursor.close()
        return issues
    }

    fun toByteArry(bimap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bimap.compress(Bitmap.CompressFormat.PNG, 0, stream)
        return stream.toByteArray()
    }
}

private fun Cursor.getString(columnName: String) = getString(getColumnIndex(columnName))

private fun Cursor.getBitmap(columnName: String): Bitmap {
    val typeImageByteArray = getBlob(getColumnIndex(columnName))
    return BitmapFactory.decodeByteArray(typeImageByteArray, 0, typeImageByteArray.size)
}


private inline fun <T> SQLiteDatabase.transaction(function: SQLiteDatabase.() -> T): T {
    beginTransaction()
    val result = try {
        val returnValue = function()
        setTransactionSuccessful()
        returnValue
    } finally {
        endTransaction()
    }
    close()
    return result
}