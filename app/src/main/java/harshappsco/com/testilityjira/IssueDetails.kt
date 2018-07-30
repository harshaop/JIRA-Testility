package harshappsco.com.testilityjira

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import harshappsco.com.testilityjira.database.IssueDbTable
import harshappsco.com.testilityjira.database.IssueEntry
import kotlinx.android.synthetic.main.activity_issue_details_edited.*

class IssueDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_details_edited)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        //We'll change the title to the IssueKey
        val navBarTitle = intent.getStringExtra(JiraCardViewHolder.ISSUE_TITLE_KEY)
        toolbar.title = navBarTitle

        val tableCol = IssueEntry.ISSUE_ID_COL + " = ?"
        val whereSel = arrayOf(navBarTitle)
        val isssueDescription = IssueDbTable(this.applicationContext!!).readAData(selection = tableCol, selectionArgs = whereSel)
        textView_IssueDescription.text = isssueDescription
    }
}
