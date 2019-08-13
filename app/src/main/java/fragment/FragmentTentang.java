package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.myapps.R;

import presenter.PresenterAbout;
import view.ViewTentang;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTentang extends Fragment implements ViewTentang {

    int tab;
    LinearLayout tabInfo, tabAuthor;
    PresenterAbout presenter;

    public FragmentTentang() {
        // Required empty public constructor
    }

    public static FragmentTentang newInstance(int tab){
        FragmentTentang fragment = new FragmentTentang();
        Bundle args = new Bundle();
        args.putInt("tab", tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tentang,container,false);

        tabInfo = view.findViewById(R.id.tabInfo);
        tabAuthor = view.findViewById(R.id.tabAuthor);

        presenter = new PresenterAbout(this);

        if (getArguments() != null){
            tab = getArguments().getInt("tab");
            presenter.selectionView(tab);
        }
        return view;
    }

    @Override
    public void showInfo(){
        tabInfo.setVisibility(View.VISIBLE);
        tabAuthor.setVisibility(View.GONE);
    }
    @Override
    public void showAuthor(){
        tabInfo.setVisibility(View.GONE);
        tabAuthor.setVisibility(View.VISIBLE);
    }
}
