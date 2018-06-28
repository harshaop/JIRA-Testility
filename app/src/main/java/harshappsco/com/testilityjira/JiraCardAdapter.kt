package harshappsco.com.testilityjira

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import harshappsco.com.testilityjira.R.id.imageView
import kotlinx.android.synthetic.main.jira_card.view.*

class JiraCardAdapter(val issueFeed :IssueFeed): RecyclerView.Adapter<JiraCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JiraCardViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jira_card, parent,false)
        return JiraCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return issueFeed.issues.size
    }

    override fun onBindViewHolder(holder: JiraCardViewHolder, position: Int) {
        val issue = issueFeed.issues.get(position)
        holder.card.textView3.text = issue.key
        holder.card.textView4.text = issue.fields.summary

        val imageViewType = holder.card.imageView
        val imageViewPriority = holder.card.imageView2
        Picasso.get()
                .load("https://harshaop.atlassian.net/secure/viewavatar?size=xsmall&avatarId=10315&avatarType=issuetype")
                .error(R.drawable.abc_ic_star_black_16dp)
                .into(imageViewType)
        Picasso.get()
                .load("https://harshaop.atlassian.net/images/icons/priorities/medium.svg")
                .error(R.drawable.abc_ic_star_black_16dp)
                .into(imageViewPriority)
    }

}
class JiraCardViewHolder(val card: View): RecyclerView.ViewHolder(card)
