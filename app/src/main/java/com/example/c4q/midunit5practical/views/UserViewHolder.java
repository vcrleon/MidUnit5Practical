package com.example.c4q.midunit5practical.views;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.midunit5practical.R;
import com.example.c4q.midunit5practical.activities.MainActivity;
import com.example.c4q.midunit5practical.activities.SecondActivity;
import com.example.c4q.midunit5practical.model.Results;
import com.squareup.picasso.Picasso;

/**
 * Created by c4q on 1/24/18.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userPicture;
    TextView firstName;
    TextView lastName;

    public UserViewHolder(View itemView) {
        super(itemView);

        userPicture = itemView.findViewById(R.id.user_picture);
        firstName = itemView.findViewById(R.id.first_name);
        lastName = itemView.findViewById(R.id.last_name);
    }

    public void onBind(Results users) {
        Picasso.with(itemView.getContext())
                .load((users.getPicture().getThumbnail()))
                .into(userPicture);

        firstName.setText(users.getName().getFirst());
        lastName.setText(users.getName().getLast());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity main = (MainActivity) itemView.getContext();
                main.secondActivityIntent();
            }
        });

    }
}
