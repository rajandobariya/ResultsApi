package com.example.resultsapi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.resultsapi.R;
import com.example.resultsapi.model.Data;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context context;
    ArrayList<Data> data;

    public DataAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder holder, int position) {
        holder.gender.setText("gender :- " + data.get(position).gender);
        holder.email.setText("email :- " + data.get(position).email);
        holder.nat.setText("nat :- " + data.get(position).nat);
        holder.phone.setText("phone :- " + data.get(position).phone);
        holder.cell.setText("cell :- " + data.get(position).cell);
        holder.title.setText("title :- " + data.get(position).name.title);
        holder.firstname.setText("firstname :- " + data.get(position).name.firstname);
        holder.lastname.setText("lastname :- " + data.get(position).name.lastname);
        holder.city.setText("city :- " + data.get(position).location.city);
        holder.state.setText("state :- " + data.get(position).location.state);
        holder.country.setText("country :- " + data.get(position).location.country);
        holder.postcode.setText("postcode :- " + data.get(position).location.postcode);
        holder.name.setText("name :- " + data.get(position).location.street.name);
        holder.number.setText("number :- " + data.get(position).location.street.number);
        Glide.with(context)
                .asBitmap()
                .load(data.get(position).picture.large)
                .into(holder.large);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView gender, email, nat, phone, cell, title, firstname, lastname, city, state, country, postcode, name, number;

        ImageView large;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.gender);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            cell = itemView.findViewById(R.id.cell);
            nat = itemView.findViewById(R.id.nat);
            title = itemView.findViewById(R.id.title);
            firstname = itemView.findViewById(R.id.firstname);
            lastname = itemView.findViewById(R.id.lastname);
            city = itemView.findViewById(R.id.city);
            state = itemView.findViewById(R.id.state);
            country = itemView.findViewById(R.id.country);
            postcode = itemView.findViewById(R.id.postcode);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            large =itemView.findViewById(R.id.large);
        }
    }
}
