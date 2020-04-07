package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdaptor extends RecyclerView.Adapter<ContactAdaptor.ContactViewHolder> {

    private String[] contacts = new String[20];

    public ContactAdaptor() {
        contacts[0]="Ruthann Trustrie";
        contacts[1]="Peadar Dawtrey";
        contacts[2]="Felipe Bradtke";
        contacts[3]="Claude Crissil";
        contacts[4]="Jacky Girardeau";
        contacts[5]="Rubia Dominguez";
        contacts[6]="Michaela Churchley";
        contacts[7]="Harvey Pentelow";
        contacts[8]="Neilla Langton";
        contacts[9]="Marco Greaves";
        contacts[10]="Liz Batchley";
        contacts[11]="Lamond Littlepage";
        contacts[12]="Malina Weir";
        contacts[13]="Tomlin Lenchenko";
        contacts[14]="Hy Pavelin";
        contacts[15]="Jenelle Palin";
        contacts[16]="Damon Knewstubb";
        contacts[17]="Alex Ivanusyev";
        contacts[18]="Hamil Callery";
        contacts[19]="Karol Syer";

    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindContact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView FullName_tv;
        private TextView FirstChar_tv;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            FullName_tv = itemView.findViewById(R.id.tv_fullName);
            FirstChar_tv = itemView.findViewById(R.id.tv_firstChar);
        }
        public void bindContact(String fullname){
            FullName_tv.setText(fullname);
            FirstChar_tv.setText(fullname.substring(0,1));
        }
    }
}

