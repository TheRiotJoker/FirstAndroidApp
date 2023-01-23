package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.myapplication.databinding.FragmentSachbearbeiterLoeschenAASBinding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SachbearbeiterLoeschenFragmentAAS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SachbearbeiterLoeschenFragmentAAS extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentSachbearbeiterLoeschenAASBinding binding;

    public SachbearbeiterLoeschenFragmentAAS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SachbearbeiterLoeschenFragmentAAS.
     */
    // TODO: Rename and change types and number of parameters
    public static SachbearbeiterLoeschenFragmentAAS newInstance(String param1, String param2) {
        SachbearbeiterLoeschenFragmentAAS fragment = new SachbearbeiterLoeschenFragmentAAS();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSachbearbeiterLoeschenAASBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        SachbearbeiterAuswaehlenK saK = new SachbearbeiterAuswaehlenK();
        SachbearbeiterLoeschenK slK = new SachbearbeiterLoeschenK();
        if(((AppCompatActivity)getActivity()) != null) {
            if(((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.sLoeschen);
            }
        }
        Spinner list = binding.sachbearbeiterList;
        ArrayList<String> sachbearbeiterArrayList = new ArrayList<>(Arrays.asList(saK.gibSachbearbeiterNamen()));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,sachbearbeiterArrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(arrayAdapter);
        binding.sLoeschenErrorView.setTextColor(Color.RED);
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s = (String) list.getSelectedItem();
                    slK.loescheSachbearbeiter(s);
                    NavHostFragment.findNavController(SachbearbeiterLoeschenFragmentAAS.this).navigate(R.id.action_sachbearbeiterLoeschenFragmentAAS_to_adminFragmentAS);
                } catch(Exception e) {
                    binding.sLoeschenErrorView.setText(e.getMessage());
                }
            }
        });
    }
}