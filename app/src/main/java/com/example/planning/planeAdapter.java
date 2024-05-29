package com.example.planning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class planeAdapter extends RecyclerView.Adapter<planeAdapter.BudgetViewHolder> {
    private List<PlaneItem> planeItems;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class BudgetViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPrice, tvItem, tvType;

        public BudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.priority);
            tvItem = itemView.findViewById(R.id.description);
            //tvType = itemView.findViewById(R.id.);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    public planeAdapter(List<PlaneItem> planeItems) {
        this.planeItems = planeItems;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_budget, parent, false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        PlaneItem item = planeItems.get(position);
        holder.tvPrice.setText(item.getPrice());
        holder.tvItem.setText(item.getItem());
        // holder.tvType.setText(item.getType());
    }

    @Override
    public int getItemCount() {
        return planeItems.size();
    }
}