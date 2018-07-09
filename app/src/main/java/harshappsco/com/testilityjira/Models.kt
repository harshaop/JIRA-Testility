package harshappsco.com.testilityjira

//Models for Isuues fetched from Json
data class IssuesFeed(val issues: List<Issue>)
data class Issue(val key: String, val fields: Fields)
data class Fields(val summary: String,
                  val issuetype: IssueType,
                  val priority: Priority,
                  val status: Status,
                  val assignee: Assignee )
data class Status(val id: String)
//data class StatCategory(val name: String)
data class Assignee(val avatarUrls: AvatarsUrls )
data class AvatarsUrls(val `32x32`: String )

data class Priority(val iconUrl: String)
data class IssueType(val iconUrl:String)

//Models for BoardConfig
data class BoardConfig(val columnConfig: ColumnConfig)
data class ColumnConfig(val columns: List<Columns>)
data class Columns(val name: String, val statuses: List<Statuses>)
data class Statuses(val id: String)

//Models for Db SQL Read
data class IssueDataList(val issueID: String, val summary: String , val tabCol : String, val typUrl: String , val prioUrl: String, val assigneeUrl :String?)