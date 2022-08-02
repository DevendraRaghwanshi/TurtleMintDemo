package com.turtlemint

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.turtlemint.adapter.CommentsAdapter
import com.turtlemint.api.CommonApiCall
import com.turtlemint.databinding.ActivityCommentsBinding
import com.turtlemint.model.IssuesModel
import io.reactivex.observers.DisposableObserver

class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding

    var list: ArrayList<IssuesModel>? = null
    var adapter: CommentsAdapter? = null

    var url = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comments)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.extras != null) {
            title = intent.getStringExtra("title")!!
            url = intent.getStringExtra("url")!!
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        list = ArrayList()
        adapter = CommentsAdapter(this, list!!)
        binding.rvComments.adapter = adapter

        CommonApiCall.instance?.getComments(listObserver, url)
    }

    private var listObserver: DisposableObserver<ArrayList<IssuesModel>> =
        object : DisposableObserver<ArrayList<IssuesModel>>() {
            override fun onNext(arrayList: ArrayList<IssuesModel>) {
                binding.progressComment.visibility = View.GONE
                list?.addAll(arrayList)
                adapter?.notifyDataSetChanged()
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {

            }
        }
}