package harshappsco.com.testilityjira.database

import android.provider.BaseColumns

val DATABASE_NAME = "JIRAIssues.db"
val DATABASE_VERSION = 10

object IssueEntry : BaseColumns {
    val TABLE_NAME = "issue"
    val TABLE_ID = "_ID"
    val ISSUE_ID_COL = "issueID"
    val ISSUE_TAB_LANE_COL = "tabLane"
    val ISSUE_SUMMARY_COL = "summary"
    val ISSUE_TYP_IMG_URL_COL= "typeImg"
    val ISSUE_PIRO_IMG_URL_COL= "prioImg"
    val ISSUE_ASSIGNEE_IMG_URL_COL= "assigneeImg"
    val ISSUE_TYP_IMG_COL = "typeImage"
    val ISSUE_PRIO_IMG_COL = "prioImage"
}