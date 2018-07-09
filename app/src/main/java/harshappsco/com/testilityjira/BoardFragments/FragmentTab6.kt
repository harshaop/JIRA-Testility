package harshappsco.com.testilityjira.BoardFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import harshappsco.com.testilityjira.JiraCardAdapter2
import harshappsco.com.testilityjira.R
import harshappsco.com.testilityjira.database.IssueDbTable
import harshappsco.com.testilityjira.database.IssueEntry
import kotlinx.android.synthetic.main.fragment_tab1.*


class FragmentTab6 : Fragment() {
    var tab1Name: String? = "To Do"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_JiraCardFragment?.layoutManager = LinearLayoutManager(this.activity)
      //  val tabName = context?.getSharedPreferences("harshappsco.com.testilityjira.TABNAMES", Context.MODE_PRIVATE)?.getString("TAB6", "null")

        val tableCol =
                        IssueEntry.ISSUE_TAB_LANE_COL + " = ?" + "OR " +
                        IssueEntry.ISSUE_TAB_LANE_COL + " = ?" + "OR " +
                        IssueEntry.ISSUE_TAB_LANE_COL + " = ? "
        val whereSel = arrayOf("10366","10022","10004")



        val isuue = IssueDbTable(activity?.applicationContext!!).readData(selection = tableCol, selectionArgs = whereSel)
        rv_JiraCardFragment.adapter = JiraCardAdapter2(isuue)
    }

}
