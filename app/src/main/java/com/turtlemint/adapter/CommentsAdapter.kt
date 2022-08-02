package com.turtlemint.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turtlemint.R
import com.turtlemint.databinding.ItemIssueListBinding
import com.turtlemint.model.IssuesModel
import com.turtlemint.utils.Utils

class CommentsAdapter(
    private val activity: AppCompatActivity,
    private var list: List<IssuesModel>
) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {


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
        Glide.with(activity).load(model.user.avatar_url).into(holder.mBinding.ivImage)
        holder.mBinding.tvName.text = model.user.login

        holder.mBinding.tvTitle.text = model.title
        holder.mBinding.tvDescription.text = model.body
        holder.mBinding.tvDate.text = Utils.formatDate(model.updated_at)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(var mBinding: ItemIssueListBinding) : RecyclerView.ViewHolder(
        mBinding.root
    )
}