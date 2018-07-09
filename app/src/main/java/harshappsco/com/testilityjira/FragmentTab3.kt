package harshappsco.com.testilityjira


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import harshappsco.com.testilityjira.database.IssueDbTable
import harshappsco.com.testilityjira.database.IssueEntry
import kotlinx.android.synthetic.main.fragment_tab1.*


class FragmentTab3 : Fragment() {
    var tab1Name:String? ="Code Review"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (getArguments() != null){
            tab1Name = arguments?.getString("TAB1")
        }
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_JiraCardFragment?.layoutManager = LinearLayoutManager(this.activity)

        val tableCol = IssueEntry.ISSUE_TAB_LANE_COL + " = ?"
        val whereSel = arrayOf("$tab1Name")

        val isuue = IssueDbTable(activity?.applicationContext!!).readData(selection = tableCol, selectionArgs = whereSel)
        rv_JiraCardFragment.adapter = JiraCardAdapter2(isuue)
    }

}
