package harshappsco.com.testilityjira

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.jira_card.view.*

class JiraCardAdapter2(val issuesFeed :List<IssueDataList>): RecyclerView.Adapter<JiraCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JiraCardViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jira_card, parent,false)
        return JiraCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return issuesFeed.size
    }

    override fun onBindViewHolder(holder: JiraCardViewHolder, position: Int) {
        val issue = issuesFeed.get(position)
        holder.card.textView3.text = issue.issueID
        holder.card.textView4.text = issue.summary

        val imageViewType = holder.card.imageView
        val imageViewPriority = holder.card.imageView2
        val imageViewAssignee = holder.card.imageView3
        val assigneeUrl = issue?.assigneeUrl ?: "https://jira.hm.com/secure/useravatar?avatarId=10373"


        Picasso.get()
                .load( issue.typUrl)
                        //"https://harshaop.atlassian.net/secure/viewavatar?size=xsmall&avatarId=10315&avatarType=issuetype")
                .error(R.drawable.abc_ic_star_black_16dp)
                .into(imageViewType)
        Picasso.get()
                .load( issue.prioUrl)
                        //"https://harshaop.atlassian.net/images/icons/priorities/medium.svg")
                .error(R.drawable.abc_ic_star_black_16dp)
                .into(imageViewPriority)
        Picasso.get()
                .load(assigneeUrl)
                //"https://harshaop.atlassian.net/images/icons/priorities/medium.svg")
                .error(R.drawable.ic_twotone_person_24px)
                .into(imageViewAssignee)
    }
}
//class JiraCardViewHolder(val card: View): RecyclerView.ViewHolder(card)

