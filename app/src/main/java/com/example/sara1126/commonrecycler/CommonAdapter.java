package com.example.sara1126.commonrecycler;


import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private List<? extends BaseViewHolder.Factory> factories; //通配字元 可以傳BaseViewHolder子類別, 以利二次開發
    private Map<String, Integer> typeMap;

    private List<BaseModel> modelList; //如果用通配字元 , 就不能用function, 不建議

    public CommonAdapter(List<? extends BaseViewHolder.Factory> factories){
        this.factories = factories;
        this.typeMap = new HashMap<>();
        /* type mapping */
        int count = factories.size();
        for(int i=0;i<count;i++){
            BaseViewHolder.Factory factory = factories.get(i);// 這是對應位置的工廠
            typeMap.put(factory.getType(), i);// 工廠的TYPE 對應到 Array的位置
        }
        /* type mapping end*/
    }

    @Override
    public int getItemViewType(int position) {
        return typeMap.get(modelList.get(position).getType());
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        BaseViewHolder.Factory factory = factories.get(i);
        return factory.onCreateViewHolder(parent, i);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    /* data binding */
    public void bindDataSource(List<BaseModel> models) {
        this.modelList = models;
        notifyDataSetChanged();
    }
    public void addData(BaseModel model){
        this.modelList.add(model);
        notifyItemInserted(this.modelList.size() - 1);
    }
    public void removeData(int position){
        this.modelList.remove(position);
        notifyItemRemoved(position);
    }
}
