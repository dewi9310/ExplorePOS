package com.example.dewioktaviani.explorepos.Fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dewioktaviani.explorepos.Data.clsHelper;
import com.example.dewioktaviani.explorepos.Data.common.clsItem;
import com.example.dewioktaviani.explorepos.Data.repo.clsItemRepo;
import com.example.dewioktaviani.explorepos.R;

import java.io.IOException;
import java.sql.SQLException;

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
                clsItem item = new clsItem();
                item.setItemId(1);
                item.setTxtItemCode("MLN310-92");
                item.setTxtItemName("Milna");
                item.setTxtCategory("Makanan");
                item.setTxtPrice("35.000");
                item.setTxtStock("100");
                item.setBitActive(1);
                item.setTxtVarian("");
                try {
                    new clsItemRepo(getContext()).create(item);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    new clsHelper().copydb(getContext().getApplicationContext());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getActivity(),"Success", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

//    public class ViewPagerAdapter extends FragmentPagerAdapter {
//
//
//        public ViewPagerAdapter(FragmentManager manager) {
//            super(manager);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        public void addFrag(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//    }
}
