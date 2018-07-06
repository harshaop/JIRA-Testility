package harshappsco.com.testilityjira

import android.graphics.Bitmap
import java.net.URL

//Models for Isuues
data class IssuesFeed(val issues: List<Issue>)
data class Issue(val key: String, val fields: Fields)
data class Fields(val summary: String,
                  val issuetype: IssueType,
                  val priority: Priority,
                  val status: Status,
                  val assignee: Assignee )
data class Status(val statusCategory: StatCategory)
data class StatCategory(val name: String)
data class Assignee(val avatarUrls: AvatarsUrls )
data class AvatarsUrls(val `32x32`: String )

data class Priority(val iconUrl: URL)
data class IssueType(val iconUrl:URL)

//Models for BoardConfig
data class BoardConfig(val columnConfig: ColumnConfig)
data class ColumnConfig(val columns: List<Columns>)
data class Columns(val name: String)

//Models for Db
data class IssueDataList(val issueID: String, val summary: String, val prioImg :Bitmap, val typeImg :Bitmap)