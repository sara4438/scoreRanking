package com.example.sara1126;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sara1126.commonrecycler.BaseModel;
import com.example.sara1126.commonrecycler.CommonAdapter;
import com.example.sara1126.item.Category;
import com.example.sara1126.item.CategoryViewHolder;
import com.example.sara1126.item.Employee;
import com.example.sara1126.item.EmployeeViewHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList <BaseModel> arrayList;
    private Button btnAdd;
    private CommonAdapter commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        arrayList.add(new Category("d1"));
        arrayList.add(new Employee("d1", "n1", "t1"));
        arrayList.add(new Employee("d1", "n2", "t2"));
        arrayList.add(new Category("d2"));
        arrayList.add(new Employee("d2", "n3", "t3"));
        arrayList.add(new Category("d3"));
        arrayList.add(new Employee("d3", "n4", "t4"));
        arrayList.add(new Category("d4"));
        arrayList.add(new Employee("d4", "n5", "t5"));
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);  //決定布局方向


        RecyclerView recyclerView = findViewById(R.id.rv_employee_info);
        recyclerView.setLayoutManager(layoutManager);

        commonAdapter = new CommonAdapter(
                    Arrays.asList(
                            new EmployeeViewHolder.Factory(null),
                            new CategoryViewHolder.Factory(null)
                )
        );
        commonAdapter.bindDataSource(arrayList);
        recyclerView.setAdapter(commonAdapter);
        init();
        setBtnAdd();
    }
    public void init(){
        btnAdd = findViewById(R.id.main_btn_add);
    }
    public void setBtnAdd(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View view = inflater.inflate(R.layout.dialog_add, null); //不需要他的父元件
                final Dialog addDialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(view)
                        .setCancelable(false)
                        .show();
                final EditText etCategory = view.findViewById(R.id.dialog_add_category);
                final EditText etName = view.findViewById(R.id.dialog_add_name);
                final EditText etTitle = view.findViewById(R.id.dialog_add_title);
                final Button btnAdd = view.findViewById(R.id.dialog_add_btn_add);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean match = false;
                        for (int i = arrayList.size() - 1; i > 0; i--) {
                            int insert = i+1;
                            if (etCategory.getText().toString().equals(arrayList.get(i).getCatName())) {
                                arrayList.add(insert, new Employee( etCategory.getText().toString(), etName.getText().toString()
                                        , etTitle.getText().toString())) ;
                                match = true;
                                break;
                            }
                        }
                        if(!match) {
                            arrayList.add(new Category(etCategory.getText().toString()));
                            arrayList.add(new Employee(etCategory.getText().toString(), etName.getText().toString()
                                    ,etTitle.getText().toString()));
                        }
                        commonAdapter.notifyDataSetChanged();
                        addDialog.dismiss();
                    }
                });
            }
        });
    }


}
