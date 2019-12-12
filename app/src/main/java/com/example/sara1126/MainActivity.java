package com.example.sara1126;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sara1126.commonrecycler.BaseModel;
import com.example.sara1126.commonrecycler.CommonAdapter;
import com.example.sara1126.item.Employee;
import com.example.sara1126.item.EmployeeViewHolder;
import com.example.sara1126.item.Student;
import com.example.sara1126.item.StudentViewHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList <BaseModel> students;
    private Button btnAdd;
    private Button btnSortBySeat;
    private CommonAdapter commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.main_btn_add_student);
        btnSortBySeat = findViewById(R.id.main_btn_sort_by_seat);
        students = new ArrayList<>();
        students.add(new Student("student1",1, 80, 90));
        students.add(new Student("student2",2, 70, 95));
        students.add(new Student("student3",3, 100, 60));
        students.add(new Student("student4",4, 60, 55));
        students.add(new Student("student5",5, 85, 75));
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);  //決定布局方向


        RecyclerView recyclerView = findViewById(R.id.rv_students_info);
        recyclerView.setLayoutManager(layoutManager);

        commonAdapter = new CommonAdapter(new StudentViewHolder.Factory(null));
                )
        );
        commonAdapter.bindDataSource(students);
        recyclerView.setAdapter(commonAdapter);
        init();
//        setBtnAdd();
        setBtnSortBySeat();

    }
    public void init(){
        btnAdd = findViewById(R.id.main_btn_add_student);
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
                        for (int i = students.size() - 1; i > 0; i--) {
                            int insert = i+1;
                            if (etCategory.getText().toString().equals(students.get(i).getCatName())) {
                                students.add(insert, new Employee( etCategory.getText().toString(), etName.getText().toString()
                                        , etTitle.getText().toString())) ;
                                match = true;
                                break;
                            }
                        }
                        if(!match) {
                            students.add(new Category(etCategory.getText().toString()));
                            students.add(new Employee(etCategory.getText().toString(), etName.getText().toString()
                                    ,etTitle.getText().toString()));
                        }
                        commonAdapter.notifyDataSetChanged();
                        addDialog.dismiss();
                    }
                });
            }
        });
    }
    public void setBtnSortBySeat(){
        btnSortBySeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortBySeat(students);
            }
        });
    }
    public void sortBySeat(ArrayList<BaseModel> arr){
        sortBySeat(arr, 0, arr.size()-1);
    }
    public static void sortBySeat(ArrayList<BaseModel> a, int left, int right){
        if(left >= right)
            return;
        int i = left + 1;
        int j = right;
        BaseModel pivot = a.get(left);
        do{
            while(i <= right && a.get(i).getSeat() < pivot.getSeat()) i++;
            while(a.get(j).getSeat() > pivot.getSeat()) j--;
            if(i >= j){
                break;
            }
            swap(a, i, j);
        }while(true);
        swap(a, left, j);
        sortBySeat(a, left, j-1);
        sortBySeat(a, j+1, right);
    }
    public static void swap(ArrayList<BaseModel> arr, int i, int j){
        BaseModel tmp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j, tmp);
    }

}
