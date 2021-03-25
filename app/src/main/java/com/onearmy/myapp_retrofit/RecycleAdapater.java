package com.onearmy.myapp_retrofit;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapater extends RecyclerView.Adapter<RecycleAdapater.ViewHolder> {

    private List<JasonPlaceHolder> holders;

    public RecycleAdapater(List<JasonPlaceHolder> holders) {
        this.holders = holders;
    }

    @NonNull
    @Override
    public RecycleAdapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapater.ViewHolder holder, int position)
    {
        JasonPlaceHolder item = holders.get(position);
        holder.userId.setText(item.getUserId());
        Log.d("myerror", "onBindViewHolder: " + item.getUserId());

    }

    @Override
    public int getItemCount() {
        return holders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId =(TextView)itemView.findViewById(R.id.textView);

        }

    }
}
