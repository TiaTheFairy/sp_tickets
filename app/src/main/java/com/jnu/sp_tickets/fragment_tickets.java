package com.jnu.sp_tickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class fragment_tickets extends Fragment {

    private List<Ticket> ticketList;
    private MyRecyclerViewAdapter recyclerViewAdapter;

    private FloatingActionButton button_add;
    private AlertDialog dialog_add;

    public fragment_tickets(){

    }

    public static fragment_tickets newInstance(){
        fragment_tickets fragment = new fragment_tickets();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_tickets, container, false);

        initData();

        RecyclerView view_tickets = rootView.findViewById(R.id.tickets_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        view_tickets.setLayoutManager(layoutManager);
        recyclerViewAdapter = new MyRecyclerViewAdapter(ticketList);
        view_tickets.setAdapter(recyclerViewAdapter);

        FloatingActionButton tickets_add = rootView.findViewById(R.id.tickets_newButton);
        tickets_add.setOnClickListener(view ->{
            dialog_add.show();
        });

        return rootView;
    }

    public void initData(){
        ticketList = new ArrayList<Ticket>();
        ticketList.add(new Ticket("Delivery","Awaiting","$3.00","cainiao","5 mins"));
        ticketList.add(new Ticket("Takeaway","Expired","$10.00","waimaijia","15 mins"));
    }

    private static class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
        private List<Ticket> ticketList;

        public MyRecyclerViewAdapter(List<Ticket> ticketList){
            this.ticketList = ticketList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_ticket, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
            holder.getTickets_type().setText(ticketList.get(position).getTicketType());
            holder.getTickets_state().setText(ticketList.get(position).getTicketState());
            holder.getTickets_income().setText(ticketList.get(position).getTicketIncome());
            holder.getTickets_location().setText(ticketList.get(position).getTicketLocation());
            holder.getTickets_duration().setText(ticketList.get(position).getTicketDuration());
        }

        @Override
        public int getItemCount(){
            return ticketList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView tickets_type;
            private TextView tickets_state;
            private TextView tickets_income;
            private TextView tickets_location;
            private TextView tickets_duration;

            public MyViewHolder(View itemView){
                super(itemView);
                tickets_type = itemView.findViewById(R.id.tickets_type);
                tickets_state = itemView.findViewById(R.id.tickets_state);
                tickets_income = itemView.findViewById(R.id.tickets_income);
                tickets_location = itemView.findViewById(R.id.tickets_location);
                tickets_duration = itemView.findViewById(R.id.tickets_duration);
            }

            public TextView getTickets_type(){
                return tickets_type;
            }

            public TextView getTickets_state(){
                return tickets_state;
            }

            public TextView getTickets_income(){
                return tickets_income;
            }

            public TextView getTickets_location(){
                return tickets_location;
            }

            public TextView getTickets_duration(){
                return tickets_duration;
            }
        }
    }
}