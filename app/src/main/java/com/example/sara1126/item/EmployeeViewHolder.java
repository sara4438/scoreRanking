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

public class EmployeeViewHolder extends BaseViewHolder<Employee> {
    public static class Factory extends BaseViewHolder.Factory{
        protected Map<Integer, ClickHandler> clickFuncMap;

        public Factory(@Nullable ClickFuncBuilder clickFuncBuilder) {
            super(clickFuncBuilder);
        }

        @NonNull
        public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_employee, parent, false);
            return new EmployeeViewHolder(view);
        }

        @Override
        public String getType() {
            return Employee.TYPE;
        }
    }

    private TextView tvName;
    private TextView tvTitle;


    protected EmployeeViewHolder(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.item_dpt_emploee_info_tv_name);
        tvTitle = itemView.findViewById(R.id.item_dpt_emploee_info_tv_title);
}


    @Override
    public void bind(Employee employee) {
        tvTitle.setText(employee.getTitle());
        tvName.setText(employee.getName());

    }
}
