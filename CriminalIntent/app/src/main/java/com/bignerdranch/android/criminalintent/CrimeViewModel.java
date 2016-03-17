package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.bignerdranch.android.criminalintent.BR;

import java.util.List;

public class CrimeViewModel extends BaseObservable {
    private Crime mCrime;
    private Activity mActivity;

    public CrimeViewModel(Activity activity) {
        mActivity = activity;
    }

    @Bindable
    public String getTitle() {
        return mCrime.getTitle();
    }

    @Bindable
    public String getRenderedDate() {
        return mCrime.getDate().toString();
    }

    @Bindable
    public boolean isSolved() {
        return mCrime.isSolved();
    }

    public Crime getCrime() {
        return mCrime;
    }

    public void setCrime(Crime crime) {
        mCrime = crime;
        List<String> strings;
        notifyChange();
    }

    public void onCrimeClicked() {
        Intent intent = CrimePagerActivity.newIntent(mActivity, mCrime.getId());
        mActivity.startActivity(intent);
    }
}
