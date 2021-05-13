package com.example.middle_term_nhom_t5.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.middle_term_nhom_t5.Model.Shirt;
import com.example.middle_term_nhom_t5.R;
import com.example.middle_term_nhom_t5.adapter.ShirtAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JustForFunFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JustForFunFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Shirt> shirtList;
    private ShirtAdapter shirtAdapter;
    private RecyclerView recyclerView;

    public JustForFunFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JustForFunFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JustForFunFragment newInstance(String param1, String param2) {
        JustForFunFragment fragment = new JustForFunFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_just_for_fun, container, false);

        shirtList = loadData();
        shirtAdapter = new ShirtAdapter(getContext());
        shirtAdapter.setData(shirtList);

        recyclerView = view.findViewById(R.id.justforfun_rcv);
        recyclerView.setAdapter(shirtAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }

    private List<Shirt> loadData() {
        List<Shirt> shirts = new ArrayList<>();
        shirts.add(new Shirt(1, "Google", 10, R.drawable.images1_google));
        shirts.add(new Shirt(2, "Google Black", 12, R.drawable.images2_google_black));
        shirts.add(new Shirt(3, "Google Blue", 8, R.drawable.images3_google_blue));
        shirts.add(new Shirt(4, "Google Code", 10, R.drawable.images4_google_code));
        shirts.add(new Shirt(5, "Google", 10, R.drawable.images1_google));
        shirts.add(new Shirt(6, "Google Black", 12, R.drawable.images2_google_black));
        shirts.add(new Shirt(7, "Google Blue", 8, R.drawable.images3_google_blue));
        shirts.add(new Shirt(8, "Google Code", 10, R.drawable.images4_google_code));
        return shirts;
    }

}