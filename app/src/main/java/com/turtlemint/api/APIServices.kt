package com.turtlemint.api

import com.turtlemint.model.IssuesModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServices {

    @GET("/repos/square/okhttp/issues")
    fun getIssueList(): Observable<ArrayList<IssuesModel>>

    @GET
    fun getComments(@Url url: String): Observable<ArrayList<IssuesModel>>
}