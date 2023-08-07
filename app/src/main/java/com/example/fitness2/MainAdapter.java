package com.example.fitness2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.sanmyViewHolder1> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    public void onBindViewHolder(@NonNull sanmyViewHolder1 holder, int position, @NonNull MainModel model) {

        //getting the data using holder class from DB
        holder.name.setText(model.getName());
        holder.duration.setText(model.getDuration());
        holder.sets.setText(model.getSets());

        Glide.with(holder.img1.getContext())
                .load(model.url)
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img1);

    }

    @NonNull
    @Override
    public sanmyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sanview1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_item,parent,false);
        return new sanmyViewHolder1(sanview1);
    }

    class sanmyViewHolder1  extends RecyclerView.ViewHolder{

        CircleImageView img1;
        TextView name,duration, sets;

        //assign the data fetch
        public sanmyViewHolder1(@NonNull View itemView) {
            super(itemView);
            img1 = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.exnametxt);
            duration = (TextView)itemView.findViewById(R.id.exdurationtxt);
            sets = (TextView)itemView.findViewById(R.id.exsettxt);
        }
    }
}
