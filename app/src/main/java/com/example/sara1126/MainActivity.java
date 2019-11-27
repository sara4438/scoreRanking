package com.example.sara1126;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList <Member> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        arrayList.add(new Member("test1", "test1", "0912345678", "1990/07/28"));
        arrayList.add(new Member("test2", "test2", "0912345678", "1990/07/28"));
        arrayList.add(new Member("test3", "test3", "0912345678", "1990/07/28"));
        arrayList.add(new Member("test4", "test1", "0912345678", "1990/07/28"));
        arrayList.add(new Member("test5", "test2", "0912345678", "1990/07/28"));
        arrayList.add(new Member("test6", "test3", "0912345678", "1990/07/28"));
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);  //決定布局方向

        RecyclerView recyclerView = findViewById(R.id.rv_test);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdpapter adapter = new CustomAdpapter(arrayList);
        recyclerView.setAdapter(adapter);

    }

    public static class CustomAdpapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
        private ArrayList<Member> data;

        public CustomAdpapter (ArrayList <Member> arrayList){ //如果是參考資料型態 =>會動到外面實體
            data = new ArrayList<>(arrayList); //拷貝,進去 不會動到外面資料
        }


        private class ItemViewHolder extends RecyclerView.ViewHolder{
             TextView tvAccount;
             TextView tvName;
             TextView tvPhoneNum;
             TextView tvBirth;


            public ItemViewHolder(@NonNull View itemView) { //決定每個view的呈現方式, 裡面包一個view
                super(itemView);
                tvAccount = itemView.findViewById(R.id.user_info_tv_account);
                tvName = itemView.findViewById(R.id.user_info_tv_name);
                tvPhoneNum = itemView.findViewById(R.id.user_info_tv_phone_num);
                tvBirth = itemView.findViewById(R.id.user_info_tv_birth);

//                        .setOnClickListener(new View.OnClickListener() { //只要是view就可以setOnClickListener
//                    @Override
//                    public void onClick(View v) {
////                        tvTest.setText(getLayoutPosition()+"");  //點擊當下他在Layout的位置 回傳我點下是哪個位置
//                    data.set(getLayoutPosition(), getLayoutPosition()+ ""); //一開始點沒反應, 滑一滑變數字
////                    CustomAdpapter.this.notifyItemChanged(getLayoutPosition()); //淡出動畫
//                      CustomAdpapter.this.notifyDataSetChanged(); //全部刷新, 耗效能, 沒動畫
//                    }
//                });
            }
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()) //用元件找context (activity)
                    .inflate(R.layout.user_infi_item_member, parent, false);//一定要是false
            return new ItemViewHolder(view); //將view包裝成view holder
        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {  //position:當前綁定的原件在整個列表(顯示的)是第幾個
            ItemViewHolder ivh = (ItemViewHolder)holder; //降轉
//            ivh.tvTest.setText(data.get(position));
            Member member = data.get(position);
            ivh.tvAccount.setText(member.getAccount());
            ivh.tvName.setText(member.getName());
            ivh.tvBirth.setText(member.getBirth());
            ivh.tvPhoneNum.setText(member.getPhoneNum());
            //可能需要把adapter改成全域變數
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}
