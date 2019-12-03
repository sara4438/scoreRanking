package com.example.sara1126.commonrecycler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sara1126.Member;
import com.example.sara1126.R;

import java.util.Map;

public class ItemViewHolder extends BaseViewHolder<Member> {
    public static class Factory extends BaseViewHolder.Factory{
        protected Map<Integer, ClickHandler> clickFuncMap;

        public Factory(@Nullable ClickFuncBuilder clickFuncBuilder) {
            super(clickFuncBuilder);
        }

        @NonNull
        public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_info_item_member, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public String getType() {
            return Member.TYPE;
        }
    }

    private TextView tvAccount;
    private TextView tvName;
    private TextView tvPhoneNum;
    private TextView tvBirth;

    protected ItemViewHolder(View itemView) {
        super(itemView);

        tvAccount = itemView.findViewById(R.id.user_info_tv_account);
        tvName = itemView.findViewById(R.id.user_info_tv_name);
        tvPhoneNum = itemView.findViewById(R.id.user_info_tv_phone_num);
        tvBirth = itemView.findViewById(R.id.user_info_tv_birth);
    }

    @Override
    public void bind(Member member) {
        tvAccount.setText(member.getAccount());
        tvName.setText(member.getName());
        tvPhoneNum.setText(member.getPhoneNum());
        tvBirth.setText(member.getBirth());
    }
}
