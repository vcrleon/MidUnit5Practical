package com.example.c4q.midunit5practical.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.midunit5practical.R;
import com.example.c4q.midunit5practical.model.Results;
import com.example.c4q.midunit5practical.views.UserViewHolder;

import java.util.List;

/**
 * Created by c4q on 1/24/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    List<Results> userResultsList;

    public UserAdapter(List<Results> userResultsList) {
        this.userResultsList = userResultsList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cv = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_itemview, parent, false);
        return new UserViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Results users = userResultsList.get(position);
        holder.onBind(users);

    }

    @Override
    public int getItemCount() {
        return userResultsList.size();
    }

}
