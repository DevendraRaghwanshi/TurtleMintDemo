package com.turtlemint.api

import com.turtlemint.model.IssuesModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CommonApiCall private constructor() {
    fun getIssueList(observer: DisposableObserver<ArrayList<IssuesModel>>) {
        RestClient.getInstance().service.getIssueList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ArrayList<IssuesModel>> {
                override fun onSubscribe(d: Disposable) {}
                override fun onNext(o: ArrayList<IssuesModel>) {
                    observer.onNext(o)
                }

                override fun onError(e: Throwable) {
                    observer.onError(e)
                }

                override fun onComplete() {
                    observer.onComplete()
                }
            })
    }

    fun getComments(observer: DisposableObserver<ArrayList<IssuesModel>>, url: String?) {
        RestClient.getInstance().service.getComments(url!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ArrayList<IssuesModel>> {
                override fun onSubscribe(d: Disposable) {}
                override fun onNext(o: ArrayList<IssuesModel>) {
                    observer.onNext(o)
                }

                override fun onError(e: Throwable) {
                    observer.onError(e)
                }

                override fun onComplete() {
                    observer.onComplete()
                }
            })
    }

    companion object {
        private var commonClassForAPI: CommonApiCall? = null
        val instance: CommonApiCall?
            get() {
                if (commonClassForAPI == null) {
                    commonClassForAPI = CommonApiCall()
                }
                return commonClassForAPI
            }
    }
}