package com.example.test;

import android.content.ContentProviderClient;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdaptor extends RecyclerView.Adapter<ContactAdaptor.ContactViewHolder> {

    private ArrayList<String> contacts = new ArrayList<>();
    private ItemEventListener itemEventListener;

    public ContactAdaptor(ItemEventListener itemEventListener) {
        this.itemEventListener = itemEventListener;
        contacts.add("Ruthann Trustrie");
        contacts.add("Peadar Dawtrey");
        contacts.add("Felipe Bradtke");
        contacts.add("Claude Crissil");
        contacts.add("Jacky Girardeau");
        contacts.add("Rubia Dominguez");
        contacts.add("Michaela Churchley");
        contacts.add("Harvey Pentelow");
        contacts.add("Neilla Langton");
        contacts.add("Marco Greaves");
        contacts.add("Liz Batchley");
        contacts.add("Lamond Littlepage");
        contacts.add("Malina Weir");
        contacts.add("Tomlin Lenchenko");
        contacts.add("Hy Pavelin");
        contacts.add("Jenelle Palin");
        contacts.add("Damon Knewstubb");
        contacts.add("Alex Ivanusyev");
        contacts.add("Hamil Callery");
        contacts.add("Karol Syer");
    }

    public void addNewContact(String fullName ){
        contacts.add(0,fullName);
        notifyItemInserted(0);
    }

    public void updateContact(String fullName,int position){
        contacts.set(position,fullName);
        notifyItemChanged(position);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView FullName_tv;
        private TextView FirstChar_tv;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            FullName_tv = itemView.findViewById(R.id.tv_fullName);
            FirstChar_tv = itemView.findViewById(R.id.tv_firstChar);
        }
        public void bindContact(final String fullname){
            FullName_tv.setText(fullname);
            FirstChar_tv.setText(fullname.substring(0,1));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(v.getContext(),fullname, Toast.LENGTH_SHORT).show();
                    itemEventListener.onItemClick(fullname,getAdapterPosition());
                }
            });
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        contacts.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        return false;
                    }
                });

        }
    }

    public interface ItemEventListener{
        void onItemClick(String fullName,int position);

    }
}

