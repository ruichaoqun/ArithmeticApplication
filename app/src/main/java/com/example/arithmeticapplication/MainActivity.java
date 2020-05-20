package com.example.arithmeticapplication;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Random mRandom = new Random();
    ChannelView channelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        channelView = findViewById(R.id.view);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    Disposable mDisposable;
    public void test(){
        createSerialPort().compose(new ObservableTransformer<Boolean, Long>() {
            @Override
            public ObservableSource<Long> apply(Observable<Boolean> upstream) {
                return Observable.interval(1000, TimeUnit.MILLISECONDS);
            }
        }).flatMap(new Function<Long, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Long aLong) throws Exception {
                Log.w("AAAAA",aLong+"");
                if(aLong == 10){
                    return Observable.just("asda");
                }
                return Observable.empty();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(String s) {
                        Log.w("AAA",s);
                        mDisposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public Observable<Boolean> createSerialPort(){
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(true);
                emitter.onComplete();
            }
        });
    }

    public void Click(View view) {
        Observable.interval(20,TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        channelView.addData(mRandom.nextFloat()*180);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
