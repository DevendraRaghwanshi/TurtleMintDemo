package com.turtlemint

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.turtlemint.adapter.IssueListAdapter
import com.turtlemint.api.CommonApiCall
import com.turtlemint.databinding.ActivityMainBinding
import com.turtlemint.model.IssuesModel
import com.turtlemint.utils.MyApplication
import com.turtlemint.utils.Utils
import io.reactivex.observers.DisposableObserver

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var list: ArrayList<IssuesModel>? = null
    var adapter: IssueListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        init()
    }

    private fun init() {
        list = ArrayList()
        adapter = IssueListAdapter(this, list!!)
        binding.rvIssues.adapter = adapter

        if (Utils.isNetworkAvailable(applicationContext)) {
            CommonApiCall.instance.getIssueList(listObserver)
        } else {
            MyApplication.getInstance().repository.items.observe(this) { issueList: List<IssuesModel> ->
                list?.addAll(issueList)
                adapter?.notifyDataSetChanged()
                if (issueList.isNotEmpty()) {
                    binding.progressMain.visibility = View.GONE
                }
            }
        }
    }


    private var listObserver: DisposableObserver<ArrayList<IssuesModel>> =
        object : DisposableObserver<ArrayList<IssuesModel>>() {
            override fun onNext(arrayList: ArrayList<IssuesModel>) {
                binding.progressMain.visibility = View.GONE
                list?.addAll(arrayList)
                adapter?.notifyDataSetChanged()

                MyApplication.getInstance().repository.addItem(list)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {

            }
        }
}