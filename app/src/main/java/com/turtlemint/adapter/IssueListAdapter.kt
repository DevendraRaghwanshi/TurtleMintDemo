package com.turtlemint.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turtlemint.CommentsActivity
import com.turtlemint.R
import com.turtlemint.databinding.ItemIssueListBinding
import com.turtlemint.model.IssuesModel
import com.turtlemint.utils.Utils

class IssueListAdapter(
    private val activity: AppCompatActivity,
    private var list: List<IssuesModel>
) : RecyclerView.Adapter<IssueListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.item_issue_list, viewGroup, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val model = list[i]
        if (model.user != null && model.user.avatar_url != null) {
            Glide.with(activity).load(model.user.avatar_url).into(holder.mBinding.ivImage)
            holder.mBinding.tvName.text = model.user.login
        }

        holder.mBinding.tvTitle.text = model.title
        holder.mBinding.tvDescription.text = model.body
        holder.mBinding.tvDate.text = Utils.formatDate(model.updated_at)

        holder.mBinding.root.setOnClickListener {
            activity.startActivity(
                Intent(activity, CommentsActivity::class.java)
                    .putExtra("title", model.title)
                    .putExtra("url", model.comments_url)
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(var mBinding: ItemIssueListBinding) : RecyclerView.ViewHolder(
        mBinding.root
    )
}