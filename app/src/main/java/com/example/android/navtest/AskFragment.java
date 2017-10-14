package com.example.android.navtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.pavlospt.CircleView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AskFragment extends Fragment  {

    public AskFragment() {
        // Required empty public constructor
    }
    private TabLayout _homeTabLayout;
    private ViewPager _homeViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // here binistilaize el-5ara dh 3ady , el-view pager w el-dnya de
        View v = inflater.inflate(R.layout.fragment_ask,container,false);
        CircleView cv=(CircleView) v.findViewById(R.id.circle);
        final TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        setupViewPager(viewPager);
        cv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), Ask_Search.class);
                getActivity().startActivity(i);
                (getActivity()).overridePendingTransition(0,0);
    }
});
        tabLayout.setupWithViewPager(viewPager);
        return v;
        }

private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter  adapter = new ViewPagerAdapter (getChildFragmentManager());
        adapter.addFragment(new Ask_ReceivedFragment(), "Received");
        adapter.addFragment(new Ask_SentFragment(), "Sent"); // elenet 5ara , el-mohemm de tab wat ?  hena b2a bzbt el-pager nfso 2no ya5od el- 2 fragments dol
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
