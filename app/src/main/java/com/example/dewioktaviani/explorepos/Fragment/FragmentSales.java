package com.example.dewioktaviani.explorepos.Fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dewioktaviani.explorepos.Data.clsHelper;
import com.example.dewioktaviani.explorepos.R;

import java.io.IOException;

public class FragmentSales extends Fragment {

    View v;
    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment_sales, container, false);

        btnSave = (Button) v.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new clsHelper().copydb(getContext().getApplicationContext());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }
}
