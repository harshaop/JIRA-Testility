package harshappsco.com.testilityjira

data class IssueFeed(val issues: List<Issue>)
data class Issue(val key: String, val fields: Fields)
data class Fields(val summary: String, val issuetype: IssueType)
data class IssueType(val iconUrl:String)