package harshappsco.com.testilityjira.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import harshappsco.com.testilityjira.*
import java.io.ByteArrayOutputStream

class IssueDbTable(context: Context) {
    private val TAG = IssueDbTable::class.java.simpleName

    private val dbHelper = IssueEntryDb(context)
    fun storeData(issue: Issue, fields: Fields, statusTab: Status, issueType: IssueType, prio: Priority, assigneeUrl: AvatarsUrls?): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put(IssueEntry.ISSUE_ID_COL, issue.key)
        values.put(IssueEntry.ISSUE_SUMMARY_COL, fields.summary)
        values.put(IssueEntry.ISSUE_DESCRIPTION_COL, fields.description)
        values.put(IssueEntry.ISSUE_TAB_LANE_COL, statusTab.id)
        values.put(IssueEntry.ISSUE_TYP_IMG_URL_COL, issueType.iconUrl )
        values.put(IssueEntry.ISSUE_PIRO_IMG_URL_COL, prio.iconUrl )
        values.put(IssueEntry.ISSUE_ASSIGNEE_IMG_URL_COL, assigneeUrl?.`32x32` )
    //  values.put(IssueEntry.ISSUE_TYP_IMG_COL,)
        val id = db.transaction {
            insert(IssueEntry.TABLE_NAME, null, values)
        }
        Log.d(TAG, "Stored new database table ${IssueEntry.TABLE_NAME}")
        return id
    }

    fun readData(selection: String? = null, selectionArgs: Array<String>? = null): List<IssueDataList> {
        val issues = mutableListOf<IssueDataList>()
        val columns = arrayOf(IssueEntry.TABLE_ID,
                IssueEntry.ISSUE_ID_COL,
                IssueEntry.ISSUE_SUMMARY_COL,
                IssueEntry.ISSUE_DESCRIPTION_COL,
                IssueEntry.ISSUE_TAB_LANE_COL,
                IssueEntry.ISSUE_TYP_IMG_URL_COL,
                IssueEntry.ISSUE_PIRO_IMG_URL_COL,
                IssueEntry.ISSUE_ASSIGNEE_IMG_URL_COL
                )
        val order = "${IssueEntry.TABLE_ID} ASC"
      //  val selection = "${IssueEntry.ISSUE_TAB_LANE_COL}"
      //  val selectionArgs = arrayOf("")

        val db = dbHelper.readableDatabase

        val cursor = db.doQuery(IssueEntry.TABLE_NAME, columns,
                selection= selection,
                selectionArgs = selectionArgs,
                orderBy = order)

        if (cursor != null) {
            while (cursor.moveToNext()) {

                val issueID = cursor.getString(IssueEntry.ISSUE_ID_COL)
                val issueSummary = cursor.getString(IssueEntry.ISSUE_SUMMARY_COL)
                val issueDescription = cursor.getString(IssueEntry.ISSUE_DESCRIPTION_COL)
                val issueTabCol = cursor.getString(IssueEntry.ISSUE_TAB_LANE_COL)
                val issueTypeUrl = cursor.getString(IssueEntry.ISSUE_TYP_IMG_URL_COL)
                val prioUrl = cursor.getString(IssueEntry.ISSUE_PIRO_IMG_URL_COL)
                val assigneeUrl = cursor?.getString(IssueEntry.ISSUE_ASSIGNEE_IMG_URL_COL)

                /*val typeBitmap = cursor.getBitmap(IssueEntry.ISSUE_TYP_IMG_COL)
            val prioBitmap = cursor.getBitmap(IssueEntry.ISSUE_PRIO_IMG_COL)*/

                issues.add(IssueDataList(issueID, issueSummary, issueDescription,issueTabCol, issueTypeUrl, prioUrl, assigneeUrl))
            }
        }
        cursor?.close()
        return issues
    }
fun readAData (selection: String? = null, selectionArgs: Array<String>? = null , columns :Array<String> = arrayOf(IssueEntry.ISSUE_DESCRIPTION_COL)): String{
    var dataString = "Issue Description is not read from the database"
    val db = dbHelper.readableDatabase

    val cursor = db.doQuery(
            table = IssueEntry.TABLE_NAME,
            columns = columns,
            selection= selection,
            selectionArgs = selectionArgs
            )
    if (cursor != null) {
        while (cursor.moveToNext()){
            dataString = cursor.getString(IssueEntry.ISSUE_DESCRIPTION_COL)
        }
    }
    cursor?.close()
    return dataString
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

private fun SQLiteDatabase.doQuery(table: String,
                                   columns: Array<String>,
                                   selection: String? = null,
                                   selectionArgs: Array<String>? =null,
                                   groupby: String? = null,
                                   having : String? =null,
                                   orderBy: String?= null
                                   ): Cursor? {
return query(table , columns, selection, selectionArgs, groupby, having, orderBy)
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