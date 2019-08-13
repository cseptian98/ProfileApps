package fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import adapter.ListTemanAdapter;
import com.example.myapps.R;
import com.example.myapps.RealmHelper;

import io.realm.Realm;
import model.Teman;

import java.util.ArrayList;
import java.util.List;

import presenter.PresenterTeman;
import view.ViewTeman;

//15-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTeman extends Fragment {

        ListTemanAdapter adapter;
        RecyclerView rvTeman;
        RealmHelper realmHelper;
        Realm realm;
        List<Teman> teman;


        public FragmentTeman() {
            // Required empty public constructor
        }

        public static FragmentTeman newInstance(){
            return new FragmentTeman();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_teman, container, false);
            rvTeman = view.findViewById(R.id.rvTeman);
            return view;
        }

        public void onViewCreated(View view, Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);

            Realm.init(view.getContext());
            realm = Realm.getDefaultInstance();
            realmHelper = new RealmHelper(realm);

            List<Teman> teman = new ArrayList<>();
            teman = realmHelper.getAllTeman();
            adapter = new ListTemanAdapter(getContext(), teman);

            rvTeman.setHasFixedSize(true);
            rvTeman.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTeman.setAdapter(adapter);
        }

        @Override
        public void onResume(){
            super.onResume();
            List<Teman> teman = new ArrayList<>();
            teman = realmHelper.getAllTeman();
            adapter = new ListTemanAdapter(getContext(), teman);

            rvTeman.setHasFixedSize(true);
            rvTeman.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTeman.setAdapter(adapter);
        }
    }
