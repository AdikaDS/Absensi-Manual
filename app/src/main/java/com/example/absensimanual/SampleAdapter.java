package com.example.absensimanual;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SampleAdapter extends FragmentStateAdapter {

    public SampleAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            FirstFragment f1 = new FirstFragment();
            return f1;
        } else {
            SecondFragment f2 = new SecondFragment();
            return f2;
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
