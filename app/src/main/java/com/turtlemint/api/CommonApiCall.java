package com.turtlemint.api;

import androidx.annotation.NonNull;

import com.turtlemint.model.IssuesModel;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CommonApiCall {
    private static CommonApiCall commonClassForAPI;


    public static CommonApiCall getInstance() {
        if (commonClassForAPI == null) {
            commonClassForAPI = new CommonApiCall();
        }
        return commonClassForAPI;
    }

    private CommonApiCall() {
    }


    public void getIssueList(DisposableObserver<ArrayList<IssuesModel>> observer) {
        RestClient.getInstance().getService().getIssueList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<IssuesModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<IssuesModel> o) {
                        observer.onNext(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        observer.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                    }
                });
    }

    public void getComments(DisposableObserver<ArrayList<IssuesModel>> observer, String url) {
        RestClient.getInstance().getService().getComments(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<IssuesModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull ArrayList<IssuesModel> o) {
                        observer.onNext(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        observer.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                    }
                });
    }
}
