package com.example.sara1126.commonrecycler;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseViewHolder<T extends BaseModel> extends RecyclerView.ViewHolder{
    public abstract static class Factory implements BaseModel{
        protected Map<Integer, ClickHandler> clickFuncMap;

        public Factory(@Nullable ClickFuncBuilder clickFuncBuilder){
            if(clickFuncBuilder != null)
                this.clickFuncMap = clickFuncBuilder.getMap();
        }

        @NonNull
        public abstract BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
    }
    public static class ClickFuncBuilder{
        private Map<Integer, ClickHandler> clickFuncMap; //不用arrayList是因為要知道是第幾個
        public ClickFuncBuilder(){
            this.clickFuncMap = new HashMap<>();
        }
        public ClickFuncBuilder add(Integer resourceId, ClickHandler clickHandler){
            this.clickFuncMap.put(resourceId, clickHandler);
            return this;
        }
        private Map<Integer, ClickHandler> getMap(){
            return this.clickFuncMap;
        }
    }
    public interface ClickHandler{
        void onClick(int position);
    }

    protected BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T baseModel);

}
