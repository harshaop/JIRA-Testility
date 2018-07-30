package harshappsco.com.testilityjira.database

import android.provider.BaseColumns

const val DATABASE_NAME = "JIRAIssues.db"
const val DATABASE_VERSION = 10

object IssueEntry : BaseColumns {
    const val TABLE_NAME = "issue"
    const val TABLE_ID = "_ID"
    const val ISSUE_ID_COL = "issueID"
    const val ISSUE_TAB_LANE_COL = "tabLane"
    const val ISSUE_SUMMARY_COL = "summary"
    const val ISSUE_DESCRIPTION_COL = "description"
    const val ISSUE_TYP_IMG_URL_COL= "typeImg"
    const val ISSUE_PIRO_IMG_URL_COL= "prioImg"
    const val ISSUE_ASSIGNEE_IMG_URL_COL= "assigneeImg"
    const val ISSUE_TYP_IMG_COL = "typeImage"
    const val ISSUE_PRIO_IMG_COL = "prioImage"
}

const val DATABASE_NAME_BOARD = "BoardConfigs.db"
const val DATABASE_VERSION_BOARD = 10
object BoardEntry : BaseColumns {
    val TABLE_NAME = "issue"
    val TABLE_ID = "_ID"
    val ISSUE_ID_COL = "issueID"
    val ISSUE_STAT_COL = "StatusID"
}