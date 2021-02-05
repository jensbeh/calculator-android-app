package com.claculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class calcHistoryAdapter extends RecyclerView.Adapter<calcHistoryAdapter.calcHistoryViewHolder> {
    private ArrayList<String> calcList;
    private ArrayList<String> resultList;
    private OnItemClickListener itemListener;


    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemCLickListener (OnItemClickListener listener) {
        itemListener = listener;
    }

    public static class calcHistoryViewHolder extends RecyclerView.ViewHolder {
        public TextView calcTextView;
        public TextView resultTextView;

        public calcHistoryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            calcTextView = itemView.findViewById(R.id.calcListText);
            resultTextView = itemView.findViewById(R.id.resultListText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public void clearHistory() {
        if (calcList.size() != 0 && resultList.size() != 0) {
            calcList.clear();
            resultList.clear();
        }
    }

    public calcHistoryAdapter(ArrayList<String> calcList, ArrayList<String> resultList) {
        this.calcList = calcList;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public calcHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cell, parent, false);
        return new calcHistoryViewHolder(v, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull calcHistoryViewHolder holder, int position) {
        String currentCalc = calcList.get(position);
        String currentResult = resultList.get(position);

        holder.calcTextView.setText(currentCalc);
        holder.resultTextView.setText("= " + currentResult);
    }

    @Override
    public int getItemCount() {
        return calcList.size();
    }


}
