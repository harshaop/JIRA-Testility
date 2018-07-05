package harshappsco.com.testilityjira.database

import android.provider.BaseColumns

val DATABASE_NAME = "JIRAIssues.db"
val DATABASE_VERSION = 10

object IssueEntry : BaseColumns {
    val TABLE_NAME = "issue"
    val TABLE_ID = "_ID"
    val ISSUE_ID_COL = "issueID"
    val ISSUE_SUMMARY_COL = "summary"
    val ISSUE_TYP_IMG_COL = "typeImage"
    val ISSUE_PRIO_IMG_COL = "prioImage"
}