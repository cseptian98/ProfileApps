package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapps.DetailTeman;
import com.example.myapps.R;
import java.util.List;

import model.Teman;

//3-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class ListTemanAdapter extends RecyclerView.Adapter<ListTemanAdapter.CategoryViewHolder> {

    private List<Teman> teman;
    Context context;

    public ListTemanAdapter(Context context, List<Teman> teman){
        this.context = context;
        this.teman = teman;
    }

    @Override
    public ListTemanAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teman, parent, false);
        return new CategoryViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ListTemanAdapter.CategoryViewHolder holder, int position){
        final Teman model = teman.get(position);
        holder.nim.setText(model.getNim());
        holder.nama.setText(model.getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailTeman.class);
                intent.putExtra("id", model.getId().toString());
                intent.putExtra("nim", model.getNim());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("kelas", model.getKelas());
                intent.putExtra("email", model.getEmail());
                intent.putExtra("sosmed", model.getSosmed());
                intent.putExtra("telp", model.getTelp());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return teman.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kelas, email, sosmed, telp;

        public CategoryViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNIM);
            nama = itemView.findViewById(R.id.tvNama);
        }
    }
}
