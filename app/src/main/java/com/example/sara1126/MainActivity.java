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
import android.widget.Toast;

import com.example.sara1126.commonrecycler.BaseModel;
import com.example.sara1126.commonrecycler.CommonAdapter;
import com.example.sara1126.commonrecycler.CompareByEng;
import com.example.sara1126.commonrecycler.Comparator;
import com.example.sara1126.commonrecycler.CompareByMath;
import com.example.sara1126.commonrecycler.CompareBySeat;
import com.example.sara1126.item.Student;
import com.example.sara1126.item.StudentViewHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList <BaseModel> students;
    private Button btnAdd;
    private Button btnSortBySeat;
    private Button btnSortByEngScore;
    private Button btnSortByMathScore;
    static private CommonAdapter commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.main_btn_add_student);
        btnSortBySeat = findViewById(R.id.main_btn_sort_by_seat);
        btnSortByEngScore = findViewById(R.id.main_btn_sort_by_eng);
        btnSortByMathScore = findViewById(R.id.main_btn_sort_by_math);
        students = new ArrayList<>();

        students.add(new Student("student2",2, 70 ,90));
        students.add(new Student("student4",4, 60, 56));
        students.add(new Student("student1",1, 80, 67));
        students.add(new Student("student3",3, 100,78));
        students.add(new Student("student5",5, 85, 99));
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);  //決定布局方向


        RecyclerView recyclerView = findViewById(R.id.rv_students_info);
        recyclerView.setLayoutManager(layoutManager);

        commonAdapter = new CommonAdapter(Arrays.asList(new StudentViewHolder.Factory(null)));
        commonAdapter.bindDataSource(students);
        recyclerView.setAdapter(commonAdapter);
        init();
//        setBtnAdd();
        setBtnSortBySeat();
        setBtnSortByEngScore();
        setBtnSortByMathScore();
        setBtnAdd();
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
                        .setCancelable(true)
                        .show();
                final EditText etName = view.findViewById(R.id.dialog_add_name);
                final EditText etSeat = view.findViewById(R.id.dialog_add_seat);
                final EditText etEngScore = view.findViewById(R.id.dialog_add_engScore);
                final EditText etMathScore = view.findViewById(R.id.dialog_add_mathScore);
                final Button btnAdd = view.findViewById(R.id.dialog_add_btn_add);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(etName.getText().toString().equals("") || etSeat.getText().toString().equals("") ||
                        etEngScore.getText().toString().equals("") || etMathScore.getText().toString().equals("")){
                            showToast(R.string.dialog_add_notComplete);
                        }else {
                            students.add(new Student(etName.getText().toString(), Integer.parseInt(etSeat.getText().toString()),
                                    Integer.parseInt(etEngScore.getText().toString()), Integer.parseInt(etMathScore.getText().toString())));
                            commonAdapter.notifyDataSetChanged();
                            addDialog.dismiss();
                        }
                    }
                });
            }
        });
    }
    public void setBtnSortByEngScore(){
        btnSortByEngScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort(students,new CompareByEng(students));
                commonAdapter.notifyDataSetChanged();
            }
        });
    }
    public void setBtnSortByMathScore(){
        btnSortByMathScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort(students,new CompareByMath(students));
                commonAdapter.notifyDataSetChanged();
            }
        });
    }
    public void setBtnSortBySeat(){
        btnSortBySeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort(students,new CompareBySeat(students));
                commonAdapter.notifyDataSetChanged();
            }
        });
    }
    public void sort(ArrayList<BaseModel> arr , Comparator comparator){
        comparator.sort(arr, 0, arr.size()-1);
    }
    public void showToast(int msgId){
        Toast.makeText(this, msgId, Toast.LENGTH_LONG).show();
    }


}
