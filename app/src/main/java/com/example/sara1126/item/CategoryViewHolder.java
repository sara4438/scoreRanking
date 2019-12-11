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

public class CategoryViewHolder extends BaseViewHolder<Category> {
    public static class Factory extends BaseViewHolder.Factory{
        protected Map<Integer, ClickHandler> clickFuncMap;

        public Factory(@Nullable ClickFuncBuilder clickFuncBuilder) {
            super(clickFuncBuilder);
        }

        @NonNull
        public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_category, parent, false);
            return new CategoryViewHolder(view);
        }

        @Override
        public String getType() {
            return Category.TYPE;
        }
    }

    private TextView tvCatName;


    protected CategoryViewHolder(View itemView) {
        super(itemView);
        tvCatName = itemView.findViewById(R.id.item_dpt_emploee_category_tv_cat);
    }


    @Override
    public void bind(Category category) {
        tvCatName.setText(category.getCatName());

    }
}
