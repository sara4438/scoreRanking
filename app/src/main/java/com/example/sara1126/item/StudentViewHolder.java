package com.example.sara1126.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sara1126.R;
import com.example.sara1126.commonrecycler.BaseViewHolder;

import java.util.Map;

public class StudentViewHolder extends BaseViewHolder<Student> {

    public static class Factory extends BaseViewHolder.Factory{
        protected Map<Integer, ClickHandler> clickFuncMap;

        public Factory(@Nullable ClickFuncBuilder clickFuncBuilder) {
            super(clickFuncBuilder);
        }

        @NonNull
        public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_student, parent, false);
            return new EmployeeViewHolder(view);
        }

        @Override
        public String getType() {
            return Employee.TYPE;
        }

        @Override
        public int getSeat() {
            return 0;
        }
    }

    private TextView tvName;
    private TextView tvSeat;
    private TextView tvEng;
    private TextView tvMath;


    protected StudentViewHolder(View itemView) {
        super(itemView);
        tvMath = itemView.findViewById(R.id.item_student_math);
        tvEng = itemView.findViewById(R.id.item_student_eng);
        tvName = itemView.findViewById(R.id.item_dpt_emploee_info_tv_name);
        tvSeat = itemView.findViewById(R.id.item_student_seat);
    }
        @Override
        public void bind(Student baseModel) {
            tvMath.setText(baseModel.getMathScore());
            tvEng.setText(baseModel.getEngScore());
            tvSeat.setText(baseModel.getSeat());
            tvName.setText(baseModel.getName());
        }

}
