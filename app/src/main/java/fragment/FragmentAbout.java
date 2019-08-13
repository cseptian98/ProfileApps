package fragment;


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

import com.example.myapps.R;

/**
 * A simple {@link Fragment} subclass.
 */

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class FragmentAbout extends Fragment {

    TabLayout tabTentang;
    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;

    public FragmentAbout() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        tabTentang = view.findViewById(R.id.tabTentang);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabTentang));
        tabTentang.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    class SectionsPagerAdapter extends FragmentPagerAdapter {
        SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int i){
            Fragment fragment = new Fragment();
            if(i == 0){
                fragment = FragmentTentang.newInstance(0);
            } else if(i == 1){
                fragment = FragmentTentang.newInstance(1);
            }
            return fragment;
        }
        @Override
        public int getCount(){
            return 2;
        }
    }

    public static FragmentAbout newInstance(){
        return new FragmentAbout();
    }
}
